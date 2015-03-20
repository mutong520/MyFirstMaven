package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> readTxtFile(String filePath){
		List<String> list = new ArrayList<String>();
		try {
			String encoding="GBK";
			File file=new File(filePath);
			if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),encoding);//考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
					list.add(lineTxt.trim());
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<String> list = readTxtFile("D:\\Workspaces\\MyFirstMaven\\src\\main\\resources\\config\\IpPort.txt");
		int size = list.size();
		for(int i=0;i<size;i++){
			System.out.println("=="+(i+1)+">>"+list.get(i));
		}
	}
	
}
