package com.example.guildgame.controller;

import org.springframework.web.bind.annotation.*;
import com.example.guildgame.service.*;
import com.example.guildgame.domain.AuditReport;

@RestController
@RequestMapping("/api/simulate")
public class SimulationController {
    private final GameStateService state;
    private final SimulationService sim;

    public SimulationController(GameStateService s, SimulationService sim){
        this.state = s; this.sim = sim;
    }

    @PostMapping("/week")
    public AuditReport simulate(){
        return sim.simulate(state.get());
    }
}