package com.ezreb.graphics;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.LayoutManager;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FullScreen extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740628702648147613L;

	public FullScreen() {
		this.setUndecorated(true);
		this.setSize(640, 480);
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				Component[] c = FullScreen.this.getComponents();
				for (Component component : c) {
					component.setVisible(true);
				}
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private Graphics g;
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
		return this;
	}
}
