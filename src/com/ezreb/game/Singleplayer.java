package com.ezreb.game;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.HUD.HUD;
import com.ezreb.graphics.images.ImageLoader;
import com.ezreb.graphics.menu.MenuOption;
import com.ezreb.graphics.menu.MenuScreen;

public class Singleplayer extends JLayeredPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5088286743909861340L;
	private HUD hud;
	private MenuScreen menuScreen;
	private MenuOption menuOption;
	private JTextField textField;
	private JSplitPane MaximumHealth;
	private JTextField textField_1;
	private JButton btnSetMaxHealth;
	private JPanel CheatMenu;

	/**
	 * Create the panel.
	 */
	public Singleplayer() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println(":D");
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					if(Singleplayer.this.menuScreen.isVisible()==false) {
						Singleplayer.this.menuScreen.start();
						Singleplayer.this.menuScreen.requestFocusInWindow();
					}
				} else if(e.getKeyCode()==KeyEvent.VK_F3 && e.isControlDown()==true) {
					if(Singleplayer.this.CheatMenu.isVisible()==false) {
						Singleplayer.this.CheatMenu.setVisible(true);
						Singleplayer.this.lblNewLabel.setVisible(true);
						Singleplayer.this.CheatMenu.requestFocusInWindow();
					}
				}
			}
		});
		setBounds(new Rectangle(0, 0, 1366, 768));
		setLayout(null);
		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				super.focusLost(e);
