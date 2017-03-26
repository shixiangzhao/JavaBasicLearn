package shixzh.jbl.nio;

import java.io.*;

public class InputStreamSkip {

	public static void main(String[] args) throws IOException {
		String fileName = "test.txt";
		String path1 = System.getProperty("java.class.path") + "/shixzh/jbl/nio/" + fileName;
		// String path2 = File.separator + "home" + File.separator + "shixzh" +
		// File.separator + "test.txt";
		// System.out.println(path2);
		File file = new File(path1);
		InputStream inputStream1 = null; // init value
		InputStream inputStream2 = null; // after skip 4
		try {
			inputStream1 = new FileInputStream(file);
			inputStream2 = new FileInputStream(file);
			System.out.println("inputStream value before skip(): ");
			printStream(inputStream1);
			inputStream2.skip(4l);
			System.out.println("inputStream value after skip(): ");
			printStream(inputStream2);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			inputStream1.close();
			inputStream2.close();
		}
	}

	public static void printStream(InputStream inputStream) throws IOException {
		int tempbyte;
		while ((tempbyte = inputStream.read()) != -1) {
			System.out.write(tempbyte);
			System.out.println(" unicode: " + tempbyte);
		}
	}
}
