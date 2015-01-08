package com.ezreb.graphics.HUD;

import javax.swing.JPanel;

import testing.SystemLogConfig;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

public class HUD extends JPanel {
	private Healthbar healthbar;

	/**
	 * Create the panel.
	 */
	public HUD() {
		setSize(new Dimension(1366, 768));
		setBounds(0, 0, 1366, 768);
		setLayout(null);
		
		healthbar = new Healthbar(75.0, 100.0);
		healthbar.setLocation(new Point(150, 50));
		healthbar.setSize(new Dimension(301, 51));
		healthbar.setBounds(150, 50, 301, 51);
		add(healthbar);

	}
	public void start() {
		if(this.getParent()!=null && this.isDisplayable()) {
			this.setVisible(true);
			if(SystemLogConfig.GRAPHICS_DRAW) {
				System.out.println("Started HUD");
			}
			Component[] c = this.getComponents();
			for (Component component : c) {
				try {
					((HUDElement) component).start();
				} catch(ClassCastException e) {
					
				}
			}
		}
	}

	public Healthbar getHealthbar() {
		return healthbar;
	}
}
