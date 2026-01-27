package com.example.guildgame.controller;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import com.example.guildgame.service.*;

@RestController
@RequestMapping("/api/save")
public class SaveLoadController {
    private final GameStateService state;
    private final SaveLoadService save;

    public SaveLoadController(GameStateService s, SaveLoadService save){
        this.state = s; this.save = save;
    }

    @PostMapping("/{slot}")
    public void save(@PathVariable String slot) throws IOException {
        save.save(state.get(), slot);
    }

    @PostMapping("/load/{slot}")
    public void load(@PathVariable String slot) throws IOException {
        state.set(save.load(slot));
    }
}