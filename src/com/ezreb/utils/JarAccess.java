package com.ezreb.utils;

import java.io.File;
import java.net.URL;

public class JarAccess {

	public static File parentJar = new File(JarAccess.class.getClassLoader().getResource("\\").getFile());
	public static URL parentJar2 = JarAccess.class.getClassLoader().getResource("\\");
	public static File installer = new File(JarAccess.class.getClassLoader().getResource("installers/j3d-1_5_2-windows-amd64.exe").getFile());
}
