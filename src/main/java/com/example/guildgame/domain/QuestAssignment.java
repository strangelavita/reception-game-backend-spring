package com.example.guildgame.domain;

import java.util.UUID;

import com.example.guildgame.domain.enums.QuestStatus;

public class QuestAssignment {
	
    public UUID id;
    public UUID questTemplateId;
    
    public UUID adventurerId;
    public UUID receptionistId;
    public int baseReward;
    public int bonusReward;   
    public int totalReward;
    public double finalRisk;
    public QuestStatus status;
    public String outcomeNote;
	public UUID questInstanceId;
	
	
    
}