package com.rcdvl.imageresizer;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

	private static List<String> allowedExtensions = Arrays.asList("png", "jpg", "jpeg");

	private static FileFilter imageFilesFilter = new FileFilter() {
		
		@Override
		public boolean accept(File pathname) {
			String fileName = pathname.getName();
			String extension = getFileExtension(fileName);
			return allowedExtensions.contains(extension) ? true : false;
		}		
	};
	
	private FileUtils() {}
	
	public static File[] getImagesWithinDir(String path) {
		File dir = new File(path);
		return dir.listFiles(imageFilesFilter);
	}
	
	public static String getFileExtension(String fileName) {
		String extension = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    extension = fileName.substring(i+1);
		}
		return extension;
	}
}
