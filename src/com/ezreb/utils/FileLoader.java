package com.ezreb.utils;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.json.JSONException;
import org.json.JSONObject;

public class FileLoader {

//	public FileLoader() {
//		
//	}
	public static File pathFile = new File("/D-D-3.5-Toolkit/src/com/ezreb/utils/paths.txt");
	public static JSONObject files = new JSONObject();
	public static JSONObject getFiles(String name) {
		try {
			BufferedReader pathFileReader = Files.newBufferedReader(pathFile.toPath(), Charset.defaultCharset());
			String json = pathFileReader.readLine();
			files = new JSONObject(json);
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

}
