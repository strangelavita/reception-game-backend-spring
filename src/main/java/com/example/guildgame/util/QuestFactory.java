package com.example.guildgame.util;

import java.util.*;

import com.example.guildgame.domain.QuestTemplate;
import com.example.guildgame.domain.enums.AdventurerTrait;
import com.example.guildgame.domain.enums.QuestDifficulty;

public class QuestFactory {

	public static List<QuestTemplate> generateAllQuests() {
		List<QuestTemplate> quests = new ArrayList<>();

		quests.addAll(generateFQuests());
		quests.addAll(generateEQuests());

		if (quests.size() != 50) {
			throw new IllegalStateException("Expected 50 quests, got " + quests.size());
		}

		return quests;
	}

	private static QuestTemplate createQuest(String title, String description, QuestDifficulty difficulty,
			int baseReward, double baseRisk, AdventurerTrait trait) {
		QuestTemplate q = new QuestTemplate();
		q.id = UUID.randomUUID();
		q.title = title;
		q.description = description;
		q.difficulty = difficulty;
		q.baseReward = baseReward;
		q.baseRisk = baseRisk;
		q.trait = trait;
		return q;
	}


	private static List<QuestTemplate> generateFQuests() {
		List<QuestTemplate> quests = new ArrayList<>();

		quests.add(createQuest("Scout the Old Road",
				"Survey a trade road rumored to be unsafe. Avoid confrontation and report any dangers.",
				QuestDifficulty.F, 40, 0.10, AdventurerTrait.CAUTIOUS));

		quests.add(createQuest("Retrieve Lost Supplies",
				"Recover abandoned crates from a roadside camp. Speed matters more than heroics.", QuestDifficulty.F,
				45, 0.12, AdventurerTrait.GREEDY));

		quests.add(createQuest("Guard the Shrine",
				"Stand watch over a rural shrine during a local festival to ensure no disturbances occur.",
				QuestDifficulty.F, 35, 0.08, AdventurerTrait.LOYAL));

		quests.add(createQuest("Deliver the Guild Banner",
				"Carry the guild’s banner to a nearby town so its presence is known.", QuestDifficulty.F, 30, 0.05,
				AdventurerTrait.FAME_SEEKER));

		quests.add(createQuest("Map the Creek Caves",
				"Chart a shallow cave system and return with notes. Combat is discouraged.", QuestDifficulty.F, 45,
				0.15, AdventurerTrait.CAUTIOUS));

		quests.add(createQuest("Clear Vermin Infestation",
				"Remove pests from a storage cellar before they ruin valuable goods.", QuestDifficulty.F, 50, 0.18,
				AdventurerTrait.GREEDY));

		quests.add(
				createQuest("Escort a Novice Healer", "Protect a traveling healer on a short journey between villages.",
						QuestDifficulty.F, 40, 0.14, AdventurerTrait.LOYAL));

		quests.add(createQuest("Public Training Demonstration",
				"Perform basic combat drills in the town square to inspire confidence in the guild.", QuestDifficulty.F,
				30, 0.06, AdventurerTrait.FAME_SEEKER));

		quests.add(createQuest("Observe Goblin Movements",
				"Monitor goblin activity from a safe distance and report patterns.", QuestDifficulty.F, 45, 0.16,
				AdventurerTrait.CAUTIOUS));

		quests.add(createQuest("Recover Stolen Coin",
				"Track down a petty thief and retrieve stolen funds with minimal fuss.", QuestDifficulty.F, 55, 0.17,
				AdventurerTrait.GREEDY));
		
		quests.add(createQuest(
			    "Patrol the East Farmland",
			    "Walk the farmland perimeter and report suspicious activity without engaging.",
			    QuestDifficulty.F, 35, 0.09, AdventurerTrait.CAUTIOUS));

			quests.add(createQuest(
			    "Collect Unpaid Dues",
			    "Recover overdue payments from local businesses using pressure, not force.",
			    QuestDifficulty.F, 50, 0.16, AdventurerTrait.GREEDY));

			quests.add(createQuest(
			    "Night Watch Duty",
			    "Stand guard through the night to ensure the town sleeps safely.",
			    QuestDifficulty.F, 30, 0.07, AdventurerTrait.LOYAL));

			quests.add(createQuest(
			    "Guild Message Delivery",
			    "Deliver official guild correspondence to a nearby settlement.",
			    QuestDifficulty.F, 30, 0.06, AdventurerTrait.FAME_SEEKER));

			quests.add(createQuest(
			    "Survey Abandoned Barn",
			    "Inspect a deserted barn for signs of danger and report findings.",
			    QuestDifficulty.F, 40, 0.13, AdventurerTrait.CAUTIOUS));

			quests.add(createQuest(
			    "Recover Merchant Ledger",
			    "Retrieve a lost account book critical to settling trade disputes.",
			    QuestDifficulty.F, 45, 0.14, AdventurerTrait.GREEDY));

			quests.add(createQuest(
			    "Assist Village Militia",
			    "Support a local militia during drills and reinforce morale.",
			    QuestDifficulty.F, 35, 0.10, AdventurerTrait.LOYAL));

			quests.add(createQuest(
			    "Town Square Presence",
			    "Maintain a visible guild presence to reassure citizens and deter trouble.",
			    QuestDifficulty.F, 25, 0.05, AdventurerTrait.FAME_SEEKER));

			quests.add(createQuest(
			    "Trail Marker Inspection",
			    "Check and replace worn trail markers to prevent travelers from getting lost.",
			    QuestDifficulty.F, 35, 0.11, AdventurerTrait.CAUTIOUS));

			quests.add(createQuest(
			    "Warehouse Inventory Check",
			    "Verify stored goods and report missing or damaged items.",
			    QuestDifficulty.F, 45, 0.15, AdventurerTrait.GREEDY));

			quests.add(createQuest(
			    "Protect Pilgrims",
			    "Escort a small group of pilgrims along a well-traveled road.",
			    QuestDifficulty.F, 40, 0.14, AdventurerTrait.LOYAL));

			quests.add(createQuest(
			    "Guild Recruitment Display",
			    "Demonstrate basic combat skills to attract potential recruits.",
			    QuestDifficulty.F, 30, 0.06, AdventurerTrait.FAME_SEEKER));

			quests.add(createQuest(
			    "Check Old Wells",
			    "Inspect unused wells for contamination or hidden creatures.",
			    QuestDifficulty.F, 40, 0.12, AdventurerTrait.CAUTIOUS));

			quests.add(createQuest(
			    "Secure Storage Keys",
			    "Recover misplaced keys before valuable supplies go missing.",
			    QuestDifficulty.F, 45, 0.13, AdventurerTrait.GREEDY));

			quests.add(createQuest(
			    "Guard Supply Wagons",
			    "Travel alongside wagons to deter opportunistic thieves.",
			    QuestDifficulty.F, 40, 0.15, AdventurerTrait.LOYAL));

			quests.add(createQuest(
			    "Public Oath Ceremony",
			    "Represent the guild during a ceremonial oath-taking event.",
			    QuestDifficulty.F, 25, 0.04, AdventurerTrait.FAME_SEEKER));

			quests.add(createQuest(
			    "Observe Marsh Lights",
			    "Investigate strange lights from a safe distance and return with reports.",
			    QuestDifficulty.F, 45, 0.17, AdventurerTrait.CAUTIOUS));

			quests.add(createQuest(
			    "Retrieve Pawned Equipment",
			    "Recover guild-issued gear sold off by a desperate member.",
			    QuestDifficulty.F, 50, 0.18, AdventurerTrait.GREEDY));

			quests.add(createQuest(
			    "Stand Guard at Funeral",
			    "Ensure a fallen adventurer’s funeral proceeds without incident.",
			    QuestDifficulty.F, 35, 0.08, AdventurerTrait.LOYAL));

			quests.add(createQuest(
			    "Announce Guild Success",
			    "Travel between villages spreading news of recent guild victories.",
			    QuestDifficulty.F, 30, 0.06, AdventurerTrait.FAME_SEEKER));


		return quests;
	}

