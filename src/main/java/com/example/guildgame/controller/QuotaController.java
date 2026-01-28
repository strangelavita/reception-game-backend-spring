package com.example.guildgame.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.guildgame.domain.WeeklyQuota;
import com.example.guildgame.service.GameStateService;
import com.example.guildgame.service.QuotaService;

@RestController
@RequestMapping("/api/quota")
public class QuotaController {

    private final GameStateService stateService;
    private final QuotaService quotaService;

    public QuotaController(
        GameStateService stateService,
        QuotaService quotaService
    ) {
        this.stateService = stateService;
        this.quotaService = quotaService;
    }

    @PostMapping("/submit")
    public void submit(@RequestParam String stateId, @RequestBody WeeklyQuota quota) {
        quotaService.submitQuota(stateService.get(stateId), quota);
    }
}
