package com.example.guildgame.domain;

import java.util.*;

public class AuditReport {

	public int requested; // total requested via quota
	public int offered; // quests made available by guild
	public int assigned; // quests player assigned
	public int completed;
	public int failed;
	public int deaths;

	public int basePayout; // guild expected payout
	public int bonusPaid; // receptionist bonuses
	public double guildProfit;

	public List<String> comments = new ArrayList<>();

    public double guildReputation;
    public double adventurerTrust;
    public double publicFame;
}