package com.ezreb.graphics.menu;

import java.awt.Container;
import java.awt.Point;
import java.awt.Rectangle;

public class MenuList extends Container {

	public MenuList(Rectangle size, Point location) {
		this.size = size;
		this.location = location;
		this.setSize(this.size.getSize());
		this.setLocation(this.location);
	}
	Rectangle size;
	Point location;
}
