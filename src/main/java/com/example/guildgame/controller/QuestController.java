package com.example.guildgame.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.guildgame.domain.AssignQuestRequest;
import com.example.guildgame.domain.QuestAssignment;
import com.example.guildgame.service.GameStateService;
import com.example.guildgame.service.QuestAssignmentService;

@RestController
@RequestMapping("/api/quests")
public class QuestController {

    private final GameStateService stateService;
    private final QuestAssignmentService assignmentService;

    public QuestController(
        GameStateService stateService,
        QuestAssignmentService assignmentService
    ) {
        this.stateService = stateService;
        this.assignmentService = assignmentService;
    }

    @PostMapping("/assign")
    public QuestAssignment assign(@RequestBody AssignQuestRequest req) {
        return assignmentService.assignQuest(
                stateService.get(),
                req.questInstanceId,
                req.adventurerId,
                req.bonusReward
        );
    }
}
