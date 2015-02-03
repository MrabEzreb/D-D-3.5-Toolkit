package com.ezreb.graphics.images;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

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
		URL c2 = c.getResource("com/ezreb/graphics/images/"+image);
		System.out.println(c2);
		try {
			loadedImage = ImageIO.read(c2);
			if(SystemLogConfig.IMAGE_LOAD==true) {
				System.out.println("Image "+c2.toString()+" has been loaded.");
			}
			return loadedImage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: Can't find image "+c2.toString()+" at path "+c2.toExternalForm());
		}
		return null;
	}
	public static ClassLoader c = ImageLoader.class.getClassLoader();
	public static String im = "";
	public static Image HEALTH_BORDER;
	public static Image HEALTH_FILL;
	public static Image HEALTH_ERROR;
	public static Image JSON_GENERATOR_MENU;
	public static Image LEAVE_MENU;
	public static Image SINGLEPLAYER_MENU;
	public static Image BACK_OPTION;

}
