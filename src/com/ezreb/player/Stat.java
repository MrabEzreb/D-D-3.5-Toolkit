package com.ezreb.player;

import org.json.JSONObject;

public class Stat {

	public Stat(JSONObject stat) {
		this.name = stat.getString("Name");
		this.min = stat.getLong("Min");
		this.max = stat.getLong("Max");
		this.fullStuff.put("Name", this.name);
		this.fullStuff.put("Min", this.min);
		this.fullStuff.put("Max", this.max);
	}
	public Stat(String name, float min, float max) {
		this.name = name;
		this.min = min;
		this.max = max;
		this.fullStuff.put("Name", this.name);
		this.fullStuff.put("Min", this.min);
		this.fullStuff.put("Max", this.max);
	}
	float min;
	float max;
	String name;
	public JSONObject fullStuff = new JSONObject();
	@Override
	public String toString() {
		return this.fullStuff.toString();
	}
	public JSONObject toJSON() {
		return this.fullStuff;
	}
}
