package testing;

import com.ezreb.utils.ErrorWindow;

public class Main {

	public static void main(String[] args) {
		ErrorWindow e = new ErrorWindow("Testing");
		e.addOptions("Die");
		e.addOptions("Hello!");
		String r = e.showError();
		System.out.println(r);

	}
	//it broke

}
