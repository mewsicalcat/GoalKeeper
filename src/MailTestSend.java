//from http://edwin.baculsoft.com/2011/11/how-to-send-emails-with-java-using-gmail-accounts/

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import org.apache.log4j.Logger; //what does this do? commented out for now

//each task associated with a timer, when timer expires, send email 


public class MailTestSend {

    //private static Logger logger = Logger.getLogger(MailTestSend.class);

    public static void main(String[] args) {
        try {

            // setup the mail server properties
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            // set up the message
            Session session = Session.getInstance(props);

            Message message = new MimeMessage(session);

            // add a TO address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("yourDestEmail@xxx.com"));

            // add a multiple CC addresses
            //message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("yyyyy@gmail.com,zzzzzz@yahoo.com"));
            
            message.setSubject("Welcome to Java");
            message.setContent("Hi, im testing a new way to send emails via java.", "text/plain");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", 587, "yourEmailxxxx", "yourPassWordxxxx");
            transport.sendMessage(message, message.getAllRecipients());
            //logger.error("successfully send email");
        } catch (Exception e) {            
            //logger.error(e, e);
        }
    }
}