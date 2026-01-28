package com.example.guildgame.controller;

import org.springframework.web.bind.annotation.*;
import com.example.guildgame.service.GameStateService;
import com.example.guildgame.domain.GameState;

@RestController
@RequestMapping("/api/state")
public class GameStateController {
    private final GameStateService service;
    
    public GameStateController(GameStateService s){ this.service = s; }
    
    
    @GetMapping public GameState get(@RequestParam String stateId){
    	return service.get(stateId); 
    	}
    
    @PostMapping public void resetState(@RequestParam String stateId) {
    	service.clear(stateId);
    }
}