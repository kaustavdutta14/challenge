package com.crescendo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SendEmailController {	

	@RequestMapping(value = "/sendEmail.do", method = RequestMethod.POST)
	public String doSendEmail(HttpServletRequest request, ModelMap model) {
		
		//Retrieve inputs from contact form
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String recipientEmail = request.getParameter("recipientEmail");

		if(firstName.isEmpty() || lastName.isEmpty() || recipientEmail.isEmpty()){
			model.addAttribute("message", "All required fields must be filled out");
			return "Error";
		}else{
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			
			//Set Properties object
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.auth", "true");
			props.put("mail.store.protocol", "pop3");
			props.put("mail.transport.protocol", "smtp");
			try{
				//Read user credentials from properties file
				Properties userDetails = new Properties();
				InputStream input =  getClass().getClassLoader().getResourceAsStream("config.properties");	 
				userDetails.load(input);
				final String username = userDetails.getProperty("username");
				final String password = userDetails.getProperty("password");


				Session session = Session.getDefaultInstance(props, 
						new Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}});

				//Create a new message
				Message msg = new MimeMessage(session);

				//Recipient email address being set --
				msg.setRecipients(Message.RecipientType.TO, 
						InternetAddress.parse(recipientEmail,false));
				msg.setSubject("Test Email");
				msg.setText("First Name: " + firstName + "\nLast Name: " + lastName);
				msg.setSentDate(new Date());
				Transport.send(msg);

			}catch(IOException ex){
				model.addAttribute("message", "Failed to read user credentials");
				return "Error";
			}catch(MessagingException e){
				model.addAttribute("message", e.getMessage());
				return "Error";
			}

			//Forward to the view named "Result"
			return "Result";
		}

	}
}