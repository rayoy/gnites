package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TTT {

	public static void main(String[] args) {

		Properties p = new Properties();
		InputStream fis =TTT.class.getClassLoader().getResourceAsStream("email.properties");
		try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(p.getProperty("aa"));
	}
}
