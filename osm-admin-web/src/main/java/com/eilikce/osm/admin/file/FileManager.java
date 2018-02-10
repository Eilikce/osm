package com.eilikce.osm.admin.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;

public class FileManager {

	private static Logger logger = Logger.getLogger(FileManager.class);

	/**
	 * 读取一个系统路径的文件
	 * 
	 * @param path
	 *            文件路径
	 * @return
	 */
	public static File importFile(String path) {
		File file = null;
		FileSystemResource fsr = new FileSystemResource(path);
		file = fsr.getFile();
		return file;
	}
	
	/**
	 * 根据全路径 判断系统文件是否存在
	 * @param file
	 * @return
	 */
	public static boolean fileIsExsit(String path){
		FileSystemResource fsr = new FileSystemResource(path);
		return fsr.exists();
	}

	/**
	 * 写文件，将输入流写入系统路径下
	 * @param inputStream
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public static boolean WriteFile(InputStream inputStream, String filePath,String fileName) {
		if (inputStream == null) {
			logger.error("写文件失败，文件输入流为空");
			return false;
		}
		if (filePath == null) {
			logger.error("写文件失败，输出文件路径流为空");
			return false;
		}
		
		String fileFullPath = filePath + File.separator + fileName;
		File file = new File(fileFullPath);
		InputStream in = inputStream;
		try {
			//判断文件是否已经存在，不存在则创建
			if(!file.exists()){
				file.createNewFile();
			}
			
			BufferedInputStream bis = new BufferedInputStream(in);
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int d = -1;
			while ((d = bis.read()) != -1) {
				bos.write(d);
			}
			bos.close();
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("写文件失败"+ filePath + File.separator + fileName);
		}
		logger.info("写文件成功。" + filePath + File.separator + fileName);
		return true;
	}
}
