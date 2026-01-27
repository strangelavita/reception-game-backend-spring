package com.example.guildgame.domain;

import java.util.UUID;

public class AssignQuestRequest {
    public UUID questTemplateId;
    public UUID questInstanceId;
    public UUID adventurerId;
    public int bonusReward;
}
