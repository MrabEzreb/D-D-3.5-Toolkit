package com.ezreb.graphics;

import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.ezreb.graphics.menu.MainMenu;
import com.ezreb.graphics.menu.MenuScreen;
import com.ezreb.utils.RecoverySaver;

public class FullScreen extends Frame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740628702648147613L;

	public FullScreen() {
		this.setUndecorated(true);
		//this.setSize(640, 480);
		this.setAlwaysOnTop(true);
		this.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Frame f = new Frame("Error");
				f.setLayout(new FlowLayout(FlowLayout.CENTER));
				Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
				f.setLocation(p.x-400, p.y-60);
				f.setSize(800, 120);
				Label l = new Label("For Some reason, java does not like me, and removes everything off of the window when you minimize it or alt-tab away from it.");
				Label l2 = new Label("So, because of this, I am forced to forcefully delete the window.");
				Label l3 = new Label("Note: I have (if I have done it yet) made it possible to recover your game.");
				Label l4 = new Label("Once the OK button appears, your recovery file has been generated.");
				l.setFont(new Font("Small", Font.ROMAN_BASELINE, 12));
				l2.setFont(new Font("Small", Font.ROMAN_BASELINE, 12));
				l3.setFont(new Font("Small", Font.ROMAN_BASELINE, 12));
				l4.setFont(new Font("Small", Font.ROMAN_BASELINE, 12));
				f.add(l);
				f.add(l2);
				f.add(l3);
				f.add(l4);
				Button b = new Button("OK");
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						
					}
				});
				b.setVisible(false);
				f.add(b);
				FullScreen.this.dispose();
				f.setVisible(true);
				f.setAlwaysOnTop(true);
				RecoverySaver.save();
				b.setVisible(true);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
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
						FullScreen.this.paintComponents(FullScreen.this.getGraphics());
						System.out.println("Full works");
						Thread.sleep(1000);
						Thread.currentThread().
						FullScreen.this.firePropertyChange("Refresh", (long) 2, (long) 1);
					} else {
						Thread.sleep(1000);
					}
				} catch(ClassCastException e) {
					System.out.println("whatever");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		this.setAlwaysOnTop(true);
		return this;
	}
	public void paint() {
		this.paintComponents(this.getGraphics());
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
