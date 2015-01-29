package com.ezreb.graphics.HUD;

import java.awt.image.BufferedImage;

import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.OrderedGroup;
import com.ezreb.graphics.images.ImageLoader;

public class Healthbar3D extends OrderedGroup {

	public Healthbar3D(int health, int maxHealth) {
		super();
		this.curHealth = health;
		this.maxHealth = maxHealth;
		this.Border = new ImageComponent2D(ImageComponent2D.FORMAT_RGB, (BufferedImage) ImageLoader.HEALTH_BORDER.getScaledInstance(200, 20, 0));
		this.Fill = new ImageComponent2D(ImageComponent2D.FORMAT_RGB, (BufferedImage) ImageLoader.HEALTH_FILL.getScaledInstance(200, 20, 0));
	}
	ImageComponent2D Border;
	ImageComponent2D Fill;
	int x;
	int curHealth;
	int maxHealth;
	Thread refreshHeath = new Thread(new Runnable() {
		
		@Override
		public void run() {
			Healthbar3D.this.x = Healthbar3D.this.curHealth/Healthbar3D.this.maxHealth*200;
			Healthbar3D.this.Fill.set((BufferedImage) ImageLoader.HEALTH_FILL.getScaledInstance(x, 20, 0));
			
		}
	});
}