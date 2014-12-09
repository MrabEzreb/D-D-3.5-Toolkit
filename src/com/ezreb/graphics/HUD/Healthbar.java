package com.ezreb.graphics.HUD;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ezreb.graphics.elements.Word;

public class Healthbar extends Container {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1586260475434936946L;	
	public Healthbar() {
		this(100, 0);
	}
	public Healthbar(int maxHealth) {
		this(maxHealth, 0);
	}
	public Healthbar(int maxHealth, int curHealth) {
//		this.setPreferredSize(new Dimension(201, 21));
//		this.setSize(new Dimension(201, 21));
		MouseListener l = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
//				Point p1 = Healthbar.this.location;
//				Point p2 = e.getPoint();
//				Healthbar.this.location = new Point(p2.x-Healthbar.this.relMouseLoc.x, p2.y-Healthbar.this.relMouseLoc.y);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
//				Point p1 = new Point(Healthbar.this.getLocation());
//				Point p2 = e.getPoint();
//				Healthbar.this.mouseLocation = p2;
//				Healthbar.this.location = p1;
//				Healthbar.this.relMouseLoc = new Point(p2.x-p1.x, p2.y-p1.y);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(Healthbar.this.hasParent==true) {
					//if(e.getX()>Healthbar.this.location.x && e.getX()<(Healthbar.this.location.x+200) && e.getY()>Healthbar.this.location.y && e.getY()<(Healthbar.this.location.y+20)) {
						Healthbar.this.hasText = false;
						Healthbar.this.g.clearRect(0, 0, 200, 20);
					//}
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(Healthbar.this.hasParent==true) {
					//if(e.getX()>Healthbar.this.location.x && e.getX()<(Healthbar.this.location.x+200) && e.getY()>Healthbar.this.location.y && e.getY()<(Healthbar.this.location.y+20)) {
						Healthbar.this.hasText = true;
					//}
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		this.addMouseListener(l);
		this.maxHealth = maxHealth;
		this.addHierarchyListener(new HierarchyListener() {
			
			@Override
			public void hierarchyChanged(HierarchyEvent e) {
				if(e.getID()==HierarchyEvent.HIERARCHY_CHANGED) {
					if(Healthbar.this.getParent()!=null) {
						//Healthbar.this.add(Healthbar.this.mouseMessage2);
						System.out.println("HGot parent");
						Healthbar.this.hasParent = true;
						Healthbar.this.validate();
						Healthbar.this.setVisible(true);
						Healthbar.this.g = (Graphics2D) Healthbar.this.getGraphics();
						Healthbar.this.draw();
						//Healthbar.this.setPreferredSize(Healthbar.this.getParent().getSize());
						Healthbar.this.setSize(201, 21);
						Healthbar.this.g.setColor(Color.BLACK);
						Healthbar.this.g.fillRect(0, 0, 201, 21);
					} else {
						//Healthbar.this.remove(Healthbar.this.mouseMessage2);
						System.out.println("lost parent");
						Healthbar.this.hasParent = false;
						Healthbar.this.setVisible(false);
					}
				}
				
			}
		});
	}
	public Graphics2D g;
	private Rectangle health;
	private int maxHealth;
	private int curHealth;
	public String mouseMessage = "Health";
	public boolean hasText = false;
	public boolean hasParent = false;
	public Point location = new Point(0, 0);
	public Point mouseLocation = this.getMousePosition();
	public Point relMouseLoc;
	public void draw() {
		if(Healthbar.this.hasParent==true) {
			this.setBounds(25, 50, 201, 21);
			if(this.curHealth!=0) {
				double ch = this.curHealth;
				double mh = this.maxHealth;
				this.health = new Rectangle(this.location.x, this.location.y, (int) Math.floor((ch/mh)*200), 20);
				//this.setSize(201,20);
				System.out.println(this.health.width+":"+this.health.height);
				this.g.setColor(Color.red);
				this.g.fillRect(this.location.x, this.location.y, health.width, health.height);
				this.g.setColor(Color.GRAY);
				this.g.drawRect(this.location.x, this.location.y, 200, 20);
				//System.out.println("worked");
				//this.paint(this.g);
			}
			if(this.hasText==true) {
				this.g.setColor(Color.YELLOW);
				this.g.drawString("Health", this.location.x+15, this.location.y+15);
			}
		}
	}
	public Healthbar setHealthMax(int h) {
		this.maxHealth = h;
		this.draw();
		return this;
	}
	public Healthbar setHealth(int h) {
		this.curHealth = h;
		this.draw();
		return this;
	}

}
