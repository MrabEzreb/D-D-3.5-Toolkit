package com.ezreb.graphics.menu;

import java.awt.Component;
import java.awt.Container;
import java.awt.Menu;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuScreen extends Container {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5144081818520240206L;
	public MenuScreen(Rectangle r, Point p) {
		this.size = r;
		this.location = p;
		this.setSize(r.getSize());
		this.setLocation(p);
		this.addPropertyChangeListener("Open", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					if((long) evt.getNewValue()==2 && evt.getPropertyName()=="Open" && MenuScreen.this.isShowing==true) {
						Thread.sleep(100);
						MenuScreen.this.open();
						//MenuScreen.this.firePropertyChange("Open", (long) 2, (long) 1);
						System.out.println("menuscren has been opened");
					}
				} catch(ClassCastException e) {
					System.out.println("y u feedin me non numbers?");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		this.addPropertyChangeListener("Close", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					if((long) evt.getNewValue()==2 && evt.getPropertyName()=="Close") {
						MenuScreen.this.close();
						MenuScreen.this.firePropertyChange("Close", (long) 2, (long) 1);
					}
				} catch(ClassCastException e) {
					System.out.println("y u feedin me non numbers?");
				}
				
			}
		});
		
	}
	public Rectangle size;
	public Point location;
	public boolean isShowing = false;
	public void open() {
		if(this.getParent()!=null && this.getParent().isVisible()==true) {
			this.setSize(this.size.getSize());
			this.setLocation(this.location);
			this.setVisible(true);
			this.isShowing = true;
			this.getGraphics().drawRect(5, 5, 5, 5);
			Component[] c = this.getComponents();
			for (Component component : c) {
				long one = 2;
				long zero = 1;
				component.firePropertyChange("Open", zero, one);
				//System.out.println(component);
			}
		}
	}
	public void close() {
		this.setVisible(false);
		this.isShowing = false;
	}
}
