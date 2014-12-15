package testing;

import java.io.IOException;

import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.menu.MainMenu;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		FullScreen f = new FullScreen();
		//Healthbar h = new Healthbar(100, 100);
		Thread.sleep(1000);
		f.toggleVisible();
		try {
			MainMenu.run(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//it broke
	}

}
