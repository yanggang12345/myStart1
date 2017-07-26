package com.itheima.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class POITest {
	/**
	 * 文件上传
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void test() throws FileNotFoundException, IOException{
		HSSFWorkbook workbook=new HSSFWorkbook(new FileInputStream(new File("E:\\BaiduYunDownload\\html5项目\\11、第十一阶段项目：物流管理系统（12天）\\bos项目-day04\\资料\\区域导入测试数据.xls")));
		HSSFSheet sheet=workbook.getSheetAt(0);
		for (Row row : sheet) {
			/*String v1=row.getCell(0).getStringCellValue();
			String v2=row.getCell(1).getStringCellValue();
			String v3=row.getCell(2).getStringCellValue();
			String v4=row.getCell(3).getStringCellValue();
			String v5=row.getCell(4).getStringCellValue();
			System.out.println(v1+" "+v2+" "+" "+v3+" "+v4+" "+v5+" ");*/
			for (Cell cell : row) {
				String v=cell.getStringCellValue();
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}
