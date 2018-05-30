package com.frame.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtill {
	public static final String contextPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	public static final String configurationth = "config";
	public static final Object scannerPackageKey = "scannerPackage";
	
	public static List<File> getFiles(String path) throws Exception {
		List<File> fileList = new ArrayList<File>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                return null;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	getFiles(file2.getAbsolutePath());
                    } else {
                    	fileList.add(file2);
                    }
                }
            }
        } else {
            throw new Exception("找不到文件");
        }
		return fileList;
		
	}
}

