package com.example.guildgame.util;


import com.example.guildgame.domain.GameState;

public class ResetState {
	
	public static void resetVisitedToday(GameState gameState) {
		
		gameState.visitedToday.clear();
	}

}
