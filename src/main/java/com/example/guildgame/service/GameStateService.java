package com.example.guildgame.service;

import org.springframework.stereotype.Service;
import com.example.guildgame.domain.GameState;

@Service
public class GameStateService {
	
    private GameState state;
    
    public GameState get(){ return state; }
    
    public void set(GameState s){ this.state = s; }
    
    public void clearAudit() {
        if (state != null) {
            state.lastAudit = null;
        }
    }
}