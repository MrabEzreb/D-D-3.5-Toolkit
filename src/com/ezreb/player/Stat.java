package com.ezreb.player;

import org.json.JSONObject;

public class Stat {

	public Stat(JSONObject stat) {
		this.name = stat.getString("Name");
		this.min = stat.getLong("Min");
		this.max = stat.getLong("Max");
	}
	public Stat(String name, float min, float max) {
		this.name = name;
		this.min = min;
		this.max = max;
	}
	float min;
	float max;
	String name;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		JSONObject retVal = new JSONObject();
		retVal.put("Name", this.name);
		retVal.put("Min", this.min);
		retVal.put("Max", this.max);
		return retVal.toString();
	}
	public JSONObject toJSON() {
		JSONObject retVal = new JSONObject();
		retVal.put("Name", this.name);
		retVal.put("Min", this.min);
		retVal.put("Max", this.max);
		return retVal;
	}
}
