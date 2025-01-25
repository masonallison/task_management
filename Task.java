/*
 * Written by Mason Allison
 */
public class Task
{
	private String action;
	private int priority;
	
	public Task()
	{
		this.action = "none";
		this.priority = 4;
	}
	public Task(String aAction, int aPriority)
	{
		this.setAction(aAction);
		this.setPriority(aPriority);
	}
	public String getAction()
	{
		return this.action;
	}
	public int getPriority()
	{
		return this.priority;
	}
	public void setAction(String aAction)
	{
		if(aAction != null)
			this.action = aAction;
		else
			this.action = "none";
	}
	public void setPriority(int aPriority)
	{
		if(aPriority <0 || aPriority>4)
			this.priority=4;
		else
			this.priority = aPriority;
	}
	public String toString()
	{
		return "[Task] Priority: "+this.priority+" Task: "+this.action;
	}
	
	
	
	public boolean equals(Object obj) //have to use equals this way to override the equals used in the GenLL otherwise it won't find the task to remove it
	{
	        if (!(obj instanceof Task)) {
	            return false;
	        }
	        Task other = (Task) obj;
	        return this.priority == other.priority && this.action.equals(other.action);
	}
}
