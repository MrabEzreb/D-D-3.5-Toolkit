package testing;

import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.HUD.Healthbar;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		FullScreen f = new FullScreen();
		f.toggleVisible();
		Healthbar h = new Healthbar(100, 100, f.getGraphics());
		f.toggleVisible();
		Thread.sleep(1000);
		h.setLocation(50, 50);
		f.add(h);
		f.toggleVisible();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 101; j++) {
				h.setHealth(j);
				Thread.sleep(1000);
			}
		}
	}
	//it broke

}
