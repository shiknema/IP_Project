
/** ********************************************************
*  	PROJECT TITLE: MyToDoList 
* 	PURPOSE OF PROJECT: Create an interactive application to manage ToDo tasks 
*	VERSION / DATE: V1.1/2020-03-23 
*	AUTHORS: Shikha Gupta
 *	USER INSTRUCTIONS: N/A

*  **********************************************************
*/
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
		
		// Display the Welcome message to user
				welcomeMessage();
		
		// Call view_menu() method to display menu on screen
				view_menu();
				
		Task taskList = new Task();
		boolean programOn = true;
		int userMenuOption = 0;

		// Creates an Object Arraylist based on number of Task to create
		ArrayList<Task> task = new ArrayList<Task>();

		//taskList.create_new(task);

		

		
		while(programOn)
		{
			// Prompt and accept menu options and execute them in the switch statement
			System.out.print("\nSelect a menu option (5 for list options): ");
			System.out.println();
			Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter Your choise ");
	    	userMenuOption = scanner.nextInt();
			
			//userMenuOption = taskList.checkInt();
			
			switch(userMenuOption)
			{
				case 1:
				{
					// ADD-Call the creat_new()method with Task class to add the new task 
					taskList.create_new(task);
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
					programOn = false;
					break;
				}
			}
		}
	}
