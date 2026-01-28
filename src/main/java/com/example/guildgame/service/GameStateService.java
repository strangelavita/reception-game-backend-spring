package com.example.guildgame.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import com.example.guildgame.domain.GameState;

@Service
public class GameStateService {
	
	private final Map<String, GameState> states = new ConcurrentHashMap<>();

    public GameState get(String stateId) {
        return states.get(stateId);
    }

    public void set(String stateId, GameState state) {
        states.put(stateId, state);
    }

    public void clear(String stateId) {
        states.remove(stateId);
    }
    
    public void clearAudit(String stateId) {
    	GameState state = get(stateId);
        if (state != null) {
            state.lastAudit = null;
        }
    }
    
    // Only to be called by scheduler
    public void clearAll() {
        states.clear();
    }
}