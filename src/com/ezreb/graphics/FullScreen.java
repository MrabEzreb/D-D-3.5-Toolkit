package com.ezreb.graphics;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ezreb.graphics.menu.MenuOption;
import com.ezreb.graphics.menu.MenuScreen;

public class FullScreen extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740628702648147613L;

	public FullScreen() {
		this.setUndecorated(true);
		JSONArray menus = new JSONArray();
		this.comps.put("Menus", menus);
		//this.setSize(640, 480);
		this.toFront();
		this.setAlwaysOnTop(true);
		this.setIgnoreRepaint(true);
		this.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				//FullScreen.this.paintComponents(FullScreen.this.getGraphics());
				Component[] c = FullScreen.this.getComponents();
				for (Component component : c) {
					try {
						if(((MenuScreen) component).isShowing()==true)
						((MenuScreen) component).setVisible(true);
					} catch(ClassCastException e1) {
						
					}
				}
			}
		});
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					Component[] c = FullScreen.this.getComponents();
					for (Component component : c) {
						if(component.getName()=="MainMenu") {
							component.setVisible(!component.isVisible());
						}
					}
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private Graphics g;
	public boolean hasUpdate = false;
	public boolean isUpdating = true;
	public JSONObject comps = new JSONObject();
	@Override
	public Graphics getGraphics() {
		if(this.isVisible()==false) {
			this.setVisible(true);
			Graphics g = super.getGraphics();
			this.setVisible(false);
			this.g = g;
		} else {
			this.g = super.getGraphics();
		}
		return this.g;
	}
	public FullScreen toggleVisible() {
		if(this.isVisible()==true) {
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
		this.setAlwaysOnTop(true);
		return this;
	}
	public void paint() {
		this.paintComponents(this.getGraphics());
		System.out.println("painted");
	}
	@Override
	public Component add(Component comp) {
		// TODO Auto-generated method stub
		if(comp instanceof MenuScreen) {
			MenuScreen m = (MenuScreen) comp;
			JSONObject newComp = new JSONObject();
			newComp.put("Is Open", m.isShowing());
			Component[] ms = m.getComponents();
			JSONArray options = new JSONArray();
			for (Component component : ms) {
				JSONObject curOption = new JSONObject();
				if(component instanceof MenuOption) {
					MenuOption mo = (MenuOption) component;
					curOption.put("Words", mo.words);
					options.put(curOption);
				}
			}
			newComp.put("Options", options);
			this.comps.getJSONArray("Menus").put(newComp);
		}
		return super.add(comp);
	}
}