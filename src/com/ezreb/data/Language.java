package com.ezreb.data;

import org.json.JSONObject;

import com.ezreb.utils.InitialFileCreator;

public class Language {

	public static void loadLanguages() {
		String current = InitialFileCreator.loadFile(InitialFileCreator.langFolder, "Current").getString("Current");
		currentLanguage = new Language(InitialFileCreator.loadFile(InitialFileCreator.langFolder, current));
	}
	public static void setBaseLanguage(String newBase) {
		if(InitialFileCreator.loadFile(InitialFileCreator.langFolder, newBase).has("Name")) {
			InitialFileCreator.saveFile(InitialFileCreator.langFolder, "Current", new JSONObject("{Current:"+newBase+"}"));
			loadLanguages();
		}
	}
	public static Language currentLanguage;
	public Language(JSONObject lang) {
		this.LangName = lang.getString("Name");
		this.GraphicsTab = lang.getString("Graphics Tab");
		this.LanguageTab = lang.getString("Language Tab");
		this.ControlsTab = lang.getString("Controls Tab");
		this.SoundTab = lang.getString("Sound Tab");
		this.Resolution = lang.getString("Resolution");
		this.BetterImages = lang.getString("Better Images");
	}
	
	public String LangName;
	public String GraphicsTab;
	public String LanguageTab;
	public String ControlsTab;
	public String SoundTab;
	public String Resolution;
	public String BetterImages;
}
