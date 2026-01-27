package com.example.guildgame.domain;

import java.util.*;
import com.example.guildgame.domain.enums.*;

public class Adventurer {
    public UUID id;
    public String name;
    public Rank rank;
    public boolean alive = true;
    public String background;
    public Set<AdventurerTrait> traits = new HashSet<>();
    public int satisfaction;
}