package com.homeworkhelper;
import helper.Hmwrk;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;
import helper.Homework;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* Now it considers Rough Draft Date and the Actual Homework Due Date*/

public class App 
{
    public static void main( String[] args ) throws IOException, ParseException, InterruptedException
    {
      Hmwrk he  = new Hmwrk();
      
      while(true){
    	  he.getAll();
    	  Date currentTime = new Date();
    	  Homework question = he.getRecent();
    	 long timeElaspedRoughDraft = (question.getHomeworkRoughDraft().getTime()-currentTime.getTime());
    	  if(question.getHomeworkRoughDraft().getTime() > currentTime.getTime()){
		String subject = "Problem"+question.getProblemNumber()+" : Rough Draft Due "+question.getHomeworkRoughDraft();
	       sendMessage("EMAIL TO,”EMAIL From”,subject,question.getHomeworkInfo());
       		}
          else{
	         String subject ="Problem "+question.getProblemNumber()+": Homework Due "+question.getHomeworkDueDate();
	         sendMessage("EMAIL TO,”EMAIL From”,subject,question.getHomeworkInfo());
            }
    	  		Thread.sleep(1000*60*60*6);
              }

	 }
public static void sendMessage(String to, String from,String subject,String message){
   String host = "smtp.gmail.com";
   final String userName = “userName”;
   final String password = “********”;

   Properties property = new Properties();
     property.setProperty("mail.smtp.host",host);
     property.setProperty("mail.smtp.auth", "true");
     property.setProperty("mail.smtp.starttls.enable","true");
     property.setProperty("mail.smtp.port","587");
  
  Session emailSession = Session.getInstance(property, new Authenticator(){
	protected PasswordAuthentication getPasswordAuthentication(){
	   return new PasswordAuthentication(userName,password);
        	}});
    try{
        Message homeworkMessage = new MimeMessage(emailSession);
	homeworkMessage.setFrom(new InternetAddress(from));
	homeworkMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	homeworkMessage.setSubject(subject);
	homeworkMessage.setText(message);
	Transport.send(homeworkMessage);
	System.out.println("Homework e-mail sent successfully.");
 	}catch(MessagingException e){
		System.err.print("Message Cannot be send.Check Stack for more information");
		e.printStackTrace();
 	}
}
}
