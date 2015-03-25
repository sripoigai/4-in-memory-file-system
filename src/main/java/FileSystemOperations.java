package com.comcast.assignment;


public interface FileSystemOperations {

	public void makeDir(String dirPath);
	
	 public  void createFile(String filePath);
	 
	 public  void addContent(String content, String filePath);
	 
	 public  void copyFile(String srcFilePath, String destFilePath);
	 
	 public  void printFileContent(String filePath);
	 
	 public  void printDirContent(String dirPath);
	 
	 public  void searchFileByName(String fileName);
	 
	 public  void searchFileByName(String fileName, String dirPath);
	
}
