
/** ********************************************************
*  	PROJECT TITLE: MyToDoList 
* 	PURPOSE OF PROJECT: Create an interactive application to manage ToDo tasks 
*	VERSION / DATE: V1.1/2020-03-23 
*	AUTHORS: Shikha Gupta
 *	USER INSTRUCTIONS: N/A

*  **********************************************************
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class TodoList
{
	
	
	static void welcomeMessage()
	{
		System.out.println("\n\n-------------------------------------");
		System.out.println("|---------------------------------------|");
	    System.out.println("|                                   	|");
        System.out.println("|     Welcome to SDA ToDo List          |");
        System.out.println("|                                   	|");
        System.out.println("|---------------------------------------|");
	}
  //Method to access the menu and print it to the console
	static void view_menu()
	{

		System.out.println("\n\n------------------------------------");
        System.out.println("|     		To Do List Menu             |");
        System.out.println("|---------------------------------------|");
        System.out.println("|                                   	|");
        System.out.println("|   Select number and press enter   	|");
        System.out.println("|       to perform operation        	|");
        System.out.println("|-----------------------------------	|");
        System.out.println("|                                   	|");
        System.out.println("| 1.) Add New Task                      |");
        System.out.println("| 2.) Shorted Task By Project or Date   |");
        System.out.println("| 3.) Display Task List                 |");
        System.out.println("| 4.) Show Menu Options                 |");
        System.out.println("| 5.) Change Task Status                |");
        System.out.println("| 6.) Exit and Save List!               |");
        System.out.println("|                                       |");
        System.out.println("-----------------------------------------");
	}

	static Scanner console = new Scanner(System.in);

	public static void main(String args[])
	{
		TodoList.clearConsole();
		
		// Display the Welcome message to user
				welcomeMessage();
		
		// Call view_menu() method to display menu on screen
				view_menu();
				
				/**
				 * Create a text file named SDA_ToDoList.txt in the specified location
				 * Also perform read and write operation from that file to store task and 
				 * get information from text file.
				 * 
				 */
				
			static void taskFileInput(String Task_Name , String Project_Name , String DueDate , String Status ) 
				{

				try {
						// Creating an object of a file
					File myToDoList = new File("./SDA_ToDoList.txt"); 
					if (myToDoList.createNewFile())
						{
							System.out.println("File created: " + myToDoList.getName());
						} else {
							     System.out.println("File already exists.");
							     try {
										FileWriter myWriter = new FileWriter("./SDA_ToDoList.txt");
										 // Writes this content into the specified file
										myWriter.write(Task_Name + "    " + Project_Name + "    " + DueDate + "   " + Status + "\n");
										 
										// Closing is necessary to retrieve the resources allocated
										
										myWriter.flush();
										myWriter.close(); 
										System.out.println("Successfully wrote to the file.");
							          
								
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
					}
				
				/* 
				 * Write in to the file
				 
				
					
				try {
					FileWriter myWriter = new FileWriter("./SDA_ToDoList.txt");
					 // Writes this content into the specified file
					myWriter.write(Task_Name + "    " + Project_Name + "    " + DueDate + "   " + Status + "\n");
					 
					// Closing is necessary to retrieve the resources allocated
					
					myWriter.flush();
					myWriter.close(); 
					System.out.println("Successfully wrote to the file.");
					} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
					}
				}
				*/
				
		Task taskList = new Task();
		boolean programStart = true;
		int userChoiceOption = 0;

		// Creates an Object Arraylist based on number of Task to create
		ArrayList<Task> task = new ArrayList<Task>();

		//taskList.create_new(task);

		

		
		while(programStart)
		{
			// Prompt and accept menu options and execute them in the switch statement
			System.out.print("\nSelect a menu option (5 for list options): ");
			System.out.println();
			Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter Your Choice !!  ");
	    	userChoiceOption = scanner.nextInt();
			
			//userChoiceOption = taskList.checkInt();
			
			switch(userChoiceOption)
			{
				case 1:
				{
					// ADD-Call the creat_new()method with Task class to add the new task 
					taskList.create_new(task); 
					// execute the main method 
					break;
				}

				case 2:
				{ 
					// shorting by project or date
					
					break;
				}

				case 3:
				{
					// Display the Task list with full information
					taskList.get_info(task);
					break;
				}
				
				case 4:
				{
					// Display menu on screen
					view_menu();
					break;
				}
				case 5:
				{
					// change task status
					
					break;
					
					
				}
				case 6:
				{
					// call the quit() method with quit and save  the To Do List
					//taskList.quit(task);
					break;
				}
				
				default:
					// Set programOn Boolean to false to end loop and exit program
					System.out.println("Program Exited!");
					programStart = false;
					break;
				}
			}
		}
	
	/**
	 * Clear the console before printing the options menu. For windows executes
	 * command line "cls" else (Unix) the command line : "clear"
	 */
		static final void clearConsole() 
		{

			ProcessBuilder commandLineExecutor = new ProcessBuilder();

			try {
					final String os = System.getProperty("os.name");

					if (os.contains("Windows")) 
						{
						commandLineExecutor.command("cls").inheritIO().start().waitFor();
						} else
						{
						commandLineExecutor.command("clear").inheritIO().start().waitFor();
						}
				} catch (final Exception e) 
					{
						System.out.println(e);
					}

		}
		
}
