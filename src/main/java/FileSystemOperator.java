/**
 *
 */
package com.comcast.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;



/**
 * @author spoigai
 * @version - 1.0 
 **
 */
public class FileSystemOperator implements FileSystemOperations {
	 
 
	 public void makeDir(String dirPath){
		 File file = new File(dirPath);
			if (!file.exists()) {
				if (file.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
		 }
	
	 public void createFile(String filePath){
		 try {
			   //create a file 
			   File myFile = new File(filePath);
			   if ( myFile.createNewFile() ) {
			      System.out.println("Success!");
			   } else {
			      System.out.println("Failure!");
			   }
			} catch ( IOException ex ) {
				ex.printStackTrace();
		 
			}
	 }
	 
	 public void addContent(String content, String filePath){
		 
			 PrintWriter out = null;
			 try {
			     out = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
			     out.println(content);
			 }catch (IOException e) {
			     System.err.println(e);
			 }finally{
			     if(out != null){
			         out.close();
			     }
			 }  
		 
	 }
	 
	 public void copyFile(String srcFilePath, String destFilePath){
		 try {
			 File source = new File(srcFilePath);
			 File dest = new File(destFilePath);
			 FileUtils.copyFile(source, dest);
			} catch ( IOException ex ) {
				ex.printStackTrace();
		 
			}
	 }
	 
	 public void printFileContent(String filePath){
		 BufferedReader br = null;
		 try {
			 	br = new BufferedReader(new FileReader(filePath));
			    for (String line; (line = br.readLine()) != null;) {
			        System.out.println(line);
			        
			        }    
			} catch ( IOException ex ) {
				ex.printStackTrace();
			} finally {
			   try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
		   }
			
	 }
	 
	 public void printDirContent(String dirPath){
		 try {
			 File f = new File(dirPath);
			 ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
			 for (File file : files) {
			        
			        if(file.isDirectory())
			         {
			        	printDirContent(file.getAbsolutePath().toString());
			         }
			         else
			         {
			        	 System.out.println(file.getName());
			         }
			 }
			        
			       
			} catch (Exception ex ) {
				ex.printStackTrace();
		 
			}
	 }
	 
	 
	 public void searchFileByName(String fileName){
		 // Search from current working dirctory
		 File root = new File(System.getProperty("user.dir"));
		 String file_Name = fileName;
	        try {
	            boolean recursive = true;

	            Collection files = FileUtils.listFiles(root, null, recursive);

	            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
	                File file = (File) iterator.next();
	                if (file.getName().equals(file_Name))
	                    System.out.println(file.getAbsolutePath());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public void searchFileByName(String fileName, String dirPath){
		 File root = new File(dirPath);
		 String file_Name = fileName;
	        try {
	            boolean recursive = true;

	            Collection files = FileUtils.listFiles(root, null, recursive);

	            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
	                File file = (File) iterator.next();
	                if (file.getName().equals(file_Name))
	                    System.out.println(file.getAbsolutePath());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
	 
	 
	 
}

