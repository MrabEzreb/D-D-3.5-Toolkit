package com.ezreb.graphics.HUD;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Healthbar extends Component {

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
		this.setIgnoreRepaint(true);
		this.maxHealth = maxHealth;
		this.setSize(201, 21);
		this.validate();
		this.addHierarchyListener(new HierarchyListener() {
			
			@Override
			public void hierarchyChanged(HierarchyEvent arg0) {
				if(Healthbar.this.isDisplayable()) {
					Healthbar.this.setBounds(25, 50, 201, 21);
					Healthbar.this.validate();
					try {
						Healthbar.this.draw();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(Healthbar.this);
				}
				
			}
		});
//		this.addHierarchyListener(new HierarchyListener() {
//			
//			@Override
//			public void hierarchyChanged(HierarchyEvent e) {
//				if(e.getID()==HierarchyEvent.HIERARCHY_CHANGED) {
//					if(Healthbar.this.getParent()!=null) {
//						//Healthbar.this.add(Healthbar.this.mouseMessage2);
//						System.out.println("HGot parent");
//						Healthbar.this.hasParent = true;
//						Healthbar.this.validate();
//						Healthbar.this.setVisible(true);
//						Healthbar.this.g = (Graphics2D) Healthbar.this.getGraphics();
//						Healthbar.this.draw();
//						Healthbar.this.setSize(201, 21);
//						Healthbar.this.g.setColor(Color.BLACK);
//						Healthbar.this.g.fillRect(Healthbar.this.location.x, Healthbar.this.location.y, 201, 21);
//					} else {
//						//Healthbar.this.remove(Healthbar.this.mouseMessage2);
//						System.out.println("lost parent");
//						Healthbar.this.hasParent = false;
//						Healthbar.this.setVisible(false);
//					}
//				}
//				
//			}
//		});
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
	public void draw() throws IOException {
		if(Healthbar.this.hasParent==true) {
			this.setSize(201, 21);
			if(this.curHealth!=0) {
				double ch = this.curHealth;
				double mh = this.maxHealth;
				this.health = new Rectangle(0, 0, (int) Math.floor((ch/mh)*200), 20);
				Image frame = ImageIO.read(new File("src", "com/ezreb/graphics/images/health_border.png")).getScaledInstance(200, 20, Image.SCALE_DEFAULT);
				Image fill = ImageIO.read(new File("src", "com/ezreb/graphics/images/health_bar.png")).getScaledInstance(this.health.width-1, this.health.height-1, Image.SCALE_DEFAULT);
				this.getGraphics().drawImage(frame, 0, 0, null);
				this.getGraphics().drawImage(fill, 0, 0, null);
			}
		}
	}
	public Healthbar setHealthMax(int h) throws IOException {
		this.maxHealth = h;
		this.draw();
		return this;
	}
	public Healthbar setHealth(int h) throws IOException {
		this.curHealth = h;
		this.draw();
		return this;
	}

}
