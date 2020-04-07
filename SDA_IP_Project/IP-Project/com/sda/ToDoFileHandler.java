package com.sda;

/***
 * TodoFileHandler class Reads/Write the Task Information from the .txt file. 
 * It Adds new TODO Task details to Arraylist,which store in ToDoList.txt.
 *  WE can also Edit ,Update and Delete the existing Task details.
 *  Also Write back the details back to text file
 */

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.io.File;

public class ToDoFileHandler 
{
	private ArrayList<Task> input = new ArrayList<>();
	  private int statusOpen = 0,statusClosed = 0;
	
	  String filename = null;
	  
	  DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	  /** Display the To do list data from ArrayList
	   * 
	   */
	  
	 public void displayInput()
	{
	  int counter = 0;
	  int choice;
	 
	  System.out.println("\n Display the ToDO List based on Sorting");
	  System.out.println("\n Please Enter your choice - for sorting");
	  System.out.println("1.Sort based on Date");
	  System.out.println("2.Sort based on Project");
	  
	  choice = scanInput();
	  
	  if (choice == 1)
	  {
		  input.sort((Task d1,Task d2)->d1.getTaskDate().compareTo(d2.getTaskDate()));
	  }
	  else if (choice == 2)
	  {
		  input.sort((Task d1,Task d2)->d1.getProjectName().compareTo(d2.getProjectName()));
	  }
	  String format1 = "%-12s %-30s %-30s %-15s %-15s";
	  System.out.println(String.format(format1,"Task No","Task Name","ProjectName" , "Status", " Date"));
	  System.out.println("-----------------------------------------------------------------------------------------------------------");
	  
	  
	  
	  for(Task file : input)
		{
	    counter = counter + 1;
	    
		 System.out.println(String.format(format1,counter,file.getTaskName(),file.getProjectName(),file.getSatus(),formatter.format(file.getTaskDate())));
		 String changeCase = file.getSatus().toUpperCase();
		 if (changeCase.equals("OPEN"))
		 	{
			 statusOpen = statusOpen + 1;
		 	}
		 else if(changeCase.equals("CLOSED"))
		 	{
			 statusClosed = statusClosed + 1;
		 	}
		}
	  	System.out.println("Number of Tasks open : "+statusOpen+" Number of Tasks Closed " + statusClosed);
	  	 statusOpen = 0;
	  	statusClosed = 0;
	  	 
	}
	 /*
	  * Read the input Text file and Store the details into the ToDolist of Task
	  * And display the Task information/Record into the Console Panel
	  */

	public void inputReader() throws IOException
	{
	    Date date = null;
	    JFileChooser chooser = new JFileChooser();
	    File file = null;
	    int returnValue = chooser.showOpenDialog( null ) ;    	 
	    if( returnValue == JFileChooser.APPROVE_OPTION )
	      {
	    	file = chooser.getSelectedFile() ;
	      }
	    	if(file != null)
	    	 {
		      filename = file.getPath();
	    	 }   

				BufferedReader inputFile = new BufferedReader(new FileReader(filename));
				String str;
	      try{
		    while((str = inputFile.readLine()) != null)
		    {
		    	String str1 = str.toString();
		    	String[] arr = str1.split(";");
	        try{
	            date = formatter.parse(arr[3]);
	      }catch(ParseException p){
	          System.out.println("Something Wrong!!,when reading the Date field");
	      }

		        input.add(new Task(arr[0],arr[1],arr[2],date));

		    }
		}catch(IOException e) {
	    e.printStackTrace();
		}

	}

	/*
	 * Write back to the Task Information /Record into .txt file 
	 */

	public void outputWriter() throws IOException
	{
		BufferedWriter writer = new  BufferedWriter(new FileWriter(filename));

			for (Task out: input)
			{
			writer.write(out.getTaskName() + ";"+out.getProjectName()+";"+out.getSatus()+ ";"+ formatter.format(out.getTaskDate())+"\n");
			}

		writer.close();
	}
	 /*
	  * Add new Task Information or Record in to list.
	  */

	public void addRecord(String taskName,String projectName,String taskStatus,Date taskDate) throws IOException, ParseException
	{
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		
		/*
		 * Here entered Date compare with Today date ,If date is old 
	     * display the error message
	     */
		Date today = new Date();
		Date todayWithZeroTime = formatter.parse(formatter.format(today));
		Date inputDateWithZeroTime = formatter.parse(formatter.format(taskDate));
		
		if (inputDateWithZeroTime.compareTo(todayWithZeroTime)<0)
	    {
	    	System.out.println("Please enter Date ,which grater then Today's date");
	    }
	    else
	    {
		input.add(new Task(taskName,projectName,taskStatus,taskDate));
	    }
	    
	}

	/*
	 * Edit the already existing ToDo list
	 */

	public void editRecord(int editIndex,String inputField,int changeField) throws IOException, ParseException

	{
	  Date date = null;
	  
	  if (changeField == 1)
	  {
	    input.set(editIndex,new Task(inputField,input.get(editIndex).getProjectName(),input.get(editIndex).getSatus(),input.get(editIndex).getTaskDate()));
	  }
	  if (changeField == 2)
	  {
	    input.set(editIndex,new Task(input.get(editIndex).getTaskName(),inputField,input.get(editIndex).getSatus(),input.get(editIndex).getTaskDate()));
	  }
	  if (changeField == 3)
	  {
	    input.set(editIndex,new Task(input.get(editIndex).getTaskName(),input.get(editIndex).getProjectName(),inputField,input.get(editIndex).getTaskDate()));
	  }
	  if (changeField == 4)
	  {

	    try{

	    	 date = formatter.parse(inputField);

	  	   }catch(ParseException p){
	  		   						System.out.println("Something Wrong!!,when editing the arraylist record");
	  	   							}
	 
	    DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		
	  /*
	   * Here entered Date compare with Today date ,If date is old 
	   * display the error message
	   */
	  	
	  	Date today = new Date();
	  	Date todayWithZeroTime = formatter.parse(formatter.format(today));
	  	Date inputDateWithZeroTime = formatter.parse(formatter.format(date));
	  	
	  	if (inputDateWithZeroTime.compareTo(todayWithZeroTime)<0)
	    {
	      	System.out.println("Please enter Date ,which grater then Today's date");
	    }
	    else
	    {
	    input.set(editIndex,new Task(input.get(editIndex).getTaskName(),input.get(editIndex).getProjectName(),input.get(editIndex).getSatus(),date));
	    }
	  }
	}

	/*
	 * Delete task record ,which is done or not valid
	 */

	public void deleteRecord(int removeindex) throws IOException
	{
		input.remove(removeindex);
		
	  System.out.println("Record deleted sucessfully ");
	}

	/*
	 * Take the choice from the user using console panel.
	 */

	public int scanInput()
	{
	  @SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	  int i = scan.nextInt();
	  return i;
	}

	}	