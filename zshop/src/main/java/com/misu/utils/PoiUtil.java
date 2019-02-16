package com.misu.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.misu.bean.Customer;
import com.misu.bean.ProductType;

/**
 *
 * @author LiuXu
 * @version 2018年10月6日下午7:13:17
 */
public class PoiUtil {

	public static void getSheet(String[] header, List<ProductType> obj, String iniPath) throws IOException {
		HSSFWorkbook work = new HSSFWorkbook();
		HSSFSheet sheet = work.createSheet("task");
		for (int i = 0; i < obj.size()+1; i++) {
			// 创建行
			HSSFRow row = sheet.createRow(i);
			for (int j = 0; j < header.length; j++) {
				// 创建列
				HSSFCell cell = row.createCell(j);
				if (i == 0) {
					cell.setCellValue(header[j]);
				} else {
					switch (j) {
					case 0:
						cell.setCellValue(obj.get(i - 1).getId());
						break;
					case 1:
						cell.setCellValue(obj.get(i - 1).getName());
						break;
					case 2:
						cell.setCellValue(obj.get(i - 1).getStatus());
						break;
					default:
						break;
					}

				}
			}
		}

		// 创建一个file
		String path = iniPath;
		// 获取输出流对象
		FileOutputStream out = new FileOutputStream(path);
		// 写入文件
		work.write(out);
		out.close();
	}

}
