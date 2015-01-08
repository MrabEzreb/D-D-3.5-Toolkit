package installers;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.sun.nio.zipfs.JarFileSystemProvider;

public class RunInstallers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassLoader c = RunInstallers.class.getClassLoader();
		System.out.println(c.getSystemClassLoader());
		System.out.println(c.getParent());
		System.out.println(c.getResource(""));
		System.out.println(c.getParent().toString());
	}

}
