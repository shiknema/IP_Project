
import java.util.*;


public class Task
{
	String taskName;
	String projectName;
	String Duedate;
	String status;
	

	
	Task(String taskName , String projectName , String status , String Duedate)
	{
		this.taskName = taskName;
		this.projectName = projectName;
		this.status = status;
		this.Duedate = Duedate;
	}

	// Empty constructor method in order to make empty Task Object
	Task()
	{}
    
	// to take input from  console panel
	Scanner console = new Scanner(System.in);
	
	// Store task information in to Array List
	private static ArrayList<Task> ToDoTaskTable = new ArrayList<Task>();
	 
	public static ArrayList<Task>getToDoTaskTable(){
		return ToDoTaskTable;
	}
	
		
		
	
	// Prints All the Task Information to the screen
	void get_info(ArrayList<Task> ToDoTaskTable)
	{
		//Get all Task Information
		int j=0;
		System.out.println("All the Task's information is:");
		for(Task taskInfo: ToDoTaskTable)
		{
			System.out.println("#"+ (j + 1) + ": " + taskInfo);
			j++;
		}
	

	
	// Used to get the task name from the Task arraylist
		
	String gettaskName()
		{
			return taskName;
		}

	// Used to get the Project name from the projectName arraylist
	
	String getprojectName()
	{
		return projectName;
	}
	
	//Used to display the date ,when Task created
	String getDuedate()
	{
		return Duedate;
	}
	
	//Used to shoe the current status of the Task
	
	String getstatus()
	{
		return status;
	}

	}

    // Used to add the New Task
	void create_new(ArrayList<Task> task)
    {
    	int No_Of_Task; 
		System.out.print("\n How many Tasks would you like to create?:");
		No_Of_Task = console.nextInt();
    	
		// Creating each object to add the task in task array 
		for(int i = 0; i < No_Of_Task; i++)
		{
		
					System.out.print("\nEnter the task name: ");
					taskName = console.nextLine();
					
					System.out.print("\n Enter the Project Name: ");
					projectName = console.nextLine();
					
					System.out.print("\nEnter the current Status ");
					status = console.nextLine();
					
					System.out.print("\nEnter the Due Date ");
					Duedate = console.nextLine();			
				
		}
    }

	
}
    

     

	

	