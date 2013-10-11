/**
 * 
 */
package com.sylvan41.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel导入导出工具(Jexl,POI组件)
 * 
 * @author asimple41@qq.com
 * 
 */
public class JxlsUtil {

	/**
	 * JXLS导出Excel
	 * 
	 * @param templateFilePath
	 *            模板文件位置本地
	 * @param beans
	 *            数据源
	 * @param os
	 *            流
	 * @return
	 */
	public static InputStream export(String templateFilePath, Map<String,Object> beans,
			ByteArrayOutputStream os) {

		File templateFile = null;
		XLSTransformer transformer = new XLSTransformer();

		try {
			// 得到模板文件
			templateFile = new File(templateFilePath);

			// 将模板文件转化成stream流
			InputStream xlsTemplateIO = new FileInputStream(templateFile);

			// 依据模板格式化数据源道道HSSFWorkbook对象(POI)
			HSSFWorkbook hsf = transformer.transformXLS(xlsTemplateIO, beans);

			// 写入输出流
			hsf.write(os);
		} catch (ParsePropertyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(os.toByteArray());
	}

	/**
	 * JXLS导出Excel
	 * 
	 * @param templateFilePath
	 *            模板文件路径
	 * @param beans
	 *            导出excel的数据源
	 * @param destFilePath
	 *            导出excel文件的路径
	 */
	public static void export(String templateFilePath, Map<String,Object> beans,
			String destFilePath) {

		XLSTransformer transformer = new XLSTransformer();
		try {
			transformer.transformXLS(templateFilePath, beans, destFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
