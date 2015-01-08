package testing;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.LookAndFeel;

import sun.applet.AppletViewer;
import sun.nio.ch.WindowsAsynchronousChannelProvider;
import sun.reflect.MethodAccessor;

import com.ezreb.game.Singleplayer;
import com.ezreb.game.SingleplayerDep;
import com.ezreb.graphics.FullScreenDep;
import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.HUD.HUD;
import com.ezreb.graphics.HUD.Healthbar;
import com.ezreb.graphics.images.ImageLoader;
import com.ezreb.graphics.menu.MainMenu;
import com.ezreb.graphics.menu.MenuOption;
import com.ezreb.graphics.menu.MenuScreen;
import com.ezreb.jsongen.JSONApplet;
import com.ezreb.utils.InitialFileCreator;
import com.ezreb.utils.JarAccess;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//FullScreenDep f = new FullScreenDep();
		//Healthbar h = new Healthbar(100, 100);
		Thread.sleep(1000);
		//f.toggleVisible();
		ImageLoader.loadImages();
		File settings = new File("src", "com/ezreb/utils/paths.txt");
		if(settings.exists()==false) {
			InitialFileCreator.generateFiles();
		}
		try {
			if(args[0].equals("devWorld")) {
				Singleplayer h = new Singleplayer();
				Frame f2 = new Frame();
				//f.setVisible(false);
				f2.setVisible(true);
				f2.setSize(1384, 808);
				f2.setPreferredSize(new Dimension(1384, 808));
				f2.add(h);
				h.setVisible(true);
				h.setLocation(9, 31);
				h.start();
				Healthbar hb = h.getHud().getHealthbar();
				for (int i = -100; i < 100; i++) {
					hb.changeHealth(Math.abs(i));
					try {
						Thread.sleep(250);
					} catch(InterruptedException e) {
						
					}
				}
			} else if(args[0].equals("JSON")) {
				JSONApplet j = new JSONApplet();
				//f.setVisible(false);
				Frame f2 = new Frame();
				//f.add(j);
				j.start();
				f2.setVisible(true);
				j.setVisible(true);
				j.setLocation(9, 31);
				f2.setSize(468, 340);
				f2.setPreferredSize(new Dimension(468, 340));
				f2.add(j);
			} else if(args[0].equals("NewMenu")) {
				final MenuScreen ms = new MenuScreen();
				ms.setBounds(0, 0, 201, 202);
				MenuOption mo1 = new MenuOption(200, 100, ImageLoader.SINGLEPLAYER_MENU);
				mo1.setLocation(0, 0);
				final Singleplayer h = new Singleplayer();
				Frame f2 = new Frame();
				//f.setVisible(false);
				f2.setVisible(true);
				f2.setSize(1384, 808);
				f2.setPreferredSize(new Dimension(1384, 808));
				f2.add(h);
				mo1.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						ms.setVisible(false);
						h.setVisible(true);
						h.setLocation(9, 31);
						h.start();
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
				ms.add(mo1);
				MenuOption mo2 = new MenuOption(200, 100, ImageLoader.LEAVE_MENU);
				mo2.setLocation(0, 101);
				mo2.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
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
				ms.add(mo2);
				f2.add(ms);
				ms.start();
				
			} else if(args[0].equals("NewFullScreen")) {
				FullScreen f2 = new FullScreen();
				//f2.setVisible(true);
				f2.start();
				//f.setVisible(false);
				//f.dispose();
			} else if(args[0].equals("Methods")) {
				Method[] m = Main.class.getDeclaredMethods();
				Method m2;
				try {
					System.out.println(Main.class.getName());
					m2 = Main.class.getDeclaredMethod("main", String[].class);
					System.out.println(m2.toString());
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Method method : m) {
					System.out.println(method.toString());
					
				}
				System.exit(0);
			} else if(args[0].equals("GetJar")) {
				System.out.println(JarAccess.parentJar);
				System.out.println(JarAccess.parentJar2);
				System.out.println(JarAccess.installer);
				File f = JarAccess.installer;
				System.out.println(f.canExecute());
				Path copyDir = new File(f.getParentFile().getParentFile().getParentFile().getPath()+"/test.exe").toPath();
				try {
					Files.copy(f.toPath(), copyDir, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				File f2 = copyDir.toFile();
				System.out.println(f2.canExecute());
				f2.setExecutable(true, false);
				try {
					Runtime.getRuntime().exec(f2.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("what?");
//				try {
//					//MainMenu.run(f);
//				} catch (IOException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
//			try {
//				//MainMenu.run(f);
//			} catch (IOException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
		}
	//it broke
	}

}
