//package com.example.guildgame.util;
//
//import org.springframework.stereotype.Component;
//import java.util.*;
//import com.example.guildgame.service.GameStateService;
//import com.example.guildgame.domain.*;
//import com.example.guildgame.domain.enums.*;
//
//@Component
//public class DataBootstrap {
//    public DataBootstrap(GameStateService service){
//        GameState state = new GameState();
//        state.randomSeed = System.currentTimeMillis();
//
//        Receptionist r = new Receptionist();
//        r.id = UUID.randomUUID();
//        r.name = "Player";
//        r.rank = Rank.E;
//        state.receptionist = r;
//
//        Adventurer a = new Adventurer();
//        a.id = UUID.randomUUID();
//        a.name = "Lina";
//        a.rank = Rank.F;
//        a.traits.add(AdventurerTrait.AMBITIOUS);
//        state.adventurers.add(a);
//
//        QuestTemplate q = new QuestTemplate();
//        q.id = UUID.randomUUID();
//        q.title = "Clear Rat Nest";
//        q.description = "Rats in the cellar.";
//        q.difficulty = QuestDifficulty.F;
//        q.baseReward = 100;
//        q.baseRisk = 0.1;
//        state.questTemplates.add(q);
//
//        service.set(state);
//    }
//}