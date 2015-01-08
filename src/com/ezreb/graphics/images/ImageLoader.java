package com.ezreb.graphics.images;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Iterator;
import java.util.jar.JarFile;

import javax.imageio.ImageIO;

import sun.dc.pr.PathDasher;
import testing.SystemLogConfig;

public class ImageLoader {

	public static void loadImages() {
		System.out.println(im);
		HEALTH_BORDER = loadImage("health_border.png");
		HEALTH_FILL = loadImage("health_bar.png");
		HEALTH_ERROR = loadImage("health_error.png");
		JSON_GENERATOR_MENU = loadImage("JSONGen.png");
		LEAVE_MENU = loadImage("Leave.png");
		SINGLEPLAYER_MENU = loadImage("Singleplayer.png");
		BACK_OPTION = loadImage("Back.png");

	}
	private static Image loadImage(String image) {
		Image loadedImage;
		File file = new File(IMAGE_DIR, image);
		try {
			loadedImage = ImageIO.read(file);
			if(SystemLogConfig.IMAGE_LOAD==true) {
				System.out.println("Image "+file.getName()+" has been loaded.");
			}
			return loadedImage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: Can't find image "+file.getName()+" at path "+file.getAbsolutePath());
		}
		return null;
	}
	public static File IMAGE_DIR = new File("src", "com/ezreb/graphics/images");
	public static String im = "";
	public static Image HEALTH_BORDER;
	public static Image HEALTH_FILL;
	public static Image HEALTH_ERROR;
	public static Image JSON_GENERATOR_MENU;
	public static Image LEAVE_MENU;
	public static Image SINGLEPLAYER_MENU;
	public static Image BACK_OPTION;

}
