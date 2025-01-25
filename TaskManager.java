/*
 * Written By Mason Allison
 */
import java.io.*;
import java.util.Scanner;
public class TaskManager 
{
	public static final String DELIM = "\t";
	
	private GenLL<Task>[] organizedTasks;//creates an array of linked lists
	
	public TaskManager()
	{
		organizedTasks = new GenLL[5];
		for(int i=0; i<organizedTasks.length; i++)
		{
			organizedTasks[i] = new GenLL<Task>();
		}
		
	}
	public void addTask(Task aTask)
	{
		int aPriority = aTask.getPriority();
		GenLL<Task> task = organizedTasks[aPriority];
		if(task.contains(aTask))
			System.out.println("This task is already in the list");
		else
			task.add(aTask);
		
	}
	
	public void removeTask(Task aTask) {
	    GenLL<Task> taskList = organizedTasks[aTask.getPriority()];
	    taskList.reset(); // Start from the beginning of the list
	    
	    while (taskList.hasMore()) {
	        Task currentTask = taskList.getCurrent(); 
	        
	        // Compare the action and priority fields manually
	        if (currentTask.getPriority() == aTask.getPriority() && 
	            currentTask.getAction().equals(aTask.getAction())) {
	            taskList.removeCurrent(); // Remove the current task
	            return; // Exit after finding and removing the task
	        }
	        taskList.gotoNext(); // Move to the next task
	    }
	    
	    System.out.println("Task not found: " + aTask); // If no task is found
	}

	public void readTaskFile(String aName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aName));
			while(fileScanner.hasNextLine()) 
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length!=2)
				{
					continue;
				}
				else
				{
					int priority = Integer.parseInt(splitLines[0]);
					String action = splitLines[1];
					Task aTask = new Task(action,priority);
					this.addTask(aTask);
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void printToConsole()
	{
		for(int i=0;i<organizedTasks.length;i++)
		{
			organizedTasks[i].print();
		}
	}
	public void WriteTaskFile(String fileName)
	{
		if(organizedTasks == null)
			return;
		 try
	        {
			 	//results.reset();
			 	PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
	            //while(results.hasMore())
			 	for(int i=0; i<=4;i++)
	            {
			 		
			 		organizedTasks[i].reset();
			 		while(organizedTasks[i].hasMore())
			 		{
			 		Task aTask = organizedTasks[i].getCurrent();
	                fileWriter.println(aTask.toString());
			 		organizedTasks[i].gotoNext();
			 		}
			 		
	            }
	            fileWriter.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	}
}
