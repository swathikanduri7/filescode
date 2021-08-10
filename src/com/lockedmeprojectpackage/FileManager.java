//Name of the package
package com.lockedmeprojectpackage;

//importing required files
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
	/**
	 * This method will return the file names from the folder
	 * @param folderpath
	 * @return
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		//File object is created
		File fl=new File(folderpath);
		
		//To get all the files into FileArray
		File[] listOfFiles=fl.listFiles();

		//Declaring a List to store all file names
		List<String> fileNames=new ArrayList <String>();
				
		//loop for list of files
		for(File f:listOfFiles)
			fileNames.add(f.getName());
			
			//return statement to return the list
			return fileNames;
	    }
		   /**
		    * this method will create or append content into the file specified
		    * @param folderpath
		    * @param filename
		    * @param content
		    * @return boolean
		    */
			
			public static boolean createFiles(String folderpath,String fileName, List<String> content)
			{
				try
				{
					//to create new file and write into that file
					File fl=new File(folderpath,fileName);
					FileWriter fw=new FileWriter(fl);
					//for loop to write content into file
					for(String text:content){
						fw.write(text);
					}
					    fw.close();
					
				 }
			       catch(Exception Ex)
				{
			    	   
					return false;
				}
				return true;
			}
			/**
			 * this method will delete the file from folder
			 * @param folderpath
			 * @param fileName
			 * @return
			 */
			  //method to delete the file
			public static boolean deleteFile(String folderpath,String fileName)
			{
				//file name to delete the file from folder 
				File file=new File(folderpath+"\\" +fileName);
				try
				{
					//if else to return true or false
					if(file.delete())
					   return true;
					else
					    return false;
				}
				 catch(Exception Ex)
				{
					 return false;
				}
			}
			
			   /**
			    * Method to search file from the folder
			    * @param folderpath
			    * @param fileName
			    * @return
			    */
		       public static boolean searchFile(String folderpath, String fileName)
		       {
		    	   //adding folderpath with file name and creating file object
		    	   File file = new File(folderpath+"\\" +fileName);
		    	   
		    	 //if else to return true or false
		    	   if(file.exists())
		    		   return true;
		    	   else
		    		   return false;
		    	   
		       }
		       
		       
			 
}
