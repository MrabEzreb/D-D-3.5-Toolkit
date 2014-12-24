package testing;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import sun.applet.AppletViewer;

import com.ezreb.game.Singleplayer;
import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.menu.MainMenu;
import com.ezreb.jsongen.JSONApplet;
import com.ezreb.utils.InitialFileCreator;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		FullScreen f = new FullScreen();
		//Healthbar h = new Healthbar(100, 100);
		Thread.sleep(1000);
		f.toggleVisible();
		File settings = new File("src", "com/ezreb/utils/paths.txt");
		if(settings.exists()==false) {
			InitialFileCreator.generateFiles();
		}
		try {
			if(args[0].equals("devWorld")) {
				Singleplayer s = new Singleplayer(f);
				f.add(s);
				s.setVisible(true);
			} else if(args[0].equals("JSON")) {
				JSONApplet j = new JSONApplet();
				f.setVisible(false);
				Frame f2 = new Frame();
				//f.add(j);
				j.start();
				f2.setVisible(true);
				j.setVisible(true);
				j.setLocation(9, 31);
				f2.setSize(468, 340);
				f2.setPreferredSize(new Dimension(468, 340));
				f2.add(j);
			} else {
				System.out.println("what?");
				try {
					MainMenu.run(f);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			try {
				MainMenu.run(f);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	//it broke
	}

}
