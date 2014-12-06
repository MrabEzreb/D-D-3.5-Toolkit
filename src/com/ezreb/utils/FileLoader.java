package com.ezreb.utils;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

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
		JSONObject pathToFile = files.getJSONObject("Files");
		return pathToFile;
	}

}
