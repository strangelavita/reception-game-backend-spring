package com.example.guildgame.domain;

import java.util.UUID;

import com.example.guildgame.domain.enums.AdventurerTrait;
import com.example.guildgame.domain.enums.QuestDifficulty;

public class QuestInstance {
    public UUID id;
    public UUID templateId;

    public String title;
    public String description;

    public QuestDifficulty difficulty;
    public int baseReward;
    public double baseRisk;
    public AdventurerTrait trait;
}
