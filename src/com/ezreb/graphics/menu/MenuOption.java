package com.ezreb.graphics.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuOption extends Component {

	public MenuOption(String s, Rectangle size, Point location, Color color, MenuScreen screen) {
		this.words = s;
		this.size = size;
		this.location = location;
		this.font = new Font("Menu", Font.PLAIN, size.height/2);
		this.color = color;
		this.setPreferredSize(this.size.getSize());
		this.setSize(this.size.getSize());
		this.setLocation(this.location);
		if(screen!=null) {
			this.screen = screen;
		} else if(screen==null) {
			MenuOption.LEAVE_SCREEN.addPropertyChangeListener("Open", new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent arg0) {
					System.exit(0);
					
				}
			});
			this.screen = MenuOption.LEAVE_SCREEN;
		}
		MouseListener l = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuOption.this.getParent().firePropertyChange("Close", (long) 1, (long) 2);
				MenuOption.this.screen.firePropertyChange("Open", 1, 2);
				
			}
		};
		this.addPropertyChangeListener("Open", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					if((long) evt.getNewValue()==(long) 2) {
						MenuOption.this.firePropertyChange("Open", (long) 2, (long) 1);
						MenuOption.this.draw();
					}
				} catch(ClassCastException e) {
					System.out.println("y u feedin me non numbers?");
				}
			}
		});
	}
	public String words;
	public Rectangle size;
	public Point location;
	public Font font;
	public Graphics2D graph;
	public Color color;
	public MenuScreen screen;
	public Rectangle2D bounds2;
	public void draw() {
		if(this.getParent()!=null && this.getParent().isVisible()==true) {
			this.setVisible(false);
			this.setVisible(true);
			this.graph = (Graphics2D) this.getGraphics();
			this.bounds2 = this.font.getStringBounds(this.words, this.graph.getFontRenderContext());
			this.graph.setColor(Color.BLUE);
			this.graph.fillRect(0, 0, this.getWidth(), this.getHeight());
			this.graph.setColor(this.color);
			this.graph.setFont(this.font);
			this.graph.drawString(this.words, 0, 25);
		}
	}
	public void erase() {
		this.setVisible(false);
	}
	private static MenuScreen LEAVE_SCREEN = new MenuScreen(new Rectangle(1, 1), new Point(0, 0));
}
