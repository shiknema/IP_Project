package com.sda;


/**
 * This class has Display Option ,by which user can Add, Edit, Delete ,Sort and Save their data.
 */
import java.io.IOException;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class TaskInputFunction 
{

	private int option,taskNo,changeField;
	private boolean setExit = false;
	private String inputText1,inputText2,inputText3,inputText4;  
	private Date date;
	private ToDoFileHandler toDoFileHandler;
	DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	
	
	/*
	 *  Welcome Message for User
	 */
	void welcomeMessage()
	{
			System.out.println("\n\n------------------------------------");
			System.out.println("|---------------------------------------|");
		    System.out.println("|                                   	|");
		    System.out.println("|     Welcome to SDA ToDo List          |");
		    System.out.println("|                                   	|");
		    System.out.println("|---------------------------------------|");
	}
	
	/*
	 * Method to access the menu and print it to the console
	 */
	
	public void displayOption() throws ParseException
	{
		toDoFileHandler = new ToDoFileHandler();
	
	  try{
		  toDoFileHandler.inputReader(); 
	      }catch(IOException a)
	    {
	      System.out.println(" Error Reading inputfile ");
	    }
	
		  System.out.println("\n\n-------------------------------------");
	      System.out.println("|     		To Do List Menu           |");
	      System.out.println("|---------------------------------------|");
	      System.out.println("|                                       |");
	      System.out.println("|   Select number and press enter       |");
	      System.out.println("|       to perform operation            |");
	      System.out.println("|---------------------------------------|");
	      System.out.println("|                                       |");
	      System.out.println("| 1.) Display Task List                 |");
	      System.out.println("| 2.) Add New Task                      |");
	      System.out.println("| 3.) Edit in Task                      |");
	      System.out.println("| 4.) Delete the Task                   |");
	      System.out.println("| 5.) Save and Exit List!               |");
	      System.out.println("|                                       |");
	      System.out.println("-----------------------------------------");
	      System.out.println("Choose the option from the List Menu");
	      option = scanInput();
	
	      while(!(setExit))
	      {
	    	  // Display the To do list 
	     
	           if(option == 1)
	            {
	              displayTask();
	            }
	
	    
	           //Add new task to the list
	     
	            if(option == 2)
	            {
	              addTask();
	            }
	
	            // Edit the existing task list
	     
	            if(option == 3)
	            {
	              editTask();
	            }
	
	            //Delete the Task/Record from the list
	     
	            if (option == 4)
	            {
	              deleteTask();
	            }
	    
	            // Save and Exit
	     
	            if(option == 5)
	             {
	               saveAndExit();
	             }
	        }
	    }
	   
	 /*
	  * Take the input from the console panel
	  */
	  public int scanInput()
	      {
	          @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
	          int i = scan.nextInt();
	          return i;
	       }
	        
	  /*
	   * Read the input using FileReader
	   */
	   public String scanString()
	     {
	        @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
	        String line = scan.nextLine();
	        return line;
	      }
	   
	    /*
	     *  Add the New task 
	     */
	    private void addTask() throws ParseException
	      {
	          System.out.println("Enter the Task Name   :  ");
	          inputText1 = scanString();
	          System.out.println("Enter the Project Name :  ");
	          inputText2 = scanString();
	          System.out.println("Enter the Status  :  ");
	          inputText3 = scanString();
	          System.out.println("Enter the TaskDate(yyyy-mm-dd)  :  ");
	          inputText4 = scanString();
	          try{
	        	  date = formatter.parse(inputText4); 
	          
	          	}catch(ParseException p)
	          	{
	          		System.out.println(" Error occured while trying to covert date ");
	          	}
	
	          	 try{
	          			toDoFileHandler.addRecord(inputText1,inputText2,inputText3,date);
	          			System.out.println("Choose the option from the List Menu");
	          			option = scanInput();
	          		}catch(IOException f)
	          		{
	          			System.out.println("There is something wrong!! Please enter the correct information ");
	          		}
	        }
	
	      /*
	       *  Edit the existing Task Information/Record 
	       */
	      private void editTask() throws ParseException
	          {
	    	  System.out.println("Enter the **TASK No** for performing Editing");
	          taskNo = scanInput();
	          taskNo = taskNo - 1;
	          System.out.println("-----------------------------------");
	          System.out.println("|                                 |");
	          System.out.println("| 1.) Task Name                   |");
	          System.out.println("| 2.) Project Name                |");
	          System.out.println("| 3.) Status                      |");
	          System.out.println("| 4.) Date                        |");
	          System.out.println("|                                 |");
	          System.out.println("-----------------------------------");
	          
	          System.out.println("Choose the number,which you want to Edit");
	            option = scanInput();
	            
	            // Edit Task Name
	            if (option ==1)
	            {
	              System.out.println("Enter the new Task Name : " );
	              inputText1 = scanString();
	              changeField = 1;
	               try
	                {
	            	   toDoFileHandler.editRecord(taskNo,inputText1,changeField);
	                }catch (IOException e) {
	                						System.out.println("You are doing something wrong!!, when editing Task Name");
	                						}
         		  System.out.println("\n Choose the option from the List Menu");
	              option = scanInput();
	
	            }
	            
	            // Edit Project Name
	            if (option == 2)
	            {
	               System.out.println("Enter the new Project Name : ");
	              inputText2 = scanString();
	              changeField = 2;
	              try
	               {
	            	  toDoFileHandler.editRecord(taskNo,inputText2,changeField);
	
	               }catch(IOException f){
	                   						System.out.println("You are doing something wrong!!, when editing Project Name");
	                					}
        			System.out.println("\n Choose the option from the List Menu");
	                option = scanInput();
	
	            }
	            
	            //Edit the Status
	            if (option == 3)
	             {
		              System.out.println("Enter the new status : ");
		              inputText3 = scanString();
		              changeField = 3;
		              try
		               {
		            	  toDoFileHandler.editRecord(taskNo,inputText3,changeField);
		               }catch (IOException g){
		            	   						System.out.println("You are doing something wrong!!, when editing Staus");
		               						 }
        			 System.out.println("\n Choose the option from the List Menu");
	                 option = scanInput();
	             }
	            
	            //Edit the Due Date
	            if (option == 4)
	             {
		              System.out.println("Enter the new DueDate(yyyy-mm-dd) : ");
		              inputText4 = scanString();
		              changeField = 4;
		              try
		               {
		            	  toDoFileHandler.editRecord(taskNo,inputText4,changeField);
		               }catch (IOException g) {
		            	   						System.out.println("You are doing something wrong!!, when editing Date");
		               						  }
		              System.out.println("\n Choose the option from the List Menu");
		              option = scanInput();
	             }
	          }
	    
	     /*
	     *  delete the task/Record from the List
	     */
	    private void deleteTask()
	          {
	            System.out.println("\n Enter the TASK NO. which you want to delete ");
	            taskNo = scanInput();
	            taskNo = taskNo - 1;
	            try{
	            	toDoFileHandler.deleteRecord(taskNo);
	                }catch(IOException g)
	                {
	                  System.out.println(" Choose the correct TASK No.!!!");
	                }
      			System.out.println("\n Choose the option from the List Menu");
	                  option = scanInput();
	              }
	    /*
	     *  Save the task/Record in the ToDO list 
	     *  and 
	     *  Exit from the console panel
	     */
	    private void saveAndExit()
	            {
	    		System.out.println("Thank you for using ToDoList!!! ");
	             try{
	            	 toDoFileHandler.outputWriter();
	              }catch(IOException e)
	              {
	                System.out.println("Not allow to write into the file");
	              }
	              setExit = true;
	              }
	    /*
	     *  Display Task
	     */
	    private void displayTask()
	            {
	    	toDoFileHandler.displayInput();
  			System.out.println("\n Choose the option from the List Menu");
	              option = scanInput();
	            }
	      
}
