package com.ezreb.graphics.HUD;

import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ezreb.game.Singleplayer;
import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.menu.MainMenu;
import com.ezreb.graphics.menu.MenuOption;
import com.ezreb.graphics.menu.MenuScreen;

public class HUD extends Container {

	public HUD() {
//		this.addFocusListener(new FocusListener() {
//			
//			@Override
//			public void focusLost(FocusEvent e) {
//				
//			}
//			
//			@Override
//			public void focusGained(FocusEvent e) {
//				//FullScreen.this.paintComponents(FullScreen.this.getGraphics());
//				HUD.this.draw();
//			}
//		});
		try {
			this.leave2 = ImageIO.read(new File("src", "com/ezreb/graphics/images/Leave.png")).getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.back.addPropertyChangeListener("Open", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(HUD.this.getParent() instanceof Singleplayer) {
					((Singleplayer) HUD.this.getParent()).setVisible(false);
					try {
						MainMenu.run(((Singleplayer) HUD.this.getParent()).f);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					((Singleplayer) HUD.this.getParent()).dispose();
				}
				
			}
		});
		this.addHierarchyListener(new HierarchyListener() {
			
			@Override
			public void hierarchyChanged(HierarchyEvent arg0) {
				if(HUD.this.isDisplayable()) {
					HUD.this.setBounds(HUD.this.getParent().getBounds());
					HUD.this.validate();
					HUD.this.draw();
				}
				
			}
		});
		this.setVisible(true);
		this.health = new Healthbar(100, 75);
		this.health.setLocation(200, 100);
		this.add(this.health);
		//System.out.println(this);
	}
	public MenuScreen menu;
	private MenuScreen back = new MenuScreen(new Rectangle(301, 301), new Point(0, 0));
	private Healthbar health;
	private Image leave2;
	private MenuOption leave;
	public void draw() {
		try {
			this.remove(this.health);
			this.health = new Healthbar(100, 75);
			this.health.setLocation(100, 50);
			this.add(this.health);
			if(this.menu==null) {
				this.menu = new MenuScreen(new Rectangle(301, 301), new Point(0, 0));
				this.menu.setLocation(new Point(0, 0));
				this.leave = new MenuOption("Leave", new Rectangle(200, 100), new Point(50, 5), this.leave2, this.back);
				this.menu.add(this.leave);
				this.add(this.menu);
			}
			this.setVisible(true);
			this.health.setVisible(true);
			this.health.draw();
			//this.getGraphics().drawRect(5, 5, 50, 50);
			this.health.draw();
			this.health.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
