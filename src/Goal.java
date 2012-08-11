import java.util.Date;
import java.util.Timer;


public class Goal {

	String name; 
	//long timeFromNowNeeded; 
	Date dueDate; 
	
	Goal(String n, String tN)
	{
		this.name = n; 
		//parse the timeNeeded
		String delims = ":"; 
		String [] tokens = tN.split(delims); 
		//2 items in tokens if contains hour, else 1 
		int hours = 0; 
		int minutes; 
		try
		{
			if (tokens.length == 2)
				
		{
				hours = Integer.parseInt(tokens[0]); 
				minutes = Integer.parseInt(tokens[1]); 
		}
			else
			{
				minutes = Integer.parseInt(tokens[0]); 
			}
		
			//convert to milliseconds
			long timeNeededMilli = (long) 3600000 * hours + 60000 * minutes; 
			this.dueDate = new Date(System.currentTimeMillis() + timeNeededMilli); 

		}
		catch(Exception ex)
		{
			ex.printStackTrace(); //improperly formatted; couldn't parse 
		}

		
		
		
	}
	
}
