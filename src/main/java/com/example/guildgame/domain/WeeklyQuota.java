package com.example.guildgame.domain;

import java.util.EnumMap;
import com.example.guildgame.domain.enums.QuestDifficulty;

public class WeeklyQuota {
    public EnumMap<QuestDifficulty, Integer> requested =
            new EnumMap<>(QuestDifficulty.class);
    
}
