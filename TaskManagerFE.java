/*
 * Written by Mason Allison
 */
import java.util.Scanner;
public class TaskManagerFE 
{	
	private static Scanner keyboard = new Scanner(System.in);
	private static TaskManager taskManager = new TaskManager();
	public static void main(String[] args) 
	{
		
		printGreeting();
		boolean quit = false;
		while(!quit)
		{
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				addTask();
				break;
			case 2:
				removeTaskLine();
				break;
			case 3: 
				taskManager.printToConsole();//calls the printToConsole method from the TaskManager with and instance of it
				
				break;
			case 4: 
				ReadTaskFile();
				break;
			case 5: 
				saveResultsToFile();
				break;
			case 9:
				quit = true;
				break;
				
			default: 
					System.out.println("Invalid Input");//if invalid input is put in it will print this and give the options again
			}
		}

	}
	public static void printGreeting()
	{
		System.out.println("Welcome to Task Organizer");
	}
	public static void printChoices()
	{
		System.out.println("Enter 1. To Add a Task\n"
				+ "Enter 2. To Remove a Task\n"
				+ "Enter 3. To Print Tasks to Console\n"
				+ "Enter 4. To Read from a Task File\n"
				+ "Enter 5. To Write to a Task File\n"
				+ "Enter 9. To Quit");
	}
	public static void ReadTaskFile()
	{
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		taskManager.readTaskFile(fileName);
	}
	public static void removeTaskLine()
	{
		System.out.println("Enter the Task's priority");
		int priority = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Enter the Task's action");
		String action = keyboard.nextLine();
		Task aTask = new Task(action,priority);

		taskManager.removeTask(aTask);
	}
	public static void addTask()
	{
		System.out.println("Enter the Task's priority");
		int priority = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("Enter the Task's action");
		String action = keyboard.nextLine();
		Task aTask = new Task(action,priority);
		taskManager.addTask(aTask);	
	}
	public static void saveResultsToFile()
	{
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		taskManager.WriteTaskFile(fileName);
	}
	
	
	
}
