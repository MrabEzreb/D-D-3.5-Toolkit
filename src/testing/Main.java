package testing;

import installers.DllLoader;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import com.ezreb.data.Language;
import com.ezreb.game.Singleplayer;
import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.HUD.Healthbar;
import com.ezreb.graphics.images.ImageLoader;
import com.ezreb.graphics.menu.MenuOption;
import com.ezreb.graphics.menu.MenuScreen;
import com.ezreb.jsongen.JSONApplet;
import com.ezreb.utils.Copier;
import com.ezreb.utils.InitialFileCreator;
import com.ezreb.utils.JarAccess;
import com.ezreb.utils.ProceduralArray;
import com.ezreb.utils.types.Environment;

public class Main {

	public static String PATH = "";
	public static void main(String[] args) throws InterruptedException {
		//FullScreenDep f = new FullScreenDep();
		//Healthbar h = new Healthbar(100, 100);
		if(args.length == 1 && args[0].equals("finalize")) {
			Thread.sleep(10000);
			String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getFile();
			String[] files = {"j3dcore-d3d.dll","j3dcore-ogl-chk.dll","j3dcore-ogl-cg.dll","j3dcore-ogl.dll"};
			for (String string : files) {
				new File(path+"//"+string).delete();
			}
		} else {
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				
				@Override
				public void run() {
					String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getFile();
					String name = null;
					if(System.getProperty("java.class.path").indexOf(";") != -1) {
						name = System.getProperty("java.class.path").substring(0, System.getProperty("java.class.path").indexOf(";"));
					} else {
						name = System.getProperty("java.class.path");
					}
				}
			}));
		}
		System.out.println(DllLoader.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		System.out.println(DllLoader.class.getResource("/Java3D Dlls/x86/j3dcore-d3d.dll").getFile());
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(System.getProperty("java.library.path"));
		PATH = System.getProperty("java.library.path").substring(0, System.getProperty("java.library.path").indexOf(";"));
		//System.load(DllLoader.class.getResource("/Java3D Dlls/x86/j3dcore-d3d.dll").getFile());
		System.setProperty("java.library.path", System.getProperty("java.library.path").substring(0, System.getProperty("java.library.path").length()-1)+Environment.getCurrentEnvironment().getAppData()+"\\Java3D Dlls\\x"+Environment.getCurrentEnvironment().getBit()+";.");
		DllLoader.loadCorrect();
		System.out.println(System.getProperty("java.class.path")+"Classpath");
		if(System.getProperty("java.class.path").indexOf(";") != -1) {
			System.out.println(System.getProperty("java.class.path").substring(0, System.getProperty("java.class.path").indexOf(";")));
		} else {
			System.out.println(System.getProperty("java.class.path"));
		}
		Thread.sleep(1000);
		//f.toggleVisible();
		if(args.length == 0) {
			args = new String[1];
			args[0] = "NewFullScreen";
		} else if(args[0].equals("")) {
			args[0] = "NewFullScreen";
		}
		if(args.length > 1 && args[1].equals("SkipPreInit")) {
			System.out.println("skipped preinit");
		} else {
			ImageLoader.loadImages();
			InitialFileCreator.generateFiles();
			Language.loadLanguages();
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
				File copyDir = new File(f.getParentFile().getParentFile().getParentFile().getPath()+"/test.exe");
				try {
					Copier.copy(f, copyDir);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				File f2 = copyDir;
				System.out.println(f2.canExecute());
				f2.setExecutable(true, false);
				try {
					Runtime.getRuntime().exec(f2.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(args[0].equals("DoNothing")) {
				System.out.println("DidNothing!");
			} else if(args[0].equals("CheckPaths")) {
					Class<?> c = Main.class;
					System.out.println(c.getResource("/com/ezreb/graphics/images/Back.png").toExternalForm());
					ProceduralArray paths = new ProceduralArray(String.class);
					try {
						paths.addToArray(c.getResource("").toString());
					} catch(NullPointerException e) {
						System.out.println("1");
					}
					try {
						paths.addToArray(c.getResource("com").toString());
					} catch(NullPointerException e) {
						System.out.println("2");
					}
					try {
						paths.addToArray(c.getResource("src").toString());
					} catch(NullPointerException e) {
						System.out.println("3");
					}
					try {
						paths.addToArray(c.getResource("/").toString());
					} catch(NullPointerException e) {
						System.out.println("3");
					}
					Object[] s = paths.getArray();
					for (Object string : s) {
						if (string instanceof String) {
							String s2 = (String) string;
							System.out.println(s2);
						}
					}
					System.out.println(c.getResource("com"));
					System.out.println(c.getResource("com/ezreb"));
					System.out.println(c.getResource("com/ezreb/graphics"));
					System.out.println(c.getResource("com/ezreb/graphics/images"));
					System.out.println(c.getResource("com/ezreb/graphics/images/Back.png"));

					System.out.println(c.getResource("com").getFile());
//					System.out.println(c.getResource("com/ezreb").getPath());
//					System.out.println(c.getResource("com/ezreb/graphics").getPath());
//					System.out.println(c.getResource("com/ezreb/graphics/images").getPath());
					System.out.println(new File(c.getResource("com/ezreb/graphics/images/Back.png").getFile()).getAbsolutePath());
					System.out.println(new File(c.getResource("\\").getFile()).getAbsolutePath());
					
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
