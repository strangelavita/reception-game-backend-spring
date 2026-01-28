package com.example.guildgame.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.guildgame.domain.NewGameRequest;
import com.example.guildgame.service.GameInitializationService;
import com.example.guildgame.service.GameStateService;

@RestController
@RequestMapping("/api/game")
public class GameInitController {

    private final GameStateService stateService;
    private final GameInitializationService initService;

    public GameInitController(
        GameStateService stateService,
        GameInitializationService initService
    ) {
        this.stateService = stateService;
        this.initService = initService;
    }

    @PostMapping("/new")
    public void newGame(@RequestParam String stateId, @RequestBody NewGameRequest req) {
        stateService.set(stateId,initService.initialize(req));
    }
}
