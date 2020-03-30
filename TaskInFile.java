/**
 * Create a Text File to store all Task information for ToDoList.
 * 
 * 
 * @author shikhagupta
 *
 */
// Import the File class
import java.io.File;
import java.io.FileWriter;
// Import the IOException class to handle errors
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 
		 
 public class TaskInFile 
 {
	 
	 static Scanner console = new Scanner(System.in);
	private static Object v;
	 public static void main(String args[]) throws IOException
		{
		 System.out.println("Enter the information");
		 
		   System.out.print("\nEnter the task name: ");
			 String Task_Name = console.nextLine();
			
			System.out.print("\n Enter the Project Name: ");
			String Project_Name = console.nextLine();
			
			System.out.print("\nEnter the Due Date ");
			String Duedate = console.nextLine();	
			
			System.out.print("\nEnter the current Status ");
			String Status = console.nextLine();
			
				 v=taskFileInput(Task_Name,Project_Name,Duedate,Status);
		 System.out.println("File created: " + v);
		}
		
	
	 

	
	 static Object taskFileInput(String task_Name, String project_Name, String duedate, String status) throws IOException {
		// TODO Auto-generated method stub
		try {
			// Creating an object of a file
			File myToDoList = new File("SDA_ToDoList.txt"); 
			try {
				if (myToDoList.createNewFile()){
						System.out.println("File created: " + myToDoList.getName());
					} else {
						System.out.println("File already exists.");
						// Returning the path of the file 
						System.out.println("Absolute path: " + myToDoList.getAbsolutePath());   
						System.out.println("Enter ur choice - \t 1 :Create new task in List  \n 2: Add task in to existing list \n" );
						
						 int choice = console.nextInt();;
						switch(choice)
						 { 
						 	case 1 :
							 {
								 System.out.println("Create a new Task " );
								 try {
									 FileWriter myWriter = new FileWriter("SDA_ToDoList.txt");
									 // Writes this content into the specified file
									 myWriter.write("Task_Name =     "+task_Name  + "\t Project_Name = " + project_Name + "\t Duedate =" + duedate  + "\t Status = "+ status +"\n");
							 
									 // Closing is necessary to retrieve the resources allocated
							
									 myWriter.flush();
									 myWriter.close(); 
									 System.out.println("Successfully wrote to the file." );
									 }catch (IOException e) {
																System.out.println("An error occurred.");
																e.printStackTrace();
															}
							        
							
							    break;
							 }
							
							case 2:
							{
								System.out.println("Add the Task in to the existing list " );
								FileWriter fileWriter;
								try {
									fileWriter = new FileWriter("SDA_ToDoList.txt", true);
									PrintWriter printWriter = new PrintWriter(fileWriter);
									printWriter.println(Task.getToDoTaskTable().add(new Task(task_Name, project_Name, duedate, status)));
									printWriter.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} //Set true for append mode
								
								break;
							}
						    
							default:
							{
								break;
							 }
						 
						 }
					}
			
		}finally {
			System. out. println( "") ;
		}
		}	finally {
						System. out. println( "*** To DO List **!!") ;
						try {
								// Creating an object of a file
								File myToDoList = new File("SDA_ToDoList.txt"); 
								Scanner myReader = new Scanner(myToDoList);
								while (myReader.hasNextLine()) {
								String data = myReader.nextLine();
								System.out.println(data);
					
								}
								myReader.close();
							}catch (Exception e) {
													System.out.println("An error occurred.");
													e.printStackTrace();
												}
					}
			
		
		return 0;
	}
	 }

