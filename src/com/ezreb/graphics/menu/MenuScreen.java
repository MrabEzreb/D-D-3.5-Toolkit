package com.ezreb.graphics.menu;

import java.awt.Component;

import javax.swing.JPanel;

public class MenuScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3884138822268843554L;
	/**
	 * Create the panel.
	 */
	public MenuScreen() {
		setIgnoreRepaint(true);
		setLayout(null);

	}
	public void start() {
		this.setVisible(true);
		Component[] c = this.getComponents();
		for (Component component : c) {
			try {
				((MenuOption) component).start();
			} catch(ClassCastException e) {
				
			}
		}
	}
	public void close() {
//		Component[] c = this.getComponents();
//		for (Component component : c) {
//			try {
//				((MenuOption) component).setVisible(false);
//			} catch(ClassCastException e) {
//				
//			}
//		}
	}

}
