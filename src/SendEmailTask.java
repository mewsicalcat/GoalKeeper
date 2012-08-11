import java.util.TimerTask;


public class SendEmailTask extends TimerTask {

	Goal goal; 
	
	SendEmailTask(Goal g)
	{
		this.goal = g; 
	}
	
	@Override
	public void run() {
		//send email
//		System.out.println(this.name);  //TODO: remove 
		Email email = new Email();
		email.send(this.goal.name); 
		
	}

}
