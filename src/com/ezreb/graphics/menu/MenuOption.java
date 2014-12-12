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

public class MenuOption extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 626414247452779283L;
	public MenuOption(String s, Rectangle size, Point location, Image b, MenuScreen screen) {
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
				//System.out.println("worked once");
				try {
					MenuScreen f2 = (MenuScreen) MenuOption.this.screen;
					f2.open();
					MenuOption.this.screen.firePropertyChange("Open", 1, 2);
					MenuOption.this.screen.setEnabled(true);
				} catch(ClassCastException e1) {
					e1.printStackTrace();
				}
				try {
					MenuScreen f1 = (MenuScreen) MenuOption.this.getParent();
					f1.close();
					//MenuOption.this.getParent().firePropertyChange("Close", (long) 1, (long) 2);
//					MenuOption.this.getParent().setEnabled(false);
				} catch(ClassCastException e1) {
					e1.printStackTrace();
				}
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
			}
		};
		this.addMouseListener(l);
//		this.addPropertyChangeListener("Open", new PropertyChangeListener() {
//			
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				try {
//					if((long) evt.getNewValue()==(long) 2) {
//						MenuOption.this.firePropertyChange("Open", (long) 2, (long) 1);
//						MenuOption.this.draw();
//					}
//				} catch(ClassCastException e) {
//					System.out.println("y u feedin me non numbers?");
//				}
//			}
//		});
//		this.addPropertyChangeListener("Close", new PropertyChangeListener() {
//			
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				try {
//					if((long) evt.getNewValue()==(long) 2) {
//						MenuOption.this.firePropertyChange("Close", (long) 2, (long) 1);
//						MenuOption.this.erase();
//					}
//				} catch(ClassCastException e) {
//					System.out.println("y u feedin me non numbers?");
//				}				
//			}
//		});
	}
	public String words;
	public Rectangle size;
	public Point location;
	public Font font;
	public Graphics2D graph;
	public Image im;
	public MenuScreen screen;
	public Rectangle2D bounds2;
	public void draw() {
		if(this.getParent()!=null && this.getParent().isVisible()==true) {
			//this.setEnabled(true);
			//System.out.println("testing "+this.getName());
			this.setVisible(false);
			this.setVisible(true);
			this.graph = (Graphics2D) this.getGraphics();
//			this.bounds2 = this.font.getStringBounds(this.words, this.graph.getFontRenderContext());
//			this.graph.setColor(Color.BLUE);
//			this.graph.fillRect(0, 0, this.getWidth(), this.getHeight());
//			this.graph.setColor(this.color);
//			this.graph.setFont(this.font);
//			this.graph.drawString(this.words, 0, 25);
			this.graph.drawImage(this.im, 5, 5, null);
		}
	}
	public void erase() {
		this.setVisible(false);
		this.graph.clearRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		//this.setEnabled(false);
	}
	private static MenuScreen LEAVE_SCREEN = new MenuScreen(new Rectangle(1, 1), new Point(0, 0));
}