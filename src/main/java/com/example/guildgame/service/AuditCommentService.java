package com.example.guildgame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.guildgame.domain.AuditReport;

@Service
public class AuditCommentService {
	
	
	public void evaluateQuotaPerformance(AuditReport audit) {

		if (audit.assigned < audit.requested) {
			audit.comments
					.add("You requested " + audit.requested + " quests but only assigned " + audit.assigned + ".");
		}

		if (audit.completed < audit.requested) {
			audit.comments.add("You failed to meet the workload you committed to.");
		}

		if (audit.completed >= audit.requested && audit.deaths == 0) {
			audit.comments.add("You met your quota responsibly.");
		}
	}

	public void evaluateExecutionQuality(AuditReport audit) {

		if (audit.deaths > 0) {
			audit.comments.add(audit.deaths + " adventurer(s) died under your supervision.");
		}

		if (audit.bonusPaid > audit.basePayout * 0.5) {
			audit.comments.add("You relied too heavily on bonus pay.");
		}

		if (audit.guildProfit < 0) {
			audit.comments.add("Your generosity cost the guild money.");
		}
	}

	public void evaluateGeneralComments(AuditReport audit) {

		List<String> comments = new ArrayList<>();
		
		int completed = audit.completed;
        int failed = audit.failed;
        int deaths = audit.deaths;
        int basePayout = audit.basePayout;
        int bonusPaid = audit.bonusPaid;
        double guildReputation = audit.guildReputation;
        double adventurerTrust = audit.adventurerTrust;
        double publicFame = audit.publicFame;
        double profit = audit.guildProfit;
		
		

		// 📊 Overall performance
		if (completed > failed && deaths == 0) {
			comments.add("The guild considers this week a clear operational success.");
		} else if (deaths > 0) {
			comments.add("This week raised serious concerns within the guild due to adventurer casualties.");
		} else {
			comments.add("The week's performance was mixed, with room for improvement.");
		}

		// 📣 Public Fame
		if (publicFame >= 30) {
			comments.add(
					"Your actions significantly boosted the guild’s public image. Word of your efficiency is spreading.");
		} else if (publicFame >= 10) {
			comments.add("The guild gained modest public recognition this week.");
		} else if (publicFame <= -20) {
			comments.add("Public confidence in the guild has taken a severe hit due to recent events.");
		} else if (publicFame < 0) {
			comments.add("The public perception of the guild has slightly worsened.");
		}

		// 🤝 Adventurer Trust
		if (adventurerTrust >= 30) {
			comments.add("Adventurers speak highly of the guild’s management and feel confident taking on quests.");
		} else if (adventurerTrust >= 10) {
			comments.add("Adventurers generally trust the guild’s judgement.");
		} else if (adventurerTrust <= -20) {
			comments.add("Many adventurers are questioning the guild’s quest assignments.");
		} else if (adventurerTrust < 0) {
			comments.add("Some adventurers are beginning to doubt the guild’s reliability.");
		}

		// 🏰 Guild Reputation
		if (guildReputation >= 50) {
			comments.add("The guild’s standing among other guilds and nobles has improved greatly.");
		} else if (guildReputation >= 15) {
			comments.add("The guild’s reputation has seen a noticeable improvement.");
		} else if (guildReputation <= -30) {
			comments.add("The guild’s reputation has suffered serious damage.");
		} else if (guildReputation < 0) {
			comments.add("The guild’s reputation has declined slightly.");
		}

		// 💰 Profit contribution
		if (profit > 0) {
			comments.add("Your operations generated a profit of " + profit + " gold for the guild.");
		} else if (profit == 0) {
			comments.add("This week’s operations broke even, yielding no profit.");
		} else {
			comments.add("The guild suffered a financial loss of " + Math.abs(profit) + " gold this week.");
		}

		// ☠️ Deaths impact
		if (deaths == 1) {
			comments.add("The loss of an adventurer has left the guild shaken.");
		} else if (deaths > 1) {
			comments.add("Multiple adventurer deaths have caused outrage and fear within the guild.");
		}

		// 📌 Quest efficiency summary
		comments.add("Weekly summary: " + completed + " quests completed, " + failed + " failed, " + deaths
				+ " adventurers lost.");

		audit.comments.addAll(comments);
	}


}
