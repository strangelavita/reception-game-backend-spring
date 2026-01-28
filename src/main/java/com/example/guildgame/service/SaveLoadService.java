package com.example.guildgame.service;

import com.example.guildgame.domain.GameState;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class SaveLoadService {

    private static final Path SAVE_DIR = Paths.get("saves");
    private final ObjectMapper mapper = new ObjectMapper();

    /* ---------- SAVE ---------- */

    public void save(GameState state, String slot, String stateId) throws IOException {
        Files.createDirectories(SAVE_DIR);

        Path file = SAVE_DIR.resolve(slot + stateId + ".json");
        mapper.writeValue(file.toFile(), state);
    }

    /* ---------- LOAD ---------- */

    public GameState load(String slot, String stateId) throws IOException {
        Path file = SAVE_DIR.resolve(slot + stateId + ".json");
        return mapper.readValue(file.toFile(), GameState.class);
    }

    /* ---------- BATCH CLEANUP ---------- */

    /**
     * Deletes all save files EXCEPT those containing "slot1".
     */
    public void cleanupSavesExceptSlot1() throws IOException {
        if (!Files.exists(SAVE_DIR)) return;

        try (Stream<Path> files = Files.list(SAVE_DIR)) {
            files
                .filter(Files::isRegularFile)
                .filter(path -> {
                    String name = path.getFileName().toString();
                    return !name.contains("slot1");
                })
                .forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException e) {
                        // swallow + continue, batch must not fail fully
                        System.err.println("Failed to delete save: " + path);
                    }
                });
        }
    }
}
