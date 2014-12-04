package com.ezreb.entity;

import org.json.JSONObject;

import com.ezreb.player.Stat;

public class Race {

	public Race(String name) {
		this.name = name;
	}
	public String name;
	public JSONObject
	public JSONObject statChanges = new JSONObject();
	public JSONObject physicalDescription = new JSONObject();
	public Race addStatChange(Stat stat, float change) {
		this.statChanges.put(stat.toJSON().getString("Name"), change);
		return this;
	}
	public Race addPhysicalDesc(float tallHeight, float shortHeight, float heavyWeight, float lightWeight, String skinColor, String hairColor, float childAge, float teenAge, float adultAge, float elderAge, float deathAge) {
		this.physicalDescription.put("Tall Height", tallHeight);
		this.physicalDescription.put("Short Height", shortHeight);
		this.physicalDescription.put("Heavy Weight", heavyWeight);
		this.physicalDescription.put("Light Weight", lightWeight);
		this.physicalDescription.put("Skin Color", skinColor);
		this.physicalDescription.put("Hair Color", hairColor);
		this.physicalDescription.put("Child Age", childAge);
		this.physicalDescription.put("Teen Age", teenAge);
		this.physicalDescription.put("Adult Age", adultAge);
		this.physicalDescription.put("Elder Age", elderAge);
		this.physicalDescription.put("Death Age", deathAge);
		return this;
	}

}
