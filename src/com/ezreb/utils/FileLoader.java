package com.ezreb.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.ezreb.entity.Race;

public class FileLoader {

//	public FileLoader() {
//		
//	}
	public static File pathFile = new File("src", "com/ezreb/utils/paths.txt");
	public static JSONObject files = new JSONObject();
	public static JSONObject getFiles(String name) {
		try {
			BufferedReader pathFileReader = new BufferedReader(new FileReader(pathFile));
			String json = pathFileReader.readLine();
			files = new JSONObject(json);
			pathFileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject pathToFile = null;
		try {
			pathToFile = files.getJSONObject("Files");
		} catch (JSONException e) {
			
		}
		boolean isNextLevel;
		JSONObject pathToFile2 = null;
		if(pathToFile.has(name)) {
			try {
				pathToFile2 = pathToFile.getJSONObject(name);
				isNextLevel = true;
			} catch(JSONException e) {
				isNextLevel = false;
			}
			if(isNextLevel==true) {
				pathToFile = pathToFile2;
			}
		}
		return pathToFile;
	}
	public static Race getRace(String name) {
		try {
			BufferedReader pathFileReader = new BufferedReader(new FileReader(pathFile));
			String json = pathFileReader.readLine();
			files = new JSONObject(json);
			pathFileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject pathToFile = null;
		String path = null;
		try {
			pathToFile = files.getJSONObject("Files");
			path = (String) pathToFile.get("Folder");
		} catch (JSONException e) {
			
		}
		File race = new File(path);
		Race r = null;
		try {
			BufferedReader pathFileReader = new BufferedReader(new FileReader(race));
			String json = pathFileReader.readLine();
			files = new JSONObject(json);
			r = new Race(files);
			pathFileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}

}
