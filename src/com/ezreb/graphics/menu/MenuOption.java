package com.ezreb.graphics.menu;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MenuOption extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuOption(int width, int height, Image image) {
		this.width = width;
		this.height = height;
		this.image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		setBounds(new Rectangle(0, 0, width, height));
		this.setSize(width, height);
		setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(0, 0, width, height);
		canvas.setIgnoreRepaint(true);
		add(canvas);

	}
	public MenuOption(int width, int height, Image image, final MenuScreen moveTo) {
		this(width, height, image);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				moveTo.start();
				MenuOption.this.setVisible(false);
				
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
				// TODO Auto-generated method stub
				
			}
		});
	}
	private int width;
	private int height;
	private Canvas canvas;
	private Image image;
	public Canvas getCanvas() {
		return canvas;
	}
	public void start() {
		System.out.println("worked once in menuOption");
		if(this.getParent()!=null && this.isDisplayable()==true) {
			System.out.println("worked twice in menuOption");
			this.canvas.getGraphics().clearRect(0, 0, this.width, this.height);
			this.canvas.getGraphics().drawImage(image, 0, 0, null);
		}
	}
}
