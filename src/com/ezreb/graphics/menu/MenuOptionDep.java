package com.ezreb.graphics.menu;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
@Deprecated
public class MenuOptionDep extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 626414247452779283L;
	public MenuOptionDep(String s, Rectangle size, Point location, Image b, MenuScreenDep screen) {
		this.words = s;
		this.setName(this.words);
		this.size = size;
		this.location = location;
		this.font = new Font("Menu", Font.PLAIN, size.height/2);
		this.im = b;
		this.setPreferredSize(this.size.getSize());
		this.setSize(this.size.getSize());
		this.setLocation(this.location);
		this.setEnabled(false);
		if(screen!=null) {
			this.screen = screen;
		} else if(screen==null) {
			MenuOptionDep.LEAVE_SCREEN.addPropertyChangeListener("Open", new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent arg0) {
					System.exit(0);
					
				}
			});
			this.screen = MenuOptionDep.LEAVE_SCREEN;
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
				synchronized(MenuOptionDep.this.getParent()) {
					try {
						MenuScreenDep f1 = (MenuScreenDep) MenuOptionDep.this.getParent();
						f1.setVisible(false);
					} catch(ClassCastException e1) {
						e1.printStackTrace();
					}
				}
				synchronized(MenuOptionDep.this.screen) {
					try {
						MenuScreenDep f2 = (MenuScreenDep) MenuOptionDep.this.screen;
						f2.setVisible(true);
						MenuOptionDep.this.screen.firePropertyChange("Open", 1, 2);
					} catch(ClassCastException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		};
		this.addMouseListener(l);
	}
	public String words;
	public Rectangle size;
	public Point location;
	public Font font;
	public Graphics2D graph;
	public Image im;
	public MenuScreenDep screen;
	public Rectangle2D bounds2;
	public void draw() {
		if(this.getParent()!=null && this.getParent().isVisible()==true) {
			this.setVisible(false);
			this.setVisible(true);
			//System.out.println(this.isDisplayable()+"option");
			this.graph = (Graphics2D) this.getGraphics();
			this.graph.drawImage(this.im, 0, 0, null);
		}
	}
	public void erase() {
		this.graph = (Graphics2D) this.getGraphics();
		this.graph.clearRect(0, 0, this.getWidth(), this.getHeight());
		this.setVisible(false);
	}
	private static MenuScreenDep LEAVE_SCREEN = new MenuScreenDep(new Rectangle(1, 1), new Point(0, 0));
}
