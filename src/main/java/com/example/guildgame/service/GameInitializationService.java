package com.example.guildgame.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.guildgame.domain.Adventurer;
import com.example.guildgame.domain.GameState;
import com.example.guildgame.domain.NewGameRequest;
import com.example.guildgame.domain.QuestTemplate;
import com.example.guildgame.domain.Receptionist;
import com.example.guildgame.domain.enums.AdventurerTrait;
import com.example.guildgame.domain.enums.QuestDifficulty;
import com.example.guildgame.domain.enums.Rank;
import com.example.guildgame.util.AdventurerFactory;
import com.example.guildgame.util.QuestFactory;

@Service
public class GameInitializationService {
	
	@Autowired
	private final SimulationService simulationService;
	
	private final GenerateWeeklyQuestService generateWeeklyQuestService;

    public GameInitializationService(SimulationService simulationService, GenerateWeeklyQuestService generateWeeklyQuestService) {
		super();
		this.generateWeeklyQuestService = generateWeeklyQuestService;
		this.simulationService = simulationService;
	}
    
    

	public GameState initialize(NewGameRequest req) {

        GameState state = new GameState();
        state.week = 1;
        state.day = 1;
        state.randomSeed = System.currentTimeMillis();
        state.quotaSubmitted = false;

        // Receptionist
        Receptionist r = new Receptionist();
        r.id = UUID.randomUUID();
        r.name = req.receptionistName != null
                ? req.receptionistName
                : "New Receptionist";
        r.rank = Rank.E;
        r.salary = 100;
        state.receptionist = r;

        // Adventurers
        state.adventurers = AdventurerFactory.generateAllAdventurers();

        // Quest templates all of the quests 
        state.questTemplates = QuestFactory.generateAllQuests();
        
        generateWeeklyQuestService.generateWeeklyQuests(state);

        return state;
    }



}
