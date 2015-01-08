package com.ezreb.graphics;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ezreb.graphics.menu.MenuOptionDep;
import com.ezreb.graphics.menu.MenuScreenDep;
@Deprecated
public class FullScreenDep extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740628702648147613L;

	public FullScreenDep() {
		this.setUndecorated(true);
		JSONArray menus = new JSONArray();
		this.comps.put("Menus", menus);
		//this.setSize(640, 480);
		this.setIgnoreRepaint(true);
		this.toFront();
		this.setAlwaysOnTop(true);
		this.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				//FullScreen.this.paintComponents(FullScreen.this.getGraphics());
				Component[] c = FullScreenDep.this.getComponents();
				for (Component component : c) {
					//component.repaint();
					component.setVisible(true);
				}
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
	public FullScreenDep toggleVisible() {
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
		if(comp instanceof MenuScreenDep) {
			MenuScreenDep m = (MenuScreenDep) comp;
			JSONObject newComp = new JSONObject();
			newComp.put("Is Open", m.isShowing());
			Component[] ms = m.getComponents();
			JSONArray options = new JSONArray();
			for (Component component : ms) {
				JSONObject curOption = new JSONObject();
				if(component instanceof MenuOptionDep) {
					MenuOptionDep mo = (MenuOptionDep) component;
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