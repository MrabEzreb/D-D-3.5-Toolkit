package com.ezreb.graphics.HUD;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Canvas;

import javax.swing.JProgressBar;

import testing.SystemLogConfig;

import com.ezreb.graphics.images.ImageLoader;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;

public class Healthbar extends HUDElement {

	/**
	 * Create the panel.
	 */
	public Healthbar(double cur, double max) {
		this.curHealth = cur;
		this.maxHealth = max;
		setSize(new Dimension(xlength+1, ylength+1));
		setLocation(300, 50);
		setBounds(300, 50, xlength+1, ylength+1);
		setLayout(null);
		
		canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setBounds(0, 0, xlength, ylength);
		add(canvas);

	}
	public double curHealth;
	public double maxHealth;
	private double length;
	private int xlength = 300;
	private int ylength = 30;
	private boolean isShown = false;
	private Canvas canvas;
	private Image border = ImageLoader.HEALTH_BORDER.getScaledInstance(xlength, ylength, Image.SCALE_DEFAULT);
	private Image fill = ImageLoader.HEALTH_FILL.getScaledInstance(xlength, ylength, Image.SCALE_DEFAULT);
	private Image currentFill = fill.getScaledInstance(xlength, ylength, Image.SCALE_DEFAULT);
	private Image error = ImageLoader.HEALTH_ERROR.getScaledInstance(xlength, ylength, Image.SCALE_DEFAULT);
	@Override
	public void start() {
		if(this.getParent()!=null && this.isDisplayable()) {
			if(SystemLogConfig.GRAPHICS_DRAW) {
				System.out.println("Healthbar created");
			}
			this.setVisible(true);
			this.canvas.getGraphics().clearRect(0, 0, xlength, ylength);
			if(curHealth>0 && maxHealth>0) {
				try {
					length = Math.floor((curHealth/maxHealth)*xlength);
					currentFill = fill.getScaledInstance((int) length, ylength, Image.SCALE_DEFAULT);
				} catch(ArithmeticException e) {
					currentFill = error;
				}
			}
			this.canvas.getGraphics().drawImage(currentFill, 0, 0, null);
			this.canvas.getGraphics().drawImage(border, 0, 0, null);
		}
	}
	public void changeHealth(double current, double maximum) {
		this.curHealth = current;
		this.maxHealth = maximum;
		this.start();
	}
	public void changeHealth(double current) {
		this.changeHealth(current, this.maxHealth);
	}
	public Canvas getCanvas() {
		return canvas;
	}
}
