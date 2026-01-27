package com.example.guildgame.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.guildgame.domain.Adventurer;
import com.example.guildgame.domain.GameState;
import com.example.guildgame.domain.QuestAssignment;
import com.example.guildgame.domain.QuestInstance;
import com.example.guildgame.domain.QuestTemplate;
import com.example.guildgame.domain.Receptionist;
import com.example.guildgame.domain.enums.QuestStatus;

@Service
// This service is for 
// assigning a quest to a given adventurer 
// then removing it from the weekly quests the quest will be in active assignment
public class QuestAssignmentService {

	public QuestAssignment assignQuest(
	        GameState state,
	        UUID questInstanceId,
	        UUID adventurerId,
	        int bonusReward
	) {
	    // 1. Find weekly quest instance
	    QuestInstance quest = findWeeklyQuest(state, questInstanceId);

	    // 2. Find adventurer
	    Adventurer adventurer = findAdventurer(state, adventurerId);
	    Receptionist receptionist = state.receptionist;

	    // 3. Validate using INSTANCE difficulty
	    validateAssignment(quest, adventurer, receptionist);

	    // 4. Create assignment
	    QuestAssignment qa = new QuestAssignment();
	    qa.id = UUID.randomUUID();

	    qa.questInstanceId = quest.id;        // 🔥 instance id
	    qa.questTemplateId = quest.templateId; // reference only

	    qa.adventurerId = adventurer.id;
	    qa.receptionistId = receptionist.id;

	    qa.baseReward = quest.baseReward;
	    qa.bonusReward = bonusReward;
	    qa.totalReward = quest.baseReward + bonusReward;

	    qa.finalRisk = quest.baseRisk;
	    qa.status = QuestStatus.ASSIGNED;

	    // 5. Mutate state (VERY IMPORTANT ORDER)
	    state.weeklyQuests.remove(quest);     // 🔥 consume the quest
	    state.activeAssignments.add(qa);      // 🔥 mark as active
	    
	    state.currentVisitor = null;

	    return qa;
	}


	
	// This is just a backend check we have already added filter on UI
    private void validateAssignment(
            QuestInstance quest,
            Adventurer adv,
            Receptionist rec
    ) {
        // Rank rule
        if (quest.difficulty.ordinal() < rec.rank.ordinal()) {
            throw new IllegalStateException("Receptionist rank too low");
        }

        if (quest.difficulty.ordinal() < adv.rank.ordinal()) {
            throw new IllegalStateException("Quest too difficult for adventurer");
        }

        if (!adv.alive) {
            throw new IllegalStateException("Adventurer is dead");
        }
    }
    
    private QuestInstance findWeeklyQuest(GameState state, UUID questInstanceId) {
        return state.weeklyQuests.stream()
            .filter(q -> q.id.equals(questInstanceId))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException("Quest instance not found")
            );
    }


    private Adventurer findAdventurer(GameState s, UUID id) {
        return s.adventurers.stream()
                .filter(a -> a.id.equals(id))
                .findFirst().orElseThrow();
    }
}
