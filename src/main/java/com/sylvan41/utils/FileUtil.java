/**
 * 
 */
package com.sylvan41.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作类,处理文件扫描等操作
 * @author Administrator
 *
 */
public class FileUtil {

	
	/**
	 * 扫描文件路径
	 * @param path 要扫描的文件夹路径
	 * @return 返回path目录下的所有文件夹(路径)
	 */
	public List<String> scan(File path){
		List<String> allPath=new ArrayList<String>();
		for(File file:path.listFiles()){
			if(file.isDirectory()){
				allPath.add(file.getPath());
				allPath.addAll(scan(file));
			}
		}
		return allPath;
	}
	
	/**
	 * 获取文件拓展名
	 * @param fileName	文件名
	 * @return
	 */
	public  String getFileType(String fileName){
		return fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
	}
}
