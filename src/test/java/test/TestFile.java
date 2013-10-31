package test;

import java.io.File;

public class TestFile {

	public static void main(String[] args){
		try{
			String sdir = System.getProperty("user.dir");
			File f = new File(sdir+"/src/main/resources/23.txt");
			System.out.println(f);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
