package com.example.guildgame.service;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import com.example.guildgame.domain.GameState;

@Service
public class SaveLoadService {
    private final ObjectMapper mapper = new ObjectMapper();

    public void save(GameState state, String slot) throws IOException {
        new File("saves").mkdirs();
        mapper.writeValue(new File("saves/" + slot + ".json"), state);
    }

    public GameState load(String slot) throws IOException {
        return mapper.readValue(new File("saves/" + slot + ".json"), GameState.class);
    }
}