//				Singleplayer.this.requestFocusInWindow();
//				Singleplayer.this.grabFocus();
			}
		});
		hud = new HUD();
		hud.setFocusable(false);
		hud.getHealthbar().setFocusable(false);
		hud.setBounds(0, 0, 1366, 768);
		this.setPosition(hud, 0);

		this.de = new DisplayEffects();
		de.c.setVisible(false);
		this.de.getCanvas().setFocusable(false);
		this.de.getCanvas().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				Singleplayer.this.processKeyEvent(e);
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				Singleplayer.this.processKeyEvent(e);
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				Singleplayer.this.processKeyEvent(e);
				// TODO Auto-generated method stub
				
			}
		});
		this.de.getCanvas().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				Singleplayer.this.processMouseEvent(e);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				Singleplayer.this.processMouseEvent(e);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				Singleplayer.this.processMouseEvent(e);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				Singleplayer.this.processMouseEvent(e);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Singleplayer.this.processMouseEvent(e);
			}
		});
		this.add(de.getCanvas());
		this.setPosition(de.getCanvas(), 10);
		
		menuScreen = new MenuScreen();
		menuScreen.setBounds(1165, 0, 201, 101);
		menuScreen.setVisible(false);
		menuScreen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					Singleplayer.this.menuScreen.setVisible(false);
					Singleplayer.this.requestFocusInWindow();
				}
			}
		});
		add(menuScreen);
		
		
		menuOption = new MenuOption(200, 100, ImageLoader.LEAVE_MENU);
		menuOption.getCanvas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Singleplayer.this.setVisible(false);
				Singleplayer.this.menuScreen.setVisible(false);
				((FullScreen) Singleplayer.this.getParent().getParent().getParent().getParent()).getMainMenu().setVisible(true);
				((FullScreen) Singleplayer.this.getParent().getParent().getParent().getParent()).getMainMenu().start();
			}
		});
		menuOption.setBounds(0, 0, 200, 100);
		menuScreen.add(menuOption);
		
		CheatMenu = new JPanel();
		CheatMenu.setVisible(false);
		CheatMenu.setBounds(200, 200, 201, 201);
		CheatMenu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_F3 && e.isControlDown()==true) {
					Singleplayer.this.CheatMenu.setVisible(false);
					Singleplayer.this.requestFocusInWindow(true);
				}
			}
		});
		add(CheatMenu);
		CheatMenu.setLayout(null);
		
		JSplitPane CurrentHealth = new JSplitPane();
		CurrentHealth.setBounds(0, 0, 200, 25);
		CurrentHealth.setDividerLocation(50);
		CurrentHealth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_F3 && e.isControlDown()==true) {
					Singleplayer.this.CheatMenu.setVisible(false);
					Singleplayer.this.requestFocusInWindow(true);
				}
			}
		});
		CheatMenu.add(CurrentHealth);
		
		textField = new JTextField();
		CurrentHealth.setLeftComponent(textField);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_F3 && e.isControlDown()==true) {
					Singleplayer.this.CheatMenu.setVisible(false);
					Singleplayer.this.requestFocusInWindow(true);
				}
			}
		});
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Set Health");
		CurrentHealth.setRightComponent(btnNewButton);
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_F3 && e.isControlDown()==true) {
					Singleplayer.this.CheatMenu.setVisible(false);
					Singleplayer.this.requestFocusInWindow(true);
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					double curHealth = Double.parseDouble(Singleplayer.this.textField.getText());
					Singleplayer.this.hud.getHealthbar().changeHealth(curHealth);
				} catch(NumberFormatException e1) {
					Singleplayer.this.textField.setText("Not a number");
				}
			}
		});
		
		MaximumHealth = new JSplitPane();
		MaximumHealth.setBounds(0, 25, 200, 25);
		MaximumHealth.setDividerLocation(50);
		MaximumHealth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_F3 && e.isControlDown()==true) {
					Singleplayer.this.CheatMenu.setVisible(false);
					Singleplayer.this.requestFocusInWindow(true);
				}
			}
		});
		CheatMenu.add(MaximumHealth);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_F3 && e.isControlDown()==true) {
					Singleplayer.this.CheatMenu.setVisible(false);
					Singleplayer.this.requestFocusInWindow(true);
				}
			}
		});
		MaximumHealth.setLeftComponent(textField_1);
		
		btnSetMaxHealth = new JButton("Set Max Health");
		MaximumHealth.setRightComponent(btnSetMaxHealth);
		
		lblNewLabel = new JTextArea("New label") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void onStart() {
				boolean isValid = true;
				int level = 1;
				String txt = lblNewLabel.getClass().getSuperclass().getSimpleName();
				System.out.println(txt);
				Component c = lblNewLabel;
				while (isValid) {
					String moreTxt;
					System.out.println("did the while");
					if(level>1) {
						System.out.println("did the if");
						try {
							System.out.println("did the try");
							c = c.getParent();
							
							moreTxt = c.getClass().getSimpleName();
							System.out.println(moreTxt);
							txt = moreTxt+" > \n"+txt;
						} catch(NullPointerException e) {
							System.out.println("did the catch");
							isValid = false;
						}
					}
					level = level+1;
				}
				lblNewLabel.setText(txt);
			}
			@Override
			public void setVisible(boolean aFlag) {
				// TODO Auto-generated method stub
				super.setVisible(aFlag);
				if(aFlag) {
					onStart();
				}
			}
		};
		lblNewLabel.setBounds(0, 50, 200, 150);
		lblNewLabel.setEditable(false);
		lblNewLabel.setLineWrap(true);
		CheatMenu.add(lblNewLabel);
		btnSetMaxHealth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_F3 && e.isControlDown()==true) {
					Singleplayer.this.CheatMenu.setVisible(false);
					Singleplayer.this.requestFocusInWindow(true);
				}
			}
		});
		btnSetMaxHealth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					double maxHealth = Double.parseDouble(Singleplayer.this.textField_1.getText());
					Singleplayer.this.hud.getHealthbar().changeHealth(Singleplayer.this.hud.getHealthbar().curHealth, maxHealth);
				} catch(NumberFormatException e1) {
					
				}
			}
		});

		add(hud);

	}
	JTextArea lblNewLabel;
	DisplayEffects de;

	@Override
	public boolean isOptimizedDrawingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	public HUD getHud() {
		return hud;
	}
	public void start() {
		this.setVisible(true);
		de.getCanvas().setVisible(true);
		this.hud.setVisible(true);
		this.hud.start();
		requestFocus();
		requestFocusInWindow();
		//de.c.setVisible(true);
	}
	@Override
	public void setVisible(boolean aFlag) {
		// TODO Auto-generated method stub
		if(aFlag == false) {
			this.de.getCanvas().setVisible(false);
		}
		super.setVisible(aFlag);
	}
	public MenuScreen getMenuScreen() {
		return menuScreen;
	}
	public MenuOption getMenuOption() {
		return menuOption;
	}
	public JPanel getCheatMenu() {
		return CheatMenu;
	}
}
