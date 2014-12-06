package com.ezreb.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.json.JSONObject;

import com.ezreb.entity.Race;

public class InitialFileCreator {

	public static void generateFiles() {
		File settings = new File("/D-D-3.5-Toolkit/src/com/ezreb/utils/paths.txt");
		File thisJar = new File("");
		try {
			settings.delete();
			settings.createNewFile();
			BufferedWriter writer = Files.newBufferedWriter(settings.toPath(), Charset.defaultCharset());
			JSONObject path = new JSONObject();
			JSONObject files = new JSONObject();
			JSONObject areas = new JSONObject();
			areas.put("Dungeons", thisJar.getAbsolutePath()+"/DnD Toolkit/Areas/Dungeons");
			areas.put("Towns", thisJar.getAbsolutePath()+"/DnD Toolkit/Areas/Towns");
			areas.put("Wildernesses", thisJar.getAbsolutePath()+"/DnD Toolkit/Areas/Wildernesses");
			files.put("Folder", thisJar.getAbsolutePath()+"/DnD Toolkit");
			files.put("Races", thisJar.getAbsolutePath()+"/DnD Toolkit/Races");
			files.put("Stats", thisJar.getAbsolutePath()+"/DnD Toolkit/Stats");
			files.put("Areas", areas);
			files.put("Campaigns", thisJar.getAbsolutePath()+"/DnD Toolkit/Campaigns");
			path.put("Files", files);
			writer.write(path.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path2 = thisJar.getAbsolutePath()+"/DnD Toolkit";
		File folder = new File(path2);
		folder.mkdirs();
		File raceFolder = new File(path2+"/Races");
		raceFolder.mkdirs();
		File statsFolder = new File(path2+"/Stats");
		statsFolder.mkdirs();
		File humanRace = new File(path2+"/Races/Human.json");
		try {
			humanRace.createNewFile();
			BufferedWriter writer2 = Files.newBufferedWriter(humanRace.toPath(), Charset.defaultCharset());
			JSONObject human = new JSONObject("{Name:Human,Stat Changes:{},Physical Description:{Tall Height:6,Short Height:5,Heavy Weight:250,Light Weight:125,Skin Color:Most,Hair Color:Blond to Black,Child Age:5,Teen Age:12,Adult Age:21,Elder Age:65,Death Age:100}}");
			writer2.write(human.toString());
			writer2.flush();
			writer2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveRace(new Race(new JSONObject("{Name:Dwarf,Stat Changes:{Constitution:2,Charisma:-2},Physical Description:{Tall Height:4.5,Short Height:4,Heavy Weight:250,Light Weight:125,Skin Color:Deep Tan or Light Brown,Hair Color:Black Gray or Brown,Child Age:10,Teen Age:29,Adult Age:40,Elder Age:300,Death Age:400}}")));
		saveRace(new Race(new JSONObject("{Name:Elf,Stat Changes:{Constitution:-2,Dexterity:2},Physical Description:{Tall Height:5.5,Short Height:4.5,Heavy Weight:135,Light Weight:95,Skin Color:Pale,Hair Color:Dark,Child Age:25,Teen Age:75,Adult Age:110,Elder Age:500,Death Age:700}}")));
		
	}
	public static void saveRace(Race r) {
		File thisJar = new File("");
		String path2 = thisJar.getAbsolutePath()+"/DnD Toolkit";
		File newRace = new File(path2+"/Races/"+r.name+".json");
		try {
			newRace.createNewFile();
			BufferedWriter writer = Files.newBufferedWriter(newRace.toPath(), Charset.defaultCharset());
			writer.write(r.fullStuff.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
