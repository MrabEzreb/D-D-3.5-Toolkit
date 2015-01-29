package com.ezreb.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class InitialFileCreator {

	public static void generateFiles() {
		System.out.println(baseFolder.getAbsolutePath());
		if(baseFolder.exists() && raceFolder.exists() && langFolder.exists() && statFolder.exists()) {
			return;
		}
		System.out.println(baseFolder.toPath());
		if(raceFolder.exists() != true) {
			raceFolder.mkdirs();
		}
		if(langFolder.exists() != true) {
			langFolder.mkdirs();
			saveFile(langFolder, "English", new JSONObject("{\"Better Images\":\"Enable Original, Better Images?\",\"Controls Tab\":\"Controls\",\"Language Tab\":\"Language\",\"Name\":\"English\",\"Resolution\":\"Resolution\",\"Graphics Tab\":\"Graphics\",\"Sound Tab\":\"Sound\"}"));
			saveFile(langFolder, "Current", new JSONObject("{\"Current\":\"English\"}"));
			saveFile(langFolder, "Latin", new JSONObject("{\"Better Images\":\"Enablem Originalum, Betteram Imageres?\",\"Controls Tab\":\"Controlam\",\"Language Tab\":\"Languagere\",\"Name\":\"Bestere Latinamus Everam\",\"Resolution\":\"Resolutioneres\",\"Graphics Tab\":\"Graphicamus\",\"Sound Tab\":\"Soundarum\"}"));
		}
		if(statFolder.exists() != true) {
			statFolder.mkdirs();
			saveFile(statFolder, "Strength", new  JSONObject("{Name:Strength,Max:16,Min:3}"));
			saveFile(statFolder, "Dexterity", new  JSONObject("{Name:Dexterity,Max:16,Min:3}"));
			saveFile(statFolder, "Constitution", new  JSONObject("{Name:Constitution,Max:16,Min:3}"));
			saveFile(statFolder, "Intelligence", new  JSONObject("{Name:Intelligence,Max:16,Min:3}"));
			saveFile(statFolder, "Wisdom", new  JSONObject("{Name:Wisdom,Max:16,Min:3}"));
			saveFile(statFolder, "Charisma", new  JSONObject("{Name:Charisma,Max:16,Min:3}"));
		}
		
	}
	public static File baseFolder = new File(new File(System.getProperty("user.home")), "AppData\\Roaming\\Ezreb\\D&D");
	public static File raceFolder = new File(baseFolder, "Races");
	public static File langFolder = new File(baseFolder, "Languages");
	public static File statFolder = new File(baseFolder, "Stats");
	public static void saveFile(File where, String name, JSONObject data) {
		File file = new File(where.getAbsolutePath()+"/"+name+".json");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static JSONObject loadFile(File where, String name) {
		File file = new File(where.getAbsolutePath()+"/"+name+".json");
		BufferedReader br = null;
		JSONObject retVal = new JSONObject();
		try {
			br = new BufferedReader(new FileReader(file));
			retVal = new JSONObject(br.readLine());
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}
}
