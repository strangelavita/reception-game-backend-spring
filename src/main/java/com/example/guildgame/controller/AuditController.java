package com.example.guildgame.controller;

import org.springframework.web.bind.annotation.*;
import com.example.guildgame.service.GameStateService;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    private final GameStateService stateService;

    public AuditController(GameStateService stateService) {
        this.stateService = stateService;
    }

    @PostMapping("/acknowledge")
    public void acknowledge(@RequestParam String stateId) {
        stateService.clearAudit(stateId);
    }
    
    @PostMapping("/acknowledge/promotion")
    public void acknowledgePromotion(@RequestParam String stateId) {
    	stateService.get(stateId).receptionist.justPromoted = false;
    }
}
