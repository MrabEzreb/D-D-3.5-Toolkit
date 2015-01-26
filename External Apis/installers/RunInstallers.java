package installers;

public class RunInstallers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassLoader c = RunInstallers.class.getClassLoader();
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(c.getParent());
		System.out.println(c.getResource(""));
		System.out.println(c.getParent().toString());
	}

}
