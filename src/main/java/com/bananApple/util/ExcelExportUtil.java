package com.bananApple.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 */

public class ExcelExportUtil {

	// 存放生成的Excel路径
	public static String TEMP_DOWN_EXCEL_PATH = "downExcel";

	// 存放模板Excel路径
	public static String MODULE_DOWN_EXCEL_PATH = "module";

	/*
	 * 设置单元格样式
	 */
	public static HSSFCellStyle getCellStyle(HSSFWorkbook wb) {
		// 设置边框
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		// 单元格字体
		HSSFFont f = wb.createFont();
		f.setFontHeightInPoints((short) 11);// 字号
		// f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//加粗
		style.setFont(f);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		// style.setRotation(short rotation);//单元格内容的旋转的角度

		// 设置自动换行
		style.setWrapText(true);
		return style;

	}

	/**
	 * 设置MODF单元格格式
	 * 
	 * @param wb
	 * @return
	 */
	public static HSSFCellStyle getPortCellStyle(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();

		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		// 单元格字体
		HSSFFont f = wb.createFont();
		f.setFontHeightInPoints((short) 10);// 字号
		// f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//加粗
		style.setFont(f);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);// 上下居中
		// style.setRotation(short rotation);//单元格内容的旋转的角度

		// 设置自动换行
		style.setWrapText(true);

