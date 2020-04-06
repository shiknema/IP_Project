package com.sda;

/**
 *  This class has a main method ,where user can start that program..
 */

import java.io.IOException;
import java.text.ParseException;

public class ToDoMain
{
	
	public static void main(String[] args) throws IOException, ParseException
	{

		/**
		 * Call TaskInputFunction class to perform its functionality-
		 */
		TaskInputFunction startoption = new TaskInputFunction();
		
		//Call Welcome Message to print Welcome in to console
		startoption.welcomeMessage();
		
		// Call DisplayOption function which have all file handling related function
		startoption.displayOption();
	}
}