package com.ezreb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copier {

	public static void copy(File in, File out) throws IOException {
		in.createNewFile();
		out.createNewFile();
		InputStream br = new FileInputStream(in);
		OutputStream bw = new FileOutputStream(out);
		byte[] b = new byte[1024];
		while(br.available() > 0) {
			br.read(b);
			bw.write(b);
			b = new byte[1024];
		}
		br.close();
		bw.close();
	}
}
