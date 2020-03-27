
import java.util.*;

public class Task
{
	String taskName;
	String projectName;
	boolean status;
	String Duedate;
	Scanner console = new Scanner(System.in);

	// Employee() Construction taking in arguments to set name and salary
	Task(String taskName , String projectName , boolean status , String Duedate)
	{
		this.taskName = taskName;
		this.projectName = projectName;
		this.status = status;
		this.Duedate = Duedate;
		System.out.printf("\n Task name:  %s \n Project Name  %s  \n Date : \n\n",taskName, projectName,Duedate);
	}

	// Empty constructor method in order to make empty Task Object
	Task()
	{}

	
	// Prints All the Task Information to the screen
	void get_info(ArrayList<Task> task)
	{
		//Get all Task Information
		int j=0;
		System.out.println("All the Task's information is:");
		for(Task taskInfo: task)
		{
			System.out.println("#"+ (j + 1) + ": " + taskInfo);
			j++;
		}
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
	
	boolean getstatus()
	{
		return status;
	}


	// Override the toString() method to be able to print all Arraylist objects
	public String toString() 
	{
        return ("Task Name: "+this.gettaskName()+ " Project Name : "+ this.getprojectName());
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
					taskName = console.next();
					
					System.out.print("\n Enter the Project Name: ");
					projectName = console.next();
					
					System.out.print("\nEnter the current Status ");
					status = console.hasNextBoolean();
					
					System.out.print("\nEnter the Due Date ");
					Duedate = console.next();			
				
		}
    }

	public int checkInt() {
		// TODO Auto-generated method stub
		return 0;
	}
}
    

     

	

	