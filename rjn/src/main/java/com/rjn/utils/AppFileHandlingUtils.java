package com.rjn.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import com.rjn.bean.ExcelFile;

public class AppFileHandlingUtils {
	
	public static boolean uploadFileToServer(MultipartFile file, String name) throws IOException {
		
		if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());
				System.out.println("You successfully uploaded file=" + name);
				return true;
		} else {
			return false;
		}
		
	}
	
	public static List<ExcelFile> readExcelFile(MultipartFile thisFile, String fileName) throws IOException {
		String extension = getFileExtension(fileName);
		System.out.println("extension >> "+extension);
		List<ExcelFile> excelFiles = new ArrayList<ExcelFile>();
  		
		if (Constant.EXCEL_2007.equals(extension)) {
			int i = 0;
			// Creates a workbook object from the uploaded excelfile
			XSSFWorkbook workbook = new XSSFWorkbook(thisFile.getInputStream());
			// Creates a worksheet object representing the first sheet
			XSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			while (i <= worksheet.getLastRowNum()) {
				ExcelFile excelFile = new ExcelFile();
				// Creates an object for the UserInfo Model
				// Creates an object representing a single row in excel
				XSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				if (row.getCell(0) != null) {
					excelFile.setCol1(row.getCell(0).getStringCellValue());
				}
				
				if (row.getCell(1) != null) {
					excelFile.setCol2(row.getCell(1).getStringCellValue());
				}
				
				if (row.getCell(2) != null) {
					excelFile.setCol3(row.getCell(2).getStringCellValue());
				}
				
				if (row.getCell(3) != null) {
					excelFile.setCol4(row.getCell(3).getStringCellValue());
				}
				
				if (row.getCell(4) != null) {
					excelFile.setCol5(row.getCell(4).getStringCellValue());	
				}
				
				if (row.getCell(5) != null) {
					excelFile.setCol6(row.getCell(5).getStringCellValue());
				}
				
				if (row.getCell(6) != null) {
					excelFile.setCol7(row.getCell(6).getStringCellValue());
				}
				
				if (row.getCell(7) != null) {
					excelFile.setCol8(row.getCell(7).getStringCellValue());
				}
				excelFiles.add(excelFile);
			}			
			workbook.close();
		} else if (extension.equals(Constant.EXCEL_2003) ) {
			HSSFWorkbook workbook = new HSSFWorkbook(thisFile.getInputStream());
			HSSFSheet sheet = workbook.getSheetAt(0);
			int i = 0;
			while (i <= sheet.getLastRowNum()) {
				ExcelFile excelFile = new ExcelFile();
				HSSFRow row = sheet.getRow(i++);
				if (row.getCell((short)0) != null) {
					excelFile.setCol1(row.getCell((short)0).getStringCellValue());
				}
				if (row.getCell((short)1) != null) {
					excelFile.setCol2(row.getCell((short)1).getStringCellValue());
				}
				
				if (row.getCell((short)2) != null) {
					excelFile.setCol3(row.getCell((short)2).getStringCellValue());
				}
				
				if (row.getCell((short)3) != null) {
					excelFile.setCol4(row.getCell((short)3).getStringCellValue());
				}
				
				if (row.getCell((short)4) != null) {
					excelFile.setCol5(row.getCell((short)4).getStringCellValue());	
				}
				
				if (row.getCell((short)5) != null) {
					excelFile.setCol6(row.getCell((short)5).getStringCellValue());
				}
				
				if (row.getCell((short)6) != null) {
					excelFile.setCol7(row.getCell((short)6).getStringCellValue());
				}
				
				if (row.getCell((short)7) != null) {
					excelFile.setCol8(row.getCell((short)7).getStringCellValue());
				}
				excelFiles.add(excelFile);
			}
		}
		return excelFiles;
	}
	
	private static String getFileExtension(String fileName){
		int index = fileName.indexOf(".");
		return fileName.substring(index, fileName.length());
	}
}