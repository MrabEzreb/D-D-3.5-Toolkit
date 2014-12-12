package com.ezreb.graphics;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.ezreb.graphics.menu.MainMenu;
import com.ezreb.graphics.menu.MenuScreen;

public class FullScreen extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740628702648147613L;

	public FullScreen() {
		this.setUndecorated(true);
		//this.setSize(640, 480);
		this.toFront();
		this.setAlwaysOnTop(true);
		//this.getGraphics().setClip(0, 0, this.getSize().width, this.getSize().height);
		//this.t.start();
		this.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
//				Frame f = new Frame("Error");
//				f.setLayout(new FlowLayout(FlowLayout.CENTER));
//				Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
//				f.setLocation(p.x-400, p.y-60);
//				f.setSize(800, 120);
//				Label l = new Label("For Some reason, java does not like me, and removes everything off of the window when you minimize it or alt-tab away from it.");
//				Label l2 = new Label("So, because of this, I am forced to forcefully delete the window.");
//				Label l3 = new Label("Note: I have (if I have done it yet) made it possible to recover your game.");
//				Label l4 = new Label("Once the OK button appears, your recovery file has been generated.");
//				l.setFont(new Font("Small", Font.ROMAN_BASELINE, 12));
//				l2.setFont(new Font("Small", Font.ROMAN_BASELINE, 12));
//				l3.setFont(new Font("Small", Font.ROMAN_BASELINE, 12));
//				l4.setFont(new Font("Small", Font.ROMAN_BASELINE, 12));
//				f.add(l);
//				f.add(l2);
//				f.add(l3);
//				f.add(l4);
//				Button b = new Button("OK");
//				b.addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						System.exit(0);
//						
//					}
//				});
//				b.setVisible(false);
//				f.add(b);
//				FullScreen.this.dispose();
//				f.setVisible(true);
//				f.setAlwaysOnTop(true);
//				RecoverySaver.save();
//				b.setVisible(true);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				FullScreen.this.paintComponents(FullScreen.this.getGraphics());
				Component[] c = FullScreen.this.getComponents();
				for (Component component : c) {
					try {
						System.out.println(component);
						((MenuScreen) component).setVisible(true);
						System.out.println(component);
					} catch(ClassCastException e1) {
						
					}
				}
			}
		});
		this.addContainerListener(new ContainerListener() {
			
			@Override
			public void componentRemoved(ContainerEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentAdded(ContainerEvent arg0) {
				FullScreen.this.paintComponents(FullScreen.this.getGraphics());
				
			}
		});
		this.addPropertyChangeListener("Refresh", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				try {
					if((long) arg0.getNewValue()==2) {
						//FullScreen.this.paintComponents(FullScreen.this.getGraphics());
						System.out.println("Full works");						
						FullScreen.this.firePropertyChange("Refresh", (long) 2, (long) 1);
						FullScreen.this.hasUpdate = true;
					} else {
						//Thread.sleep(1000);
					}
				} catch(ClassCastException e) {
					System.out.println("whatever");
				}
			}
		});
	}
	private Graphics g;
	public boolean hasUpdate = false;
	public boolean isUpdating = true;
	private ScreenUpdate s = new ScreenUpdate(this);
	private Thread t = new Thread(this.s, "Update Menus");
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
}
class ScreenUpdate implements Runnable {

	public ScreenUpdate(FullScreen f) {
		this.f = f;
	}
	public FullScreen f;
	@Override
	public void run() {
		while(f.isUpdating==true) {
			synchronized(MainMenu.m) {
//				try {
//					MainMenu.m.wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				//f.paint();
				this.f.paintComponents(f.getGraphics());
				//System.out.println(this.f.getGraphics().getClip().getBounds().x);
				//System.out.println(f.getGraphics().getClip().getBounds().y);
				//f.hasUpdate = false;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}