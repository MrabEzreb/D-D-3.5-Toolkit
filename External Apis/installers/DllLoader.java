package installers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;

import com.ezreb.utils.types.Environment;

public class DllLoader {

	private static Environment e;
	private static String dllLoc = "/Java3D Dlls";
	private static String dllLoc2 = "";
	private static String[] x64Dlls = {"j3dcore-ogl.dll"};
	private static String[] x86Dlls = {"j3dcore-d3d.dll","j3dcore-ogl-chk.dll","j3dcore-ogl-cg.dll","j3dcore-ogl.dll"};
	public static void loadCorrect() {
		e = Environment.getCurrentEnvironment();
		if(e.getBit().equals("64")) {
			dllLoc = dllLoc+"/x64";
			for (String string : x64Dlls) {
				loadDll(string);
			}	
		} else if(e.getBit().equals("32")) {
			dllLoc = dllLoc+"/x86";
			for (String string : x86Dlls) {
				loadDll(string);
			}
		}
	}
	public static void loadDll(final String name) {
		URL dll = DllLoader.class.getResource(dllLoc+"/"+name);
		System.out.println(dll.toString());
		try {
			new File(e.getAppData()+dllLoc2).mkdirs();
			System.out.println("1");
			InputStream in =  DllLoader.class.getResourceAsStream(dllLoc+"/"+name);
			System.out.println("1");
			OutputStream out = new FileOutputStream(new File(dllLoc2+name));
			System.out.println("1");
			byte[] b = new byte[1];
			while(in.available() > 0) {
				in.read(b);
				out.write(b);
				b = new byte[1];
			}
			in.close();
			out.close();
			System.out.println("1");
			System.out.println(new File(dllLoc2+name).getAbsolutePath());
//			System.setProperty("java.class.path", System.getProperty("java.class.path")+";"+Environment.getCurrentEnvironment().getAppData()+"\\Java3D Dlls\\"+name);
//			System.setProperty("java.library.path", System.getProperty("java.library.path").substring(0, System.getProperty("java.library.path").length()-1)+Environment.getCurrentEnvironment().getAppData()+"\\Java3D Dlls\\"+name.substring(0, name.length()-4)+";.");
			//System.load(new File(dllLoc2+name).getAbsolutePath());
			System.out.println("1");
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Files.delete(new File(new File(dllLoc2+name).getAbsolutePath()).toPath());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e.toString());
					}
					System.out.println("Deleted "+name);
				}
			}));
			//System.loadLibrary(name.substring(0, name.length()-4));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
