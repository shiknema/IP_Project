package com.sda;

/**
 * Task class have all task base information like Task Name,Project Name,Task Status and Task Date.
 * Using the getter and setter ,set and get the values into these field.
 */

import java.util.*;


public class Task {

		private String taskName;
		private String projectName;
		private String status;
		private Date taskDate;
		 


	public Task(String taskName,String projectName,String status,Date taskDate)
	{
		this.taskName = taskName;
		this.projectName = projectName;
		this.status = status;
	    this.taskDate = taskDate;
	}
                   /*
                    * ************GETTER**************
                    */
		
		 //@return The Task Name.
		 
			public String getTaskName()
			{
				return taskName;
			}
		
		 //@return Project Name
		 
			public String getProjectName()
			{
				return projectName;
			}
		
		 // @return The Task Status
		 
			public String getSatus()
			{
				return status;
			}
		
		 // the Task Date 
			public Date getTaskDate()
			 {
			   return taskDate;
			 }
			
			 /*
			  ************SETTER********************
			  */
			
			
			 // set OR modify the Task Name
			 
			public void setTaskName(String setTaskName)
			{
				taskName = setTaskName;
			}
			
			 //set OR modify the Task Description
			 
			public void setProjectName(String setProjectName)
			{
				projectName = setProjectName;
			}
			
			 // set OR modify the Task Status
			 
			public void setStatus(String setStatus)
			{
				status = setStatus;
			}
			 //set OR modify the Task Date
			 
			public void setTaskDate(Date settaskDate)
			{
			  taskDate = settaskDate;
			}
}
