/**
 * Generates the main menu.
 */
package com.ezreb.graphics.menu;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ezreb.graphics.FullScreen;

/**
 * @author Mrab Ezreb
 *
 */
public class MainMenu {

	public MainMenu() {
		
	}
	public static MainMenu m = new MainMenu();
	public static Thread t = Thread.currentThread();
//	public static MenuScreen main = new MenuScreen(new Rectangle(201, 111), new Point(100, 100));
//	public static MenuScreen testBack = new MenuScreen(new Rectangle(201, 101), new Point(300, 100));
//	public static MenuOption back = new MenuOption("Back", new Rectangle(150, 40), new Point(50, 50), Color.BLACK, main);
//	public static MenuOption singleplayer = new MenuOption("Singleplayer", new Rectangle(150, 40), new Point(50, 10), Color.BLACK, testBack);
//	public static MenuOption leave = new MenuOption("Leave", new Rectangle(150, 40), new Point(50, 60), Color.BLACK, null);
//	public static void run(FullScreen f) {
//		main.add(singleplayer);
//		testBack.add(back);
//		main.add(leave);
//		f.add(main);
//		f.add(testBack);
//		main.open();
//	}
	public static MenuScreen test = new MenuScreen(new Rectangle(201, 111), new Point(300, 100));
	public static MenuScreen test2 = new MenuScreen(new Rectangle(201, 111), new Point(0, 0));
	private static File fim2 = new File("");
	private static File fim = new File(fim2.getAbsolutePath(), "/src/com/ezreb/graphics/images/health_border.png");
	private static File fim3 = new File(fim2.getAbsolutePath(), "/src/com/ezreb/graphics/images/health_bar.png");
	public static void run(FullScreen f) {
		BufferedImage bim;
		Image im;
		try {
			//fim = new File(fim.getAbsolutePath());
			System.out.println(fim.getAbsolutePath());
			System.out.println(fim.exists());
			bim = ImageIO.read(fim);
			im = bim.getScaledInstance(150, 40, BufferedImage.SCALE_DEFAULT);
			MenuOption leave = new MenuOption("Leave", new Rectangle(150, 40), new Point(50, 60), im, null);
			bim = ImageIO.read(fim3);
			im = bim.getScaledInstance(150, 40, BufferedImage.SCALE_DEFAULT);
			MenuOption firstMenu = new MenuOption("Go 2 Leave", new Rectangle(150, 40), new Point(50, 60), im, test);
			test.add(leave);
			test2.add(firstMenu);
			f.add(test);
			f.add(test2);
			test2.isFirst = true;
			test2.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
