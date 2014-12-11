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

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.ezreb.graphics.FullScreen;

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
		this.setEnabled(false);
		this.addPropertyChangeListener("Open", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					if((long) evt.getNewValue()==2 && evt.getPropertyName()=="Open") {
						MenuScreen.this.setVisible(true);
						MenuScreen.this.firePropertyChange("Open", (long) 2, (long) 1);
						System.out.println("menuscren has been opened");
					}
				} catch(ClassCastException e) {
					System.out.println("y u feedin me non numbers?");
				}
				
			}
		});
		this.addPropertyChangeListener("Close", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					if((long) evt.getNewValue()==2 && evt.getPropertyName()=="Close") {
						MenuScreen.this.setVisible(false);
						MenuScreen.this.firePropertyChange("Close", (long) 2, (long) 1);
						System.out.println("closed");
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
			this.setEnabled(true);
			this.setSize(this.size.getSize());
			this.setLocation(this.location);
			super.setVisible(true);
			this.isShowing = true;
			this.getGraphics().drawRect(5, 5, 5, 5);
			Component[] c = this.getComponents();
			for (Component component : c) {
				long one = 2;
				long zero = 1;
				//component.validate();
				component.firePropertyChange("Open", zero, one);
				component.setEnabled(true);
				System.out.println(component);
				System.out.println(component.isVisible());
			}
			//this.getParent().firePropertyChange("Refresh", (long) 1, (long) 2);
			this.paintComponents(this.getGraphics());
			if(this.getParent() instanceof FullScreen) {
				FullScreen s = (FullScreen) this.getParent();
				s.firePropertyChange("Refresh", (long) 1, (long) 2);
			}
		}
	}
	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		super.setVisible(b);
		this.setEnabled(b);
		if(b==true) {
			this.open();
		} else {
			this.close();
		}
	}
	public void close() {
		super.setVisible(false);
		this.isShowing = false;
	}
}
