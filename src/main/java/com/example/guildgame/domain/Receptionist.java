package com.example.guildgame.domain;

import java.util.UUID;
import com.example.guildgame.domain.enums.Rank;

public class Receptionist {
    public UUID id;
    public String name;
    public Rank rank;
    public double guildReputation;
    public double adventurerTrust;
    public double publicFame;
    public int salary;
    public boolean justPromoted;
}