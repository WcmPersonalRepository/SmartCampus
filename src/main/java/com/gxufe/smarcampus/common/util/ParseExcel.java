package com.gxufe.smarcampus.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//解析excel
public class ParseExcel {
	 //新方法（使用中）---------------------------------------------------------------------------------------------
	 public static List<String[]> rosolveFile(InputStream is, String suffix,
				int startRow) throws IOException, FileNotFoundException {
		 //判断文件格式是93版的还是2000版的
			Workbook xssfWorkbook = null;
			if ("xls".equals(suffix)) {
				xssfWorkbook = new HSSFWorkbook(is);
			} else if ("xlsx".equals(suffix)) {
				xssfWorkbook = new XSSFWorkbook(is);
			}
			Sheet xssfSheet = xssfWorkbook.getSheetAt(0);
			if (xssfSheet == null) {
				return null;
			}
			ArrayList<String[]> list = new ArrayList<String[]>();
			//获取工作表中最后一行的行数
			int lastRowNum = xssfSheet.getLastRowNum();
			//解析从开始行到最后一行的数据
			for (int rowNum = startRow; rowNum <= lastRowNum; rowNum++) {
				//当前行数据不为空
				if (xssfSheet.getRow(rowNum) != null) {
					//获取当前行的数据
					Row xssfRow = xssfSheet.getRow(rowNum);
					//获取当前行第一个单元格的数字
					short firstCellNum = xssfRow.getFirstCellNum();
					//获取当前行最后一个单元格的数字
					short lastCellNum = xssfRow.getLastCellNum();
					//如果第一个单元格不是最后一个单元格
					if (firstCellNum != lastCellNum) {
						String[] values = new String[lastCellNum];
						//遍历当前行每个单元格的数据，并添加到字符串数组values中
						for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
							//获取当前单元格的数据
							Cell xssfCell = xssfRow.getCell(cellNum);
							if (xssfCell == null) {
								values[cellNum] = "";
							} else {
								//开始解析，并返回结果
								values[cellNum] = parseExcel(xssfCell);
							}
						}
						list.add(values);
					}
				}
			}
			return list;
		}
		
		//解析单元格的数据
		private static String parseExcel(Cell cell) {
			String result = new String();
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:// 数字类型
				if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
					SimpleDateFormat sdf = null;
					if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
							.getBuiltinFormat("h:mm")) {
						sdf = new SimpleDateFormat("HH:mm");
					} else {// 日期
						sdf = new SimpleDateFormat("yyyy-MM-dd");
					}
					Date date = cell.getDateCellValue();
					result = sdf.format(date);
				} else if (cell.getCellStyle().getDataFormat() == 58) {
					// 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					double value = cell.getNumericCellValue();
					Date date = org.apache.poi.ss.usermodel.DateUtil
							.getJavaDate(value);
					result = sdf.format(date);
				} else {
					double value = cell.getNumericCellValue();
					CellStyle style = cell.getCellStyle();
					DecimalFormat format = new DecimalFormat();
					String temp = style.getDataFormatString();
					// 单元格设置成常规
					if (temp.equals("General")) {
						format.applyPattern("#");
					}
					result = format.format(value);
				}
				break;
			case HSSFCell.CELL_TYPE_STRING:// String类型
				result = cell.getRichStringCellValue().toString();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				result = "";
			default:
				result = "";
				break;
			}
			return result;
		}
	 //---------------------------------------------------------------------------------------------
	/* public List<Checkcar> createCheckCar(String fileName,String suffix) throws Exception, IOException{
		 
		 List<Checkcar> car = new ArrayList<Checkcar>();
		 List<String[]> list = this.rosolveFile(new FileInputStream(fileName), "xls", 1);
			for(int i=0;i<list.size();i++){
				String[] arr = list.get(i);
				Checkcar c  = new Checkcar();
				 c.setCarnumber(arr[0].trim());
				 c.setCarstyle(arr[1].trim());
				 c.setUsername(arr[2].trim());
				 c.setPhonenum(arr[3].trim());
				 c.setTelnum(arr[4].trim());
				 c.setCaryearcheck(Tools.formatString(arr[5].trim(), "yyyy-MM-dd"));
				 c.setTowlevel(Tools.formatString(arr[6].trim(),  "yyyy-MM-dd"));
				 c.setTechnologylevel(Tools.formatString(arr[7].trim(), "yyyy-MM-dd"));
				 c.setCompulsoryinsurance(Tools.formatString(arr[8].trim(), "yyyy-MM-dd"));
				
				 car.add(c);
			}
		return car; 
	 }*/
	 //自己可以随便找个xls文件测试一下
	/* public static void main(String[] args) throws Exception, Exception {
		ParseExcel p = new ParseExcel();
		List<Checkcar> c = p.createCheckCar("d:\\测试文件.xls");
		List<Checkcar> c1 = p.createCheckCar("d:\\测试文件.xls");
		Set<Checkcar> set = new HashSet<Checkcar>();
		set.addAll(c);
		for(Checkcar setc:set){
			for(Checkcar listc:c1){
				if(!setc.getCarnumber().equals(listc.getCarnumber())){
					System.out.println(listc.getCarnumber());
					break;
				}
			}
		}
		for(Checkcar car :c){
			System.out.println(car.getCarnumber());
		}
	}*/
}
