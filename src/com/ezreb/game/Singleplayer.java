package com.ezreb.game;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.HUD.HUD;
import com.ezreb.graphics.menu.MenuScreen;

public class Singleplayer extends Container{

	public Singleplayer(FullScreen f) {
		this.setIgnoreRepaint(true);
//		Component[] c = this.getComponents();
//		for (Component component : c) {
//			if(component.equals(this.hud)) {
//				this.hud = (HUD) component;
//				break;
//			}
//		}
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("testing");
				if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE) {
					System.out.println("testing");
					if(Singleplayer.this.hud.menu.isVisible()==false) {
						Singleplayer.this.hud.menu.setVisible(true);
					} else if(Singleplayer.this.hud.menu.isVisible()==true) {
						Singleplayer.this.hud.menu.setVisible(false);
					}
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("testing");
			}
		});
		this.addHierarchyListener(new HierarchyListener() {
			
			@Override
			public void hierarchyChanged(HierarchyEvent arg0) {
			if(Singleplayer.this.isDisplayable() && Singleplayer.this.getParent() instanceof FullScreen) {
					Singleplayer.this.setBounds(Singleplayer.this.getParent().getBounds());
					Singleplayer.this.validate();
					Singleplayer.this.open();
					//System.out.println(Singleplayer.this);
				}
				
			}
		});
		this.f = f;
	}
	private HUD hud;
	public FullScreen f;
	public void close() {
		Component[] c = this.getComponents();
		for (Component component : c) {
			if(component.isVisible()) {
				System.out.println(component.getBounds());
				component.validate();
				System.out.println(component);
				component.getGraphics().clearRect(0, 0, component.getBounds().width, component.getBounds().height);
				component.paint(component.getGraphics());
				component.setIgnoreRepaint(false);
				component.getGraphics().finalize();
				component.getGraphics().dispose();
			}
		}
		this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
		this.setEnabled(false);
		super.setVisible(false);
		this.hud.setVisible(false);
	}
	public void open() {
		if(this.hud==null) {
			this.hud = new HUD();
			this.add(this.hud);
		} else {
			this.remove(this.hud);
			this.add(this.hud);
		}
		this.hud.menu.setVisible(true);
		this.hud.menu.setVisible(false);
		this.setEnabled(true);
		super.setVisible(true);
		System.out.println(this.isDisplayable());
		this.hud.setVisible(true);
		this.hud.draw();
		this.requestFocusInWindow();
	}
	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		if(b==true) {
			this.open();
		} else {
			this.close();
		}
		super.setVisible(b);
	}
	public void dispose() {
		this.setIgnoreRepaint(false);
		this.removeAll();
		this.invalidate();
	}
}
