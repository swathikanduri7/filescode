package com.lockedmeprojectpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyLockers_LockedMe_Class 
{
	//copied the Text Document Folder Path that is in D:Drive
    static final String folderpath="D:\\PhaseICompanyLockersProject\\LockedMeTextDocumentFiles";
	private static Scanner in;
	public static void main(String[] args) 
	{
		//variable declaration
		in = new Scanner(System.in);
		int ch;
				
	int proceed= 1;
	do{
		
		//display menu
		displayMenu();		
		ch=in.nextInt();
		
		switch(ch)
		{
		    case 1: readFilefromFolder();
		               break;
		    case 2: writeContentToNewFileName();
		    		   break;
		    case 3: searchFileNameInFolder();
		    	       break;
		    case 4: deleteFileFromFolder();
		               break;
		    case 5: 
		       System.exit(0);
		       break;
		    default:  
		    	System.out.println("Invlid choice");
		    	break;
		}
		
	}while(proceed>0);
	
	in.close();	
		
	}
		
		public static void displayMenu()
		{
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("\t\tCOMPANY LOCKERS PVT.LTD ");
		System.out.println("\t\t     LOCKED ME.COM");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	    System.out.println("1. Display all files");
	    System.out.println("2. Add New File");
	    System.out.println("3. Delete a file");
	    System.out.println("4. Search a file");
	    System.out.println("5. Exit");
	    System.out.println("Enter your choice:");
	
		}
		
	
	/**
	 * searchFileNameInFolder()
	 */
	private static void searchFileNameInFolder() {
		String fileName=null;
		in = new Scanner(System.in);
		
			System.out.println("Enter File name to search ::");
			fileName = in.nextLine();
			List<String> fileNames=FileManager.getAllFiles(folderpath);
			 fileNames=FileManager.getAllFiles(folderpath);
			
			 if(fileNames.contains(fileName))
					System.out.println("File exists in folder");
					else
					System.out.println("File does not exists in folder");
					
		
	}
	
	
	private static void readFilefromFolder() {
		//To get the files from folderPath
				List<String> fileNames=FileManager.getAllFiles(folderpath);
				
				//loop for list of files
		        for(String f:fileNames)
		        {
		        	System.out.println(" file name :: " +f);		
				}
		
	}
	
	private static void writeContentToNewFileName() {
		List<String> content = new ArrayList<>();
		String fileName=null;
	
		
		/**
		 * this method will read input from the user
		 * @param folderpath
		 * @param fileName
		 * @param return
		 */
		//scanner object to read input from the user
		Scanner in = new Scanner(System.in);
		System.out.println("enter file name :: ");
		//read string as filename
		fileName=in.nextLine();
				
		
		System.out.println("enter content to write in to file :: ");
		//read string as content and append to list
		content.add(in.nextLine());
		
		FileManager.createFiles(folderpath, fileName, content);
		//in.close();
	
		
	}
	
	//code for deleting a file
			/**
			 * this method will delete the file name if it exists 
			 * @param folderpath
			 * @param fileName
			 * @return
			 * 
			 */
	private static void deleteFileFromFolder() {
		String fileName=null;
		Scanner in = new Scanner(System.in);
		
		////scanner object to read input from the user
	
		System.out.println("Enter the file name to be deleted:");
		fileName=in.nextLine();
		
		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
		
		if(isDeleted)
			System.out.println("File deleted successfully");
			else
			System.out.println("either file not there or some access issue");
			
		//in.close();
		
	}
	
		
}