	private static List<QuestTemplate> generateEQuests() {
		List<QuestTemplate> quests = new ArrayList<>();

		quests.add(createQuest("Secure the Trade Pass",
				"Ensure caravans can safely pass through a contested route by removing threats.", QuestDifficulty.E, 90,
				0.25, AdventurerTrait.LOYAL));

		quests.add(
				createQuest("Claim the Bandit Bounty", "Eliminate or drive off bandits and collect the posted reward.",
						QuestDifficulty.E, 110, 0.28, AdventurerTrait.GREEDY));

		quests.add(createQuest("Prove the Guild’s Strength",
				"Complete a visible and challenging task to enhance the guild’s reputation.", QuestDifficulty.E, 85,
				0.22, AdventurerTrait.FAME_SEEKER));

		quests.add(createQuest("Expand Guild Influence",
				"Negotiate or pressure a settlement into recognizing guild authority.", QuestDifficulty.E, 95, 0.24,
				AdventurerTrait.AMBITIOUS));

		quests.add(createQuest("Investigate the Ruined Watchtower",
				"Carefully explore a collapsed watchtower rumored to house lingering dangers.", QuestDifficulty.E, 100,
				0.27, AdventurerTrait.CAUTIOUS));

		quests.add(createQuest(
			    "Stabilize the Border Outpost",
			    "Reinforce a struggling outpost by organizing defenses and ensuring discipline holds under pressure.",
			    QuestDifficulty.E, 95, 0.24, AdventurerTrait.LOYAL));

		quests.add(createQuest(
			    "Assert Guild Primacy",
			    "Outmaneuver local power brokers to establish the guild as the dominant authority in the region.",
			    QuestDifficulty.E, 110, 0.28, AdventurerTrait.AMBITIOUS));

			
		quests.add(
				createQuest("Recover a Valuable Relic", "Retrieve an artifact of modest value before rival groups do.",
						QuestDifficulty.E, 120, 0.29, AdventurerTrait.GREEDY));

		quests.add(createQuest("Defend the Border Hamlet", "Stand with villagers against escalating monster attacks.",
				QuestDifficulty.E, 90, 0.23, AdventurerTrait.LOYAL));

		quests.add(createQuest("Public Monster Hunt",
				"Slay a known threat where witnesses can spread word of the victory.", QuestDifficulty.E, 95, 0.26,
				AdventurerTrait.FAME_SEEKER));
		
		quests.add(createQuest(
			    "Break the Smuggler Route",
			    "Disrupt a known smuggling path without drawing broader attention.",
			    QuestDifficulty.E, 95, 0.26, AdventurerTrait.CAUTIOUS));

			quests.add(createQuest(
			    "Collect Outstanding Bounty",
			    "Hunt down a wanted criminal who has avoided previous collectors.",
			    QuestDifficulty.E, 115, 0.28, AdventurerTrait.GREEDY));

			quests.add(createQuest(
			    "Hold the River Crossing",
			    "Defend a strategic crossing to ensure uninterrupted trade.",
			    QuestDifficulty.E, 90, 0.24, AdventurerTrait.LOYAL));

			quests.add(createQuest(
			    "Guild Banner Campaign",
			    "Establish visible guild presence across multiple settlements.",
			    QuestDifficulty.E, 85, 0.22, AdventurerTrait.FAME_SEEKER));

			quests.add(createQuest(
			    "Pressure a Rival Guild",
			    "Undermine a competing guild’s influence without open conflict.",
			    QuestDifficulty.E, 100, 0.27, AdventurerTrait.AMBITIOUS));

			quests.add(createQuest(
			    "Secure Hidden Cache",
			    "Retrieve valuables hidden before enemies can locate them.",
			    QuestDifficulty.E, 120, 0.29, AdventurerTrait.GREEDY));

			quests.add(createQuest(
			    "Protect Trade Negotiators",
			    "Ensure talks proceed safely despite rising regional tensions.",
			    QuestDifficulty.E, 95, 0.25, AdventurerTrait.LOYAL));

			quests.add(createQuest(
			    "Eliminate a Local Threat",
			    "Remove a known danger in a highly visible operation.",
			    QuestDifficulty.E, 100, 0.26, AdventurerTrait.FAME_SEEKER));

			quests.add(createQuest(
			    "Advance Guild Authority",
			    "Force recognition of guild contracts in contested territory.",
			    QuestDifficulty.E, 105, 0.28, AdventurerTrait.AMBITIOUS));

			quests.add(createQuest(
			    "Scout Enemy Encampment",
			    "Observe and report on enemy strength without initiating combat.",
			    QuestDifficulty.E, 90, 0.23, AdventurerTrait.CAUTIOUS));


		return quests;
	}

}