package com.ezreb.utils.types;

import java.io.File;

public class Environment {

	public Environment(String bit, String userHome, String userDir, String appData) {
		this.bit = bit;
		this.userDir = userDir;
		this.userHome = userHome;
		this.userDirf = new File(userDir);
		this.userHomef = new File(userHome);
		this.appData = appData;
		this.appDataf = new File(appData);
	}
	private String bit;
	private String userHome;
	private String userDir;
	private String appData;
	private File userHomef;
	private File userDirf;
	private File appDataf;
	public static String bitp = "sun.arch.data.model";
	public static String userHomep = "user.home";
	public static String userDirp = "user.dir";
	private static String staticAppdata = ".\\Common\\Libraries"; //System.getProperty(Environment.userHomep)+"\\Desktop\\AppData\\Roaming\\Ezreb"
	
	public static Environment getCurrentEnvironment() {
		String bit = System.getProperty(bitp);
		System.out.println(bit);
		String userHome = System.getProperty(userHomep);
		String userDir = System.getProperty(userDirp);
		String appData = staticAppdata;
		return new Environment(bit, userHome, userDir, appData);
	}
	
	public String getBit() {
		System.out.println(bit);
		return bit;
	}
	public void setBit(String bit) {
		this.bit = bit;
	}
	public String getUserHome() {
		return userHome;
	}
	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}
	public String getUserDir() {
		return userDir;
	}
	public void setUserDir(String userDir) {
		this.userDir = userDir;
	}
	public String getAppData() {
		return appData;
	}
	public void setAppData(String appData) {
		this.appData = appData;
	}
	public File getUserHomef() {
		return userHomef;
	}
	public void setUserHomef(File userHomef) {
		this.userHomef = userHomef;
	}
	public File getUserDirf() {
		return userDirf;
	}
	public void setUserDirf(File userDirf) {
		this.userDirf = userDirf;
	}
	public File getAppDataf() {
		return appDataf;
	}
	public void setAppDataf(File appDataf) {
		this.appDataf = appDataf;
	}
}
