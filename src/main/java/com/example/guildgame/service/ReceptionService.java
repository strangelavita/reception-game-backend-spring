package com.example.guildgame.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.guildgame.domain.*;

@Service
// This service handles the next adventurer call 
// TO-DO have a better randomization logic and about no of adventurer per day
public class ReceptionService {
	
	int count = 0;
	
	
	public void resetCount() {
		count = 0;
	}

	public Optional<Adventurer> nextVisitor(GameState state) {
		

	    if (!state.deskOpen || count >= state.averageDaily) {
	        return Optional.empty();
	    }

	    count++;
	    
	    Collections.shuffle(state.adventurers);
	    
	    Random random = new Random(state.randomSeed + state.day);
	    

	    List<Adventurer> eligible = state.adventurers.stream()
	            .filter(a -> a.alive)
	            .filter(a -> a.rank.ordinal() >= state.receptionist.rank.ordinal())
	            .filter(a -> !state.visitedToday.contains(a.id))
	            .limit(state.averageDaily)
	            .toList();

	    if (eligible.isEmpty()) {
	        return Optional.empty();
	    }

	    Adventurer chosen = eligible.get(random.nextInt(eligible.size()));
	    state.visitedToday.add(chosen.id);

	    return Optional.of(chosen);
	}

}
