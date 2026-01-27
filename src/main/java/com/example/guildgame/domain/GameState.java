package com.example.guildgame.domain;

import java.util.*;

public class GameState {
	
	
	
    public int week = 1;
    public Receptionist receptionist;
    public List<Adventurer> adventurers = new ArrayList<>();
    
    // All quests never to be deleted just like adventurers 
    public List<QuestTemplate> questTemplates = new ArrayList<>();
    
    // in progress quests 
    public List<QuestAssignment> activeAssignments = new ArrayList<>();
    // completed quests 
    public List<QuestAssignment> completedAssignments = new ArrayList<>();
    public AuditReport lastAudit;
    public long randomSeed;
    
    // 🔥 NEW: weekly quest pool - available to assign
    public List<QuestInstance> weeklyQuests = new ArrayList<>();

    
    public int day = 1;
    public Adventurer currentVisitor;
    public boolean deskOpen = true;
    
    public WeeklyQuota previousWeeklyQuota;
    
    public WeeklyQuota currentWeeklyQuota;
    
    public boolean quotaSubmitted;
    
    public final Set<UUID> visitedToday = new HashSet<>();
    
    public long averageDaily = 3;

    
}