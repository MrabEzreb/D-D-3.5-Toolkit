/**
 * Generates the main menu.
 */
package com.ezreb.graphics.menu;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import com.ezreb.graphics.FullScreen;

/**
 * @author Mrab Ezreb
 *
 */
public class MainMenu {

	public static MenuScreen main = new MenuScreen(new Rectangle(201, 111), new Point(100, 100));
	public static MenuScreen testBack = new MenuScreen(new Rectangle(201, 101), new Point(100, 100));
	public static MenuOption back = new MenuOption("Back", new Rectangle(200, 40), new Point(50, 50), Color.BLACK, main);
	public static MenuOption singleplayer = new MenuOption("Singleplayer", new Rectangle(200, 40), new Point(50, 10), Color.BLACK, testBack);
	public static MenuOption leave = new MenuOption("Leave", new Rectangle(200, 40), new Point(50, 60), Color.BLACK, null);
	public static void run(FullScreen f) {
		main.add(singleplayer);
		testBack.add(back);
		main.add(leave);
		f.add(main);
		//f.add(testBack);
		main.open();
	}
}
