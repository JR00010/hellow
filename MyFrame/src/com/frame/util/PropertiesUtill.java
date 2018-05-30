package com.frame.util;

import java.io.File;
import java.io.FileReader;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;

public class PropertiesUtill {
	
	/**ªÒ»°…®√Ë¬∑æ∂
	 * @return
	 * @throws Exception
	 */
	public static String[] getScannerPath() throws Exception{
		String configurationthPackage = FileUtill.contextPath+FileUtill.configurationth;
		List<File> files = FileUtill.getFiles(configurationthPackage);
		
		StringBuilder sb = new StringBuilder();
		
		Properties p =new Properties();
		for (File file : files) {
			String fileName = file.getName();
			if (fileName.contains("properties")) {
				String filePath = configurationthPackage+"/"+file.getName();
				p.load(new FileReader(filePath));
				String packages= (String) p.get(FileUtill.scannerPackageKey);
				sb.append(packages);
			}
		
		}
		String[] packagePaths = sb.toString().split(",");
		
		for (int i = 0; i < packagePaths.length; i++) {
			packagePaths[i] = packagePaths[i].trim();
		}
		
		return packagePaths;
	}

}
