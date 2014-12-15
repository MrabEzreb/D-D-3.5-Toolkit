/**
 * Generates the main menu.
 */
package com.ezreb.graphics.menu;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ezreb.graphics.FullScreen;

/**
 * @author Mrab Ezreb
 *
 */
public class MainMenu {

	public static MenuScreen main = new MenuScreen(new Rectangle(301, 221), new Point(100, 100), "MainMenu");
	public static MenuScreen testBack = new MenuScreen(new Rectangle(301, 201), new Point(100, 100));
	public static void run(FullScreen f) throws IOException {
		System.out.println(new File("src", "com/ezreb/graphics/images/Back.png").getAbsolutePath());
		Image back2 = ImageIO.read(new File("src", "com/ezreb/graphics/images/Back.png")).getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		Image singleplayer2 = ImageIO.read(new File("src", "com/ezreb/graphics/images/Singleplayer.png")).getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		Image leave2 = ImageIO.read(new File("src", "com/ezreb/graphics/images/Leave.png")).getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		MenuOption back = new MenuOption("Back", new Rectangle(200, 100), new Point(50, 50), back2, main);
		MenuOption singleplayer = new MenuOption("Singleplayer", new Rectangle(200, 100), new Point(50, 10), singleplayer2, testBack);
		MenuOption leave = new MenuOption("Leave", new Rectangle(200, 100), new Point(50, 120), leave2, null);
		main.add(singleplayer);
		testBack.add(back);
		main.add(leave);
		f.add(main);
		f.add(testBack);
		main.setVisible(true);
	}
}