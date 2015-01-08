package com.ezreb.graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.ezreb.graphics.images.ImageLoader;
import com.ezreb.graphics.menu.MenuScreen;
import com.ezreb.graphics.menu.MenuOption;
import com.ezreb.jsongen.JSONApplet;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.ezreb.game.Singleplayer;
import com.ezreb.graphics.menu.OptionsMenu;

public class FullScreen extends JFrame {
	private MenuScreen MainMenu;
	private Singleplayer singleplayer;
	private OptionsMenu optionsMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullScreen frame = new FullScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FullScreen() {
		setBounds(new Rectangle(0, 0, 1366, 768));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(FullScreenTest.this);
			}
		});
		setVisible(false);
		setUndecorated(true);
		setResizable(false);
		setSize(new Dimension(1366, 768));
		setBounds(0, 0, 1366, 768);
		getContentPane().setLayout(null);
		
		MainMenu = new MenuScreen();
		MainMenu.setIgnoreRepaint(false);
		MainMenu.setOpaque(false);
		MainMenu.setBounds(100, 100, 201, 404);
		getContentPane().add(MainMenu);
		
		MenuOption SingleplayerOption = new MenuOption(200, 100, ImageLoader.SINGLEPLAYER_MENU);
		SingleplayerOption.getCanvas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FullScreen.this.MainMenu.setVisible(false);
				FullScreen.this.singleplayer.start();
			}
		});
		SingleplayerOption.setBounds(0, 0, 200, 100);
		MainMenu.add(SingleplayerOption);
		
		MenuOption JSONGenOption = new MenuOption(200, 100, ImageLoader.JSON_GENERATOR_MENU);
		JSONGenOption.getCanvas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("SOrtof worked");
				FullScreen.this.setVisible(false);
				JSONApplet j = new JSONApplet();
				Frame f2 = new Frame();
				j.start();
				f2.setVisible(true);
				j.setVisible(true);
				j.setLocation(9, 31);
				f2.setSize(468, 340);
				f2.setPreferredSize(new Dimension(468, 340));
				f2.add(j);
				f2.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						e.getWindow().dispose();
						super.windowClosing(e);
					}
				});
				FullScreen.this.dispose();
			}
		});
		JSONGenOption.setBounds(0, 101, 200, 100);
		MainMenu.add(JSONGenOption);
		
		MenuOption ExitOption = new MenuOption(200, 100, ImageLoader.LEAVE_MENU);
		ExitOption.getCanvas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				System.exit(0);
			}
		});
		ExitOption.setBounds(0, 303, 200, 100);
		MainMenu.add(ExitOption);
		
		MenuOption menuOption = new MenuOption(200, 100, ImageLoader.BACK_OPTION);
		menuOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//System.out.println("go");
				FullScreen.this.getMainMenu().setVisible(false);
				FullScreen.this.getOptionsMenu().setVisible(true);
				//System.out.println("go");
			}
		});
		menuOption.setBounds(0, 202, 200, 100);
		MainMenu.add(menuOption);
		
		singleplayer = new Singleplayer();
		singleplayer.setVisible(false);
		singleplayer.setBounds(0, 0, 1366, 768);
		getContentPane().add(singleplayer);
		
		optionsMenu = new OptionsMenu();
		optionsMenu.setBounds(0, 0, 1366, 768);
		optionsMenu.setVisible(false);
		getContentPane().add(optionsMenu);
	}
	public MenuScreen getMainMenu() {
		return MainMenu;
	}
	public void start() {
		this.setVisible(true);
		this.MainMenu.start();
	}
	public Singleplayer getSingleplayer() {
		return singleplayer;
	}
	public OptionsMenu getOptionsMenu() {
		return optionsMenu;
	}
}
