package com.example.guildgame.util;

import java.io.IOException;
import java.time.Instant;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.guildgame.service.GameStateService;
import com.example.guildgame.service.SaveLoadService;

@Component
public class CleanupBatch {

    private final GameStateService gameStateService;
    private final SaveLoadService saveLoadService;

    public CleanupBatch(GameStateService gameStateService,
                        SaveLoadService saveLoadService) {
        this.gameStateService = gameStateService;
        this.saveLoadService = saveLoadService;
    }

    /**
     * Runs at:
     * 00:00, 06:00, 12:00, 18:00 UTC
     */
    @Scheduled(cron = "0 0 0,6,12,18 * * *", zone = "UTC")
    public void cleanup() {
        System.out.println("🧹 Cleanup batch started @ " + Instant.now());

        // 1️⃣ Clear all in-memory states
        gameStateService.clearAll();

        // 2️⃣ Cleanup save files
        try {
            saveLoadService.cleanupSavesExceptSlot1();
        } catch (IOException e) {
            System.err.println("Cleanup failed: " + e.getMessage());
        }

        System.out.println("✅ Cleanup batch completed");
    }
}
