package com.example.guildgame.service;

import org.springframework.stereotype.Service;

import com.example.guildgame.domain.GameState;
import com.example.guildgame.domain.WeeklyQuota;

@Service
public class QuotaService {

    public void submitQuota(GameState state, WeeklyQuota quota) {

        if (state.quotaSubmitted) {
            throw new IllegalStateException("Quota already submitted");
        }

        // Validate: receptionist rank
        quota.requested.forEach((difficulty, count) -> {
            if (difficulty.ordinal() < state.receptionist.rank.ordinal()) {
                throw new IllegalStateException(
                    "Cannot request quests above your rank"
                );
            }
            if (count < 0) {
                throw new IllegalStateException("Invalid quota count");
            }
        });

        state.previousWeeklyQuota = state.currentWeeklyQuota;
        state.currentWeeklyQuota = quota;
        state.quotaSubmitted = true;
    }
}
