package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class TestVelocity {

	public TestVelocity() {
	}

	public TestVelocity(String templateFile) {

		VelocityEngine ve = new VelocityEngine();
		Properties properties = new Properties();

		// 将需要的数据加载到模板引擎的上下文中
		VelocityContext context = new VelocityContext();
		context.put("list", getData());

		Template template = null;
		String path = this.getClass().getResource("/").toString()
				.replaceAll("^file:/", "");
		String basePath = "D:/";
		// 获取模板文件
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, basePath);
		// 初始化一个模板引擎
		ve.init(properties);
		template = ve.getTemplate(templateFile);
		BufferedWriter writer = null;
		FileWriter fWriter = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(System.out));
			File tt = new File("src/main/resources");
			File tt2 =new File("src/main/resources", "src/main/resources/22q.txt");
			if(tt.isDirectory()){
				System.out.println("Diectory is");
				tt.listFiles();
				for(File ff:tt.listFiles()){
					System.out.println(ff.getName());
				}
			}
			 fWriter = new FileWriter(tt2.getName());
			if (template != null) {
				//template.merge(context, fWriter);
				 template.merge(context, fWriter);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
				fWriter.flush();
				fWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 构造数据
	 * 
	 * @return
	 */
	private ArrayList<String> getData() {
		ArrayList<String> list = new ArrayList<String>();

		list.add("ArrayList element 1");
		list.add("ArrayList element 2");
		list.add("ArrayList element 3");
		list.add("ArrayList element 4");

		return list;
	}

	public static void main(String[] args){
		new TestVelocity("example.vm"); 
	}

}
