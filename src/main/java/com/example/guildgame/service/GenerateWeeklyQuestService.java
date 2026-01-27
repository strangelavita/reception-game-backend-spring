package com.example.guildgame.service;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.guildgame.domain.GameState;
import com.example.guildgame.domain.QuestInstance;
import com.example.guildgame.domain.QuestTemplate;
import com.example.guildgame.domain.WeeklyQuota;
import com.example.guildgame.domain.enums.QuestDifficulty;


@Service
public class GenerateWeeklyQuestService {
	
	// Generate weekly quests that you can allot
		public void generateWeeklyQuests(GameState state) {

			WeeklyQuota quota = state.currentWeeklyQuota;

			if (quota == null) {
				WeeklyQuota newQuota = new WeeklyQuota();
				newQuota.requested = new EnumMap<>(QuestDifficulty.class);
				newQuota.requested.put(QuestDifficulty.E, 5);
				newQuota.requested.put(QuestDifficulty.F, 10);

				state.currentWeeklyQuota = newQuota;
				quota = newQuota;
			}

			for (var entry : quota.requested.entrySet()) {
				QuestDifficulty difficulty = entry.getKey();
				int count = entry.getValue() + 2;

				// 1️⃣ Collect templates of this difficulty
				List<QuestTemplate> candidates = state.questTemplates.stream().filter(t -> t.difficulty == difficulty)
						.collect(Collectors.toList());

				// 2️⃣ Shuffle for randomness
				Collections.shuffle(candidates);

				// 3️⃣ Take only unique ones
				int limit = Math.min(count, candidates.size());

				for (int i = 0; i < limit; i++) {
					QuestTemplate template = candidates.get(i);

					QuestInstance qi = new QuestInstance();
					qi.id = UUID.randomUUID();
					qi.templateId = template.id;
					qi.title = template.title;
					qi.description = template.description;
					qi.difficulty = template.difficulty;
					qi.baseReward = template.baseReward;
					qi.baseRisk = template.baseRisk;
					qi.trait = template.trait;

					state.weeklyQuests.add(qi);
				}
			}
		}

}
