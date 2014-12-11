package testing;

import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.HUD.Healthbar;
import com.ezreb.graphics.menu.MainMenu;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		FullScreen f = new FullScreen();
		//Healthbar h = new Healthbar(100, 100);
		Thread.sleep(1000);
		f.toggleVisible();
		MainMenu.run(f);
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 101; j++) {
//				h.setHealth(j);
//				f.paintComponents(f.getGraphics());
//				//f.paint(f.getGraphics());
//				System.out.println(f.getComponents()[0]);
//				Thread.sleep(500);
//			}
//		}
	}
	//it broke

}
