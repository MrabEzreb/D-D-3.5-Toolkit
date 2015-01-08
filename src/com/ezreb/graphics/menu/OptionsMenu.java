package com.ezreb.graphics.menu;

import javax.swing.JPanel;

import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.images.ImageLoader;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptionsMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public OptionsMenu() {
		setBounds(new Rectangle(0, 0, 1366, 768));
		setLayout(null);
		
		MenuScreen menuScreen = new MenuScreen();
		menuScreen.setBounds(10, 11, 201, 101);
		add(menuScreen);
		
		MenuOption menuOption = new MenuOption(200, 100, (Image) ImageLoader.BACK_OPTION);
		menuOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				OptionsMenu.this.setVisible(false);
				((FullScreen) OptionsMenu.this.getParent()).start();
			}
		});
		menuScreen.add(menuOption);

		
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		// TODO Auto-generated method stub
		super.setVisible(aFlag);
		Component[] c = this.getComponents();
		for (Component component : c) {
			component.setVisible(aFlag);
		}
		if (aFlag) {
			this.requestFocusInWindow();
		}
	}
}
