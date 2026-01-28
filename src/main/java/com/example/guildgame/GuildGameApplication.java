package com.example.guildgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GuildGameApplication {
    public static void main(String[] args) {
    	//Test
        SpringApplication.run(GuildGameApplication.class, args);
    }
}