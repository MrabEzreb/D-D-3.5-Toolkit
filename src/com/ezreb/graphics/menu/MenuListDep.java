package com.ezreb.graphics.menu;

import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;
@Deprecated
public class MenuListDep extends Container {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7130486652687172806L;
	public MenuListDep(Rectangle size, Point location) {
		this.size = size;
		this.location = location;
		this.setSize(this.size.getSize());
		this.setLocation(this.location);
	}
	Rectangle size;
	Point location;
}
