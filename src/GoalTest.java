import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;


public class GoalTest {

	public static void main(String[] args)
	{
		LinkedList<Goal> goals = new LinkedList<Goal>(); 
		//Goal goal = new Goal("finish research", "1"); 
		//Goal goal2 = new Goal("do dishes", "2"); 
		//goals.add(goal); 
		//goals.add(goal2); 
		
		System.out.println("Welcome to Goal Keeper! \n");
		displayMenu(); 
		Scanner in = new Scanner(System.in); 
		while(in.hasNext())
		{
			String input = in.nextLine(); 
			//parse
			String[] parsed = input.split(" "); 
			Goal goal = new Goal(parsed[0], parsed[1]); 
			goals.add(goal); 
			sendAlert(goal); 
			displayMenu(); 
		}
	}
	
	public static void sendAlert(Goal g)
	{
		//takes goal, sends alert for the goal
		Timer timer = new Timer(); 
		timer.schedule(new SendEmailTask(g), g.dueDate);
	}
	
	public static void displayMenu()
	{
		System.out.println("Enter a goal and a completion time: ");
	}
}
