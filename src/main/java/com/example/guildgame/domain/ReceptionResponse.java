package com.example.guildgame.domain;

import com.example.guildgame.domain.Adventurer;

public class ReceptionResponse {

    public String message;
    public Adventurer visitor;
    public boolean endOfDay;

    public ReceptionResponse(String msg, Adventurer v, boolean end) {
        this.message = msg;
        this.visitor = v;
        this.endOfDay = end;
    }
}
