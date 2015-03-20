package com.util;

import java.util.List;

public class UtilTest {
	public static void main(String[] args) {
		String filePath = ConfigUtil.getProperties("FilePath");
		List<String> list = FileUtil.readTxtFile(filePath);
		int size = list.size();
		for(int i=0;i<size;i++){
			String item = list.get(i);
			if(item.indexOf(":") > -1){
				String[] arr = item.split(":");
				String ip = arr[0];
				String port = arr[1];
				HttpUtil.sendGetTest(ip, port);
			}
			System.out.println("===>>>" + i);
		}
	}
}