		return style;
	}

	/**
	 * 设置MODF单元格格式
	 * 
	 * @param wb
	 * @return
	 */
	public static HSSFCellStyle getModfCellStyle(HSSFWorkbook wb) {
		HSSFCellStyle style = wb.createCellStyle();

		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		// 单元格字体
		HSSFFont f = wb.createFont();
		f.setFontHeightInPoints((short) 10);// 字号
		// f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//加粗
		style.setFont(f);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		// style.setRotation(short rotation);//单元格内容的旋转的角度

		// 设置自动换行
		style.setWrapText(false);

		return style;
	}

	/*
	 * 设置局站单元格样式
	 */
	public static HSSFCellStyle getGroomCellStyle(HSSFWorkbook wb) {
		// 设置边框
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		// 单元格字体
		HSSFFont f = wb.createFont();
		f.setFontHeightInPoints((short) 9);// 字号
		// f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//加粗
		style.setFont(f);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		// style.setRotation(short rotation);//单元格内容的旋转的角度

		// 设置自动换行
		style.setWrapText(false);
		return style;

	}

	/**
	 * 设置表头样式
	 * 
	 * @param wb
	 * @return
	 */
	public static HSSFCellStyle getGroomHeaderStyle(HSSFWorkbook wb) {

		// 设置边框
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		// 单元格字体
		HSSFFont f = wb.createFont();
		f.setFontHeightInPoints((short) 10);// 字号
		f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);// 加粗
		style.setFont(f);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		// style.setRotation(short rotation);//单元格内容的旋转的角度

		// 设置背景和字体颜色

		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// 设置自动换行
		// style.setWrapText(true);
		return style;
	}

	/**
	 * 设置表头样式
	 * 
	 * @param wb
	 * @return
	 */
	public static HSSFCellStyle greenStyle(HSSFWorkbook wb) {

		// 设置边框
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		// 单元格字体
		HSSFFont f = wb.createFont();
		f.setFontHeightInPoints((short) 10);// 字号
		f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);// 加粗
		style.setFont(f);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		// style.setRotation(short rotation);//单元格内容的旋转的角度

		// 设置背景和字体颜色

		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// 设置自动换行
		// style.setWrapText(true);
		return style;
	}

	/**
	 * 设置表头样式
	 * 
	 * @param wb
	 * @return
	 */
	public static HSSFCellStyle redStyle(HSSFWorkbook wb) {

		// 设置边框
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		// 单元格字体
		HSSFFont f = wb.createFont();
		f.setFontHeightInPoints((short) 10);// 字号
		f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);// 加粗
		style.setFont(f);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		// style.setRotation(short rotation);//单元格内容的旋转的角度

		// 设置背景和字体颜色

		style.setFillForegroundColor(HSSFColor.RED.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// 设置自动换行
		// style.setWrapText(true);
		return style;
	}

	/**
	 * 设置表头样式
	 * 
	 * @param wb
	 * @return
	 */
	public static HSSFCellStyle getHeaderStyle(HSSFWorkbook wb) {

		// 设置边框
		HSSFCellStyle style = wb.createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框

		// 单元格字体
		HSSFFont f = wb.createFont();
		f.setFontHeightInPoints((short) 14);// 字号
		f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);// 加粗
		style.setFont(f);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		// style.setRotation(short rotation);//单元格内容的旋转的角度

		// 设置背景和字体颜色

		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// 设置自动换行
		style.setWrapText(true);
		return style;
	}

	/**
	 * 合并单元格
	 */

	public static void mergedRgion(int rowstart, int rowend, int columnstart,
			int columnend, HSSFSheet sheet) {
		// Region region = new Region(rowstart,columnstart,rowend
		// ,columnend);//合并从第rowFrom行columnFrom列
		// sheet.addMergedRegion(region);// 到rowTo行columnTo的区域
		// //得到所有区域
		// 从firstRow到lastRow；firstCol到lastCol的区域
		CellRangeAddress region = new CellRangeAddress(rowstart, rowend,
				columnstart, columnend);
		sheet.addMergedRegion(region);
	}

	// 解决中文乱码
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();

	}

	/**
	 * 创建Excel单元格
	 * 
	 * @param row
	 *            Excel行
	 * @param column
	 *            第几列
	 * @param style
	 *            单元格样式
	 * @param value
	 *            单元格内容
	 */
	public static void createCell(HSSFRow row, int column, HSSFCellStyle style,
			String value) {
		HSSFCell cell = row.createCell(column);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(style);
		if (value == null || "null".equals(value)) {
			value = "";
			cell.setCellValue(value);
		}else{
			boolean isNum = value.toString().matches("^(-?\\d+)(\\.\\d+)?$");//判断是否是数值
			if(isNum){
				cell.setCellValue(Double.parseDouble(value));
			}else{
				cell.setCellValue(value);
			}
		}
	}

	/**
	 * 下载Excel文件
	 * 
	 * @param response
	 * @param filePath
	 *            路径
	 */
	public static void downLoadExcel(HttpServletRequest request,
			HttpServletResponse response, String filePath, String exportFileName) {
		String datetimeStr = DateTimeUtil.formatDateToString(new Date(),
				"yyyyMMddHHmmss");

		File file = new File(filePath);
		// 取得文件名。
		String fileName = exportFileName + "_" + datetimeStr + file.getName();
		// 取得文件的后缀名。
		// String ext = filename.substring(filename.lastIndexOf(".") +
		// 1).toUpperCase();

		// 以流的形式下载文件。
		InputStream fis = null;
		OutputStream fos = null;
		try {
			response.reset();
			// 设置response的Header
			response.setHeader("Content-Disposition", "attachment;filename="
					+ toUtf8String(fileName));
			response.setHeader("Content-Length", "" + file.length());
			response.setContentType("application/octet-stream");

			// codes..
			String userAgent = request.getHeader("User-Agent");
			byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes()
					: fileName.getBytes("UTF-8"); // name.getBytes("UTF-8")处理safari的乱码问题
			fileName = new String(bytes, "ISO-8859-1"); // 各浏览器基本都支持ISO编码
			response.setHeader("Content-disposition",
					String.format("attachment; filename=\"%s\"", fileName)); // 文件名外的双引号处理firefox的空格截断问题
			// codes..

			fis = new BufferedInputStream(new FileInputStream(filePath));

			fos = new BufferedOutputStream(response.getOutputStream());

			byte[] buffer = new byte[1024];

			int read = -1;
			while (-1 != (read = fis.read(buffer, 0, buffer.length))) {
				fos.write(buffer, 0, read);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 删除文件
			file.delete();
		}
	}

	/**
	 * 下载Excel模板文件，删除临时文件
	 * 
	 * @param response
	 * @param filePath
	 *            路径
	 */
	public static void downLoadExcelModule(HttpServletRequest request,
			HttpServletResponse response, String filePath) {

		File file = new File(filePath);
		// 取得文件名。
		String fileName = file.getName();
		// 取得文件的后缀名。
		// String ext = filename.substring(filename.lastIndexOf(".") +
		// 1).toUpperCase();

		// 以流的形式下载文件。
		InputStream fis = null;
		OutputStream fos = null;
		try {
			response.reset();
			// 设置response的Header
			response.setHeader("Content-Disposition", "attachment;filename="
					+ toUtf8String(fileName));
			response.setHeader("Content-Length", "" + file.length());
			response.setContentType("application/octet-stream");

			// codes..
			String userAgent = request.getHeader("User-Agent");
			byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes()
					: fileName.getBytes("UTF-8"); // name.getBytes("UTF-8")处理safari的乱码问题
			fileName = new String(bytes, "ISO-8859-1"); // 各浏览器基本都支持ISO编码
			response.setHeader("Content-disposition",
					String.format("attachment; filename=\"%s\"", fileName)); // 文件名外的双引号处理firefox的空格截断问题
			// codes..

			fis = new BufferedInputStream(new FileInputStream(filePath));

			fos = new BufferedOutputStream(response.getOutputStream());

			byte[] buffer = new byte[1024];

			int read = -1;
			while (-1 != (read = fis.read(buffer, 0, buffer.length))) {
				fos.write(buffer, 0, read);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 生成Excel头部
	 */
	public static void creatHeaderRow(HSSFSheet sheet, HSSFCellStyle style,String[] title,int[] len)
	{
		// 工作表的第0行，表头部分
		HSSFRow row = sheet.createRow(0);

		// 设置列宽度，第一个参数代表列id(从0开始),第2个参数代表宽度值 参考 ："2012-08-10"的宽度为2500
		for(int i=0,length=len.length;i<length;i++){
			sheet.setColumnWidth(i, len[i]);
		}
		// 设置行高
		row.setHeight((short) 500);
		
        for(int i=0,length=title.length;i<length;i++){
        	ExcelExportUtil.createCell(row, i, style, title[i]);
        }
	}
	/**
	 * 将数据插入到Excel
	 * 
	 * @param sheet
	 * @param style
	 * @param list 数据稽核
	 * @param key  数据集key
	 * */
	public static void insertValueRow(HSSFSheet sheet, HSSFCellStyle style,List<Map<String, Object>> list,String[] key){
		HSSFRow row = null;
		for(int i=0,len=list.size();i<len;i++){//遍历list
			row = sheet.createRow(i + 1);
			for(int j=0,size=key.length;j<size;j++){//根据数据集key 循环插入数据
				ExcelExportUtil.createCell(row, j, style,String.valueOf(list.get(i).get(key[j])));
			}
		}
	}
	
}
