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
import java.util.List;

import org.apache.commons.io.FileUtils;



/**
 * @author spoigai
 * @version - 1.0 
 **
 */
public class FileSystemCleanUp{
	 
 
	 public void removeDir(String dirPath){
		 File file = new File(dirPath);
			if (file.exists()) {
				if (file.delete()) {
					System.out.println("Folder clean up successfull");
				} else {
					System.out.println("Failed to clean up folder successfully!");
				}
			}
		 }
	
	 public void removeFile(String filePath){
		 try {
			   //create a file 
			   File myFile = new File(filePath);
			   if ( myFile.delete() ) {
			      System.out.println("Files clean up successfull");
			   } else {
			      System.out.println("Failed to clean up files successfully!");
			   }
			} catch ( Exception ex ) {
				ex.printStackTrace();
		 
			}
	 }
	 
	 public List<String> processFileContents(String filePath){
		 BufferedReader br = null;
		 List<String> contents = new ArrayList<String> ();
		 try {
			 	br = new BufferedReader(new FileReader(filePath));
			    for (String line; (line = br.readLine()) != null;) {
			        contents.add(line);
			        
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
		return contents;
			
	 }
	 
	 public void removeFile(String [] file){
		 
		 if (file.length == 2)
			 removeFileByName(file[1]);
	     else if (file.length == 3)
	    	 removeFileByName(file[2] + "/" + file[1]);
	    	 
		
	 }
	 
	 public void removeFileByName(String fileName){
		 // Search from current working dirctory
		 File root = new File(System.getProperty("user.dir"));
		 String file_Name = fileName;
	        try {
	            boolean recursive = true;

	            Collection files = FileUtils.listFiles(root, null, recursive);

	            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
	                File file = (File) iterator.next();
	                if (file.getName().equals(file_Name))
	                   file.delete();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 
}

