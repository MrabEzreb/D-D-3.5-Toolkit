package com.ezreb.game;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.ezreb.graphics.FullScreenDep;
import com.ezreb.graphics.HUD.HUDDep;
@Deprecated
public class SingleplayerDep extends Container{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6556496619005926498L;
	public SingleplayerDep(FullScreenDep f) {
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
				//System.out.println("testing");
				if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE && SingleplayerDep.this.isVisible()) {
					System.out.println("testing");
					if(SingleplayerDep.this.hud.menu.isVisible()==false) {
						//Singleplayer.this.hud.setVisible(true);
						System.out.println("made right");
						SingleplayerDep.this.hud.menu.setVisible(true);
					} else if(SingleplayerDep.this.hud.menu.isVisible()==true) {
						//Singleplayer.this.hud.setVisible(true);
						System.out.println("made wrong");
						SingleplayerDep.this.hud.menu.setVisible(false);
					}
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-genezrzaztzezdz zmzeztzhzozdz zsztzuzbz z z z z z zz zzz z z  z z                                 zzzzzzzzzzzzzzzzzzz              zzzzzzzzzz            zzzz     zzz   zzz   zzzz zz zz   z  z z z z  z z z z zz  z z  z z z z z  z z z  z z z  z z z z z z z         zzzzzzzz         zzzzz       zz    z        zzzzzzz         zz        z   z z z z z z t g6ubuhjyghyhjgtdhjiuhbyudnfbnfbfn hfghdnbfvdhfvhuuhdhdbvdufii8yh
				//System.out.println("testing");
			}
		});
		this.addHierarchyListener(new HierarchyListener() {
			
			@Override
			public void hierarchyChanged(HierarchyEvent arg0) {
			if(SingleplayerDep.this.isDisplayable() && SingleplayerDep.this.getParent() instanceof FullScreenDep) {
					SingleplayerDep.this.setBounds(SingleplayerDep.this.getParent().getBounds());
					SingleplayerDep.this.validate();
					SingleplayerDep.this.open();
					//System.out.println(Singleplayer.this);
				}
				
			}
		});
		this.f = f;
	}
	private HUDDep hud;
	public FullScreenDep f;
	public void close() {
		Component[] c = this.getComponents();
		for (Component component : c) {
			if(component.isVisible()) {
				//System.out.println(component.getBounds());
				component.validate();
				//System.out.println(component);
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
			this.hud = new HUDDep();
			this.add(this.hud);
		} else {
			this.remove(this.hud);
			this.add(this.hud);
		}
		this.hud.menu.setVisible(true);
		this.hud.menu.setVisible(false);
		this.setEnabled(true);
		super.setVisible(true);
		//System.out.println(this.isDisplayable());
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
		try {
			this.close();
		} catch(NullPointerException e) {
			System.out.println("testing");
		}
		this.setIgnoreRepaint(false);
		Component[] c = this.getComponents();
		for (Component component : c) {
			this.remove(component);
		}
		this.removeAll();
		this.invalidate();
	}
}
