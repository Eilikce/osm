package com.eilikce.osm.poi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class PoiUtil {

	private static Logger logger = Logger.getLogger(PoiUtil.class);

	/**
	 * 读取xlsx文件
	 * 返回List嵌套List<String>
	 * @param mfile
	 * @return	返回文件数据对象
	 */
	public static List<ArrayList<String>> importXlsToListList(MultipartFile mfile,boolean hasTitle) {
		List<ArrayList<String>> objectList = new ArrayList<ArrayList<String>>();
		
		InputStream is = null;
		XSSFWorkbook xWorkbook = null;
		try {
			is = mfile.getInputStream();
			xWorkbook = new XSSFWorkbook(is);
			XSSFSheet xSheet = xWorkbook.getSheetAt(0);
			
			if (null != xSheet) {
				//通过hasTitle判断是否存储第一行（标题行）
				for (int i = hasTitle ? 0 : 1; i < xSheet.getPhysicalNumberOfRows(); i++) {
					XSSFRow hRow = xSheet.getRow(i);
					ArrayList<String> cellList = new ArrayList<String>();
					for(int j=0;j<hRow.getPhysicalNumberOfCells();j++){
						String cell = hRow.getCell(j).getStringCellValue();
						cellList.add(cell);
					}
					
					objectList.add(cellList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (null != xWorkbook) {
				try {
					xWorkbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return objectList;
	}
	
	
	/**
	 * 读取xlsx文件
	 * 返回List嵌套Map<String,String>
	 * 自动识别数字或字符型单元格
	 * @param mfile
	 * @return	返回文件数据对象
	 */
	public static List<Map<String,String>> importXlsToListMapStringType(MultipartFile mfile) {
		List<Map<String,String>> objectList = new ArrayList<Map<String,String>>();
		
		InputStream is = null;
		XSSFWorkbook xWorkbook = null;
		try {
			is = mfile.getInputStream();
			xWorkbook = new XSSFWorkbook(is);
			XSSFSheet xSheet = xWorkbook.getSheetAt(0);
			if (null != xSheet) {
				List<String> titleList = new ArrayList<String>();
				int colNumber = 0;//获取标题和的列数目
				for (int i = 0; i < xSheet.getPhysicalNumberOfRows(); i++) {
					XSSFRow hRow = xSheet.getRow(i);
					if(i==0){
						colNumber = hRow.getPhysicalNumberOfCells();
					}
					Map<String,String> cellMap = new HashMap<String,String>();
					for(int j=0;j<colNumber;j++){
						if (i == 0) {
							//标题和字符串提取
							String cell = hRow.getCell(j).getStringCellValue();
							titleList.add(cell);
						}else{
							//非标题行
							
							if(null == hRow.getCell(j)){
								//如果为null则直接视为空字符串
								cellMap.put(titleList.get(j), "");
								continue;
							}
							
							CellType type = hRow.getCell(j).getCellTypeEnum();
							//TODO 通过类型插入单元格值
							switch (type) {
							case  _NONE :
								cellMap.put(titleList.get(j), "");
								break;  
							case  STRING :
								cellMap.put(titleList.get(j), hRow.getCell(j).getStringCellValue().trim());
								break;  
							case  NUMERIC :  
								cellMap.put(titleList.get(j), (hRow.getCell(j).getNumericCellValue()+"").trim());
								break;  
							default:  
								cellMap.put(titleList.get(j), "");
							}  
						}
					}
					
					if(i!=0){//标题行不存储
						objectList.add(cellMap);
					}
				}
			}
		} catch (Exception e) {
			logger.error("XLSX文件读取失败",e);
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (null != xWorkbook) {
				try {
					xWorkbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return objectList;
	}
	/**
	 * 读取xlsx文件，获取行数（包括标题行）
	 * @param mfile
	 * @return	返回xlsx文件行数（包括标题行）
	 */
	public static int importXlsCount(MultipartFile mfile) {
		int count = 0 ;
		InputStream is = null;
		XSSFWorkbook xWorkbook = null;
		try {
			is = mfile.getInputStream();
			xWorkbook = new XSSFWorkbook(is);
			XSSFSheet xSheet = xWorkbook.getSheetAt(0);
			if (null != xSheet) {
				count = xSheet.getPhysicalNumberOfRows();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (null != xWorkbook) {
				try {
					xWorkbook.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return count;
	}
}
