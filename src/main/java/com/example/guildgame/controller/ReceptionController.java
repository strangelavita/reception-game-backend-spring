package com.example.guildgame.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import com.example.guildgame.domain.*;
import com.example.guildgame.service.*;

@RestController
@RequestMapping("/api/reception")
public class ReceptionController {

    private final GameStateService stateService;
    private final ReceptionService receptionService;

    public ReceptionController(
        GameStateService stateService,
        ReceptionService receptionService
    ) {
        this.stateService = stateService;
        this.receptionService = receptionService;
    }

    @PostMapping("/next")
    public ReceptionResponse next(@RequestParam String stateId) {

        GameState state = stateService.get(stateId);

        Optional<Adventurer> visitor =
                receptionService.nextVisitor(state);

        if (visitor.isEmpty()) {
            state.currentVisitor = null;
            return new ReceptionResponse("No one else came today.", null, true);
        }

        state.currentVisitor = visitor.get();
        return new ReceptionResponse(
            visitor.get().name + " arrived at the desk.",
            visitor.get(),
            false
        );
    }

    @PostMapping("/end-day")
    public void endDay(@RequestParam String stateId) {
        GameState state = stateService.get(stateId);
        receptionService.resetCount();
        state.day++;
        state.currentVisitor = null;
    }
}
