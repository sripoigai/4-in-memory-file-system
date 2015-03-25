package com.comcast.assignment;

import java.io.File;
import java.util.List;
import java.util.StringTokenizer;

public class FileOperationsExecute {

	private static final String FILE_PATH = "user.dir" + "/" + "temp.txt";
	
	public void main(String[] args) {
		tearDown (args);
		parseArgs(args);
	}
	
	// Lot of redundant code - needs to be refactored!
	public void tearDown (String[] args){
		
		FileSystemOperations operations = null;
		String s1 = null;
		File tempFileInMemory = new File(FILE_PATH);
        if (!tempFileInMemory.exists()){
        	operations = new FileSystemOperator ();
    		operations.createFile(System.getProperty(FILE_PATH));
    		// Write args to external file
    		for (String arg : args){
    		  s1 += arg + " "; 
    		}
    		operations.addContent(s1, FILE_PATH);
    		
        } else {
		
		FileSystemCleanUp cleanUp = new FileSystemCleanUp();
		List <String> contents = cleanUp.processFileContents(FILE_PATH);
		
		for (String s : contents){
			String [] res = s.split(" ");
			if (s.contains("mkdir")){
				cleanUp.removeDir(res[1]);
			}else if (s.contains("create") ){
				cleanUp.removeFile(res[1]);
			}else if (s.contains("cp") ){
				cleanUp.removeFile(res[1]);
				cleanUp.removeFile(res[1]);		
			}else if (s.equals("find") ){
				cleanUp.removeFile (res);
			}
		}
		cleanUp.removeFile(FILE_PATH);
		operations.createFile(System.getProperty(FILE_PATH));
		for (String arg : args){
  		  s1 += arg + " "; 
  		}
  		operations.addContent(s1, FILE_PATH);
        }

	}
	
	public  int parseArgs (String[] args){
	
		if (args.length <= 0 || !args[0].equals("mkdir") || 
				!args[0].equals("create") ||
				!args[0].equals("write") || 
				!args[0].equals("write") ||
				!args[0].equals("cat") ||
				!args[0].equals("cp") ||
				!args[0].equals("ls") 
				) {
			System.out.println("invalid command line arguments");
			return -1;
		}
		
		for (String s : args){
			
			if (s.equals("mkdir"))
				runCommandMakeDir (args);
			else if (s.equals("create") )
				runCommandCreateFile (args);
			else if (s.equals("write") )
				runCommandWrite (args);
			else if (s.equals("cat") )
				runCommandDisplayContents (args);
			else if (s.equals("cp") )
				runCommandCopyFile (args);
			else if (s.equals("find") )
				runCommandFindFile (args);
			else if (s.equals("ls") )
				runCommandPrintDirContents (args);
			
		}
		return 0;
		
	}
	
	public void runCommandMakeDir (String[] args){
		FileSystemOperations operations = new FileSystemOperator ();
		if (args.length == 2)
			operations.makeDir(args[1]);
		else
			System.out.println("invalid command line arguments");
	}
	
	public void runCommandCreateFile (String[] args){
		FileSystemOperations operations = new FileSystemOperator ();
		if (args.length == 2)
			operations.createFile(args[1]);
		else
			System.out.println("invalid command line arguments");
			
	}
	
	public void runCommandWrite (String[] args){
		FileSystemOperations operations = new FileSystemOperator ();
		if (args.length == 3)
			operations.addContent(args[1], args[2]);
		else
			System.out.println("invalid command line arguments");
			
	}
	
	public void runCommandDisplayContents (String[] args){
		FileSystemOperations operations = new FileSystemOperator ();
		if (args.length == 2)
			operations.printFileContent(args[1]);
		else
			System.out.println("invalid command line arguments");
			
	}
	
	public void runCommandCopyFile (String[] args){
		FileSystemOperations operations = new FileSystemOperator ();
		if (args.length == 3)
			operations.copyFile(args[1], args[2]);
		else
			System.out.println("invalid command line arguments");
			
	}
	
	public void runCommandFindFile (String[] args){
		FileSystemOperations operations = new FileSystemOperator ();
		if (args.length == 3)
			operations.searchFileByName(args[1], args[2]);
		else if (args.length == 2)
				operations.searchFileByName(args[1]);
		else 	
			System.out.println("invalid command line arguments");
			
	}
	
	public void runCommandPrintDirContents (String[] args){
		FileSystemOperations operations = new FileSystemOperator ();
		if (args.length == 2)
			operations.printDirContent(args[1]);
		else
			System.out.println("invalid command line arguments");
			
	}
	
}
