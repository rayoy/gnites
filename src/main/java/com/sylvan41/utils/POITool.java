/**
 * 
 */
package com.sylvan41.utils;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * POI工具类
 * 
 * @author asimple41@qq.com
 * 
 */
public class POITool {

	/**
	 * 导入Excel
	 * 
	 * @param is
	 *            导入的Excel的InputStream流
	 */
	public void importExcel(InputStream is) {

		try {
			HSSFWorkbook hwb = new HSSFWorkbook(is);
			HSSFSheet sheet = hwb.getSheetAt(0);
			HSSFRow row = sheet.getRow(0);
			row.getCell((short) 0).getCellFormula();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
