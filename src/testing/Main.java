package testing;

import java.io.File;
import java.io.IOException;

import com.ezreb.game.Singleplayer;
import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.menu.MainMenu;
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
