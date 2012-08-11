import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	private String userName; 
	private String password; 
	private String sendAddress; 
	
	Email()
	{
		this("credentials.config"); 
	}
	
	Email(String fileName)
	{
		//read in username and password from config file 
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(fileName)); 
			userName = in.readLine();  //time consuming to read from file each time? TODO: change? 
			password = in.readLine();
			sendAddress = in.readLine(); //TODO: more error checking? assume config file is properly formatted and excluded from git add
			in.close(); 
		}
		catch(Exception ex)
		{
			System.out.println("config file not found! or improperly formatted username/pwd combo");
		}
	}
	
	public void send(String mailBody)
	{
		 try {

	            // setup the mail server properties
	            Properties props = new Properties();
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.enable", "true");

	            // set up the message
	            Session session = Session.getInstance(props);

	            Message message = new MimeMessage(session);

	            // add a TO address
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendAddress));

	            // add a multiple CC addresses
	            //message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("yyyyy@gmail.com,zzzzzz@yahoo.com"));
	            
	            //message.setSubject("Welcome to Java");
	           // message.setContent("Hi, im testing a new way to send emails via java.", "text/plain");
	            message.setContent(mailBody, "text/plain"); 
	            
	            Transport transport = session.getTransport("smtp");
	            transport.connect("smtp.gmail.com", 587, userName, password);
	            transport.sendMessage(message, message.getAllRecipients());
	            //logger.error("successfully send email");
	        } catch (Exception e) {            
	            //logger.error(e, e);
	        }
	}
}
