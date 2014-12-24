/**
 * Generates the main menu.
 */
package com.ezreb.graphics.menu;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ezreb.game.Singleplayer;
import com.ezreb.graphics.FullScreen;
import com.ezreb.jsongen.JSONApplet;

/**
 * @author Mrab Ezreb
 *
 */
public class MainMenu {

	public static MenuScreen main = new MenuScreen(new Rectangle(301, 331), new Point(100, 100), "MainMenu");
	public static MenuScreen testBack = new MenuScreen(new Rectangle(301, 201), new Point(100, 100));
	public static MenuScreen singleplayer = new MenuScreen(new Rectangle(301, 201), new Point(100, 100));
	public static MenuScreen JSON2 = new MenuScreen(new Rectangle(301, 201), new Point(100, 100));
	public static void run(final FullScreen f) throws IOException {
		singleplayer.addPropertyChangeListener("Open", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if((long) evt.getNewValue()==(long) 2) {
					singleplayer.open();
					singleplayer.close();
					singleplayer.firePropertyChange("Open", (long) 2, (long) 1);
					MainMenu.startGame(f);
				}
				
			}
		});
		JSON2.addPropertyChangeListener("Open", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if((long) evt.getNewValue()==(long) 2) {
					MainMenu.startJSON(f);
				}
				
			}
		});
		Image back2 = ImageIO.read(new File("src", "com/ezreb/graphics/images/Back.png")).getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		Image singleplayer2 = ImageIO.read(new File("src", "com/ezreb/graphics/images/Singleplayer.png")).getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		Image leave2 = ImageIO.read(new File("src", "com/ezreb/graphics/images/Leave.png")).getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		Image JSONGen = ImageIO.read(new File("src", "com/ezreb/graphics/images/JSONGen.png")).getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		MenuOption back = new MenuOption("Back", new Rectangle(200, 100), new Point(50, 50), back2, main);
		MenuOption singleplayer = new MenuOption("Singleplayer", new Rectangle(200, 100), new Point(50, 10), singleplayer2, MainMenu.singleplayer);
		MenuOption leave = new MenuOption("Leave", new Rectangle(200, 100), new Point(50, 120), leave2, null);
		MenuOption JSON = new MenuOption("JSON", new Rectangle(200, 100), new Point(50, 230), JSONGen, MainMenu.JSON2);
		main.add(singleplayer);
		//testBack.add(back);
		main.add(leave);
		main.add(JSON);
		f.removeAll();
		f.setIgnoreRepaint(false);
		f.repaint();
		f.getGraphics().clearRect(0, 0, f.getWidth(), f.getHeight());
		f.setIgnoreRepaint(true);
		f.add(main);
		//f.add(testBack);
		f.add(MainMenu.singleplayer);
		main.setVisible(true);
	}
	public static void startJSON(final FullScreen f) {
		JSONApplet j = new JSONApplet();
		final Frame f2 = new Frame();
		f2.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				f2.dispose();
//				f.setAlwaysOnTop(true);
//				f.setAlwaysOnTop(false);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		j.start();
		f2.setVisible(true);
		j.setVisible(true);
		j.setLocation(9, 31);
		f2.setSize(468, 340);
		f2.setPreferredSize(new Dimension(468, 340));
		f2.add(j);
	}
	public static void startGame(FullScreen f) {
		Singleplayer s = new Singleplayer(f);
		f.add(s);
		s.setVisible(true);
	}
}