package com.ezreb.graphics.menu;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.ezreb.graphics.FullScreen;

public class MenuScreen extends Container {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5144081818520240206L;
	public MenuScreen(Rectangle r, Point p, String name) {
		this(r, p);
		this.setName(name);
	}
	public MenuScreen(Rectangle r, Point p) {
		this.size = r;
		this.location = p;
		this.setSize(r.getSize());
		this.setLocation(p);
		this.setEnabled(false);
		this.setName(this.toString());
		
	}
	public Rectangle size;
	public Point location;
	private boolean isShowing = false;
	/**
	 * @return isShowing
	 */
	public boolean isShowing() {
		return isShowing;
	}
	public boolean isFirst;
	public boolean testing = false;
	public boolean hasUpdate = false;
	public void open() {
		if(this.isFirst) {
			this.isFirst = false;
			this.isShowing = true;
		}
		if(this.getParent()!=null && this.getParent().isVisible()==true && this.isShowing==true) {
			this.setEnabled(true);
			this.setSize(this.size.getSize());
			this.setLocation(this.location);
			super.setVisible(true);
			this.isShowing = true;
			this.getGraphics().drawRect(5, 5, 5, 5);
			Component[] c = this.getComponents();
			for (Component component : c) {
				if(component instanceof MenuOption) {
					((MenuOption) component).draw();
					System.out.println("workedopen"+component.getName());
				} else {
					long one = 2;
					long zero = 1;
					component.setEnabled(true);
					component.firePropertyChange("Open", zero, one);
				}
			}
		}
	}
	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		this.isShowing = b;
		if(b==true) {
			this.validate();
			this.open();
			this.hasUpdate = true;
		} else {
			this.close();
		}
		super.setVisible(b);
		this.setEnabled(b);
	}
	public void close() {
		super.setVisible(false);
		this.isShowing = false;
		Component[] c = this.getComponents();
		this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
		for (Component component : c) {
			if(component instanceof MenuOption) {
				((MenuOption) component).erase();
				System.out.println("workedclose"+component.getName());
			} else {
				long one = 2;
				long zero = 1;
				component.firePropertyChange("Close", zero, one);
				component.setEnabled(false);
			}
		}
	}
}