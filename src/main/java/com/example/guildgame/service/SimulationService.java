package com.example.guildgame.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.example.guildgame.domain.*;
import com.example.guildgame.domain.enums.*;
import com.example.guildgame.util.ResetState;

@Service
//Breaking this service into multiple services 
public class SimulationService {
	
	
	private final AuditCommentService auditCommentService;
	private final GenerateWeeklyQuestService generateWeeklyQuestService;
	

	public SimulationService(AuditCommentService auditCommentService, GenerateWeeklyQuestService generateWeeklyQuestService) {
		super();
		this.auditCommentService = auditCommentService;
		this.generateWeeklyQuestService = generateWeeklyQuestService;
	}
	
	
// A big big method handling week change commands the core of the game 
	// generates audit report create new quests 
	public AuditReport simulate(GameState state) {

		AuditReport audit = new AuditReport();
		Random random = new Random(state.randomSeed + state.week);

		// 1️⃣ QUOTA CONTEXT
		int requestedTotal = state.previousWeeklyQuota.requested.values().stream().mapToInt(Integer::intValue).sum();

		audit.requested = requestedTotal;

		// "Offered" = how many quests actually appeared this week
		audit.offered = state.questTemplates.size(); // or tracked pool size

		// 2️⃣ ASSIGNMENT CONTEXT
		audit.assigned = state.activeAssignments.size();

		int completed = 0;
		int failed = 0;
		int deaths = 0;
		int basePayout = 0;
		int bonusPaid = 0;
		double guildReputation = 0.0;
		double adventurerTrust = 0.0;
		double publicFame = 0.0;

		// 3️⃣ RESOLVE QUESTS
		for (QuestAssignment qa : state.activeAssignments) {

			Adventurer adv = findAdventurer(state, qa.adventurerId);
			QuestTemplate qi = findQuestTemplate(state, qa.questTemplateId);

			if (adv == null || qi == null || !adv.alive)
				continue;

			double risk = qa.finalRisk;

			boolean traitMatch = traitsMatch(adv, qi);

			// 1️⃣ Trait impact on risk and trust
			if (traitMatch) {
				risk *= 0.5;
				adventurerTrust += 20;
				adv.satisfaction += 10;
			} else {
				adventurerTrust -= 5;
			}

			// adventurer rank reduces difficulty
			risk -= rankRiskReduction(adv.rank);

			// 4️⃣ Resolve outcome (correct logic)
			double roll1 = random.nextDouble();

			if (roll1 > risk) {
				// ✅ SUCCESS
				qa.status = QuestStatus.COMPLETED;
				completed++;

				basePayout += qa.baseReward;
				bonusPaid += qa.bonusReward;

				publicFame += 10;
				adv.satisfaction += 10;

			} else {
				// First failure → roll again
				double roll2 = random.nextDouble();

				if (roll2 <= risk) {
					// ☠️ DEATH
					qa.status = QuestStatus.ADVENTURER_DIED;
					adv.alive = false;
					deaths++;

					adventurerTrust -= 20;
					publicFame -= 100;
					guildReputation -= 50;

				} else {
					// ⚠️ FAILED BUT ALIVE
					qa.status = QuestStatus.FAILED;
					failed++;

					publicFame -= 10;
					adv.satisfaction -= 5;
				}
			}

			bonusPaid += qa.bonusReward;
			adv.satisfaction += bonusPaid;

			state.completedAssignments.add(qa);
		}

		// Clear active
		state.activeAssignments.clear();

		// 4️⃣ AUDIT RESULTS
		audit.completed = completed;
		audit.deaths = deaths;
		audit.basePayout = basePayout;
		audit.bonusPaid = bonusPaid;
		audit.failed = failed;
		audit.guildProfit = (basePayout - bonusPaid) * 0.25 - state.receptionist.salary;
		guildReputation += audit.guildProfit;
		audit.guildReputation = guildReputation;
		audit.adventurerTrust = adventurerTrust;
		audit.publicFame = publicFame;

		// 5️⃣ AUDIT JUDGMENT
		if (state.week == 1) {
			audit.comments.add(
					"Since It was your first week this audit will not have much impact on your carrer but try to do even better from now on");
			audit.requested = 0;
//			evaluateQuotaPerformance(audit);
			auditCommentService.evaluateExecutionQuality(audit);
			auditCommentService.evaluateGeneralComments(audit);
		} else {
			auditCommentService.evaluateQuotaPerformance(audit);
			auditCommentService.evaluateExecutionQuality(audit);
			auditCommentService.evaluateGeneralComments(audit);
		}

		// 6️⃣ RESET WEEKLY STATE
		state.activeAssignments.clear();
		state.weeklyQuests.clear(); // ❌ remove old quests
		state.week++;
		state.day = 1;
		state.quotaSubmitted = false;
		state.lastAudit = audit;
		state.receptionist.adventurerTrust += adventurerTrust;
		state.receptionist.guildReputation += guildReputation;
		state.receptionist.publicFame += publicFame;

		// 🔥 Generate new quests for next week
		generateWeeklyQuestService.generateWeeklyQuests(state);

		ResetState.resetVisitedToday(state);

		return audit;
	}

	private Adventurer findAdventurer(GameState s, UUID id) {
		return s.adventurers.stream().filter(a -> a.id.equals(id)).findFirst().orElseThrow();
	}

    private QuestTemplate findQuestTemplate(GameState state, UUID questTemplateId) {
        return state.questTemplates.stream()
            .filter(q -> q.id.equals(questTemplateId))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException("Quest instance not found")
            );
    }

	

	private double rankRiskReduction(Rank rank) {
		return switch (rank) {
		case F -> 0;
		case E -> 0.10;
		case D -> 0.20;
		case C -> 0.30;
		case B -> 0.40;
		case A -> 0.50;
		case S -> 0.60;
		default -> throw new IllegalArgumentException("Unexpected value: " + rank);
		};
	}

	private boolean traitsMatch(Adventurer adv, QuestTemplate qi) {
		return adv.traits.contains(qi.trait);
	}

}
