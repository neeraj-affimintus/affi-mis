package com.misapplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SentMail
 */
@WebServlet("/SentMail")
public class SentMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
	 public void sendPlainTextEmail(String host, String port,
	            final String userName, final String password, String toAddress,
	            String subject, String message) throws AddressException,
	            MessagingException {
	 
	        // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", port);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	 
	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	 
	        Session session = Session.getInstance(properties, auth);
	 
	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);
	 
	        msg.setFrom(new InternetAddress(userName));
	        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        // set plain text message
	        msg.setText(message);
	 
	        // sends the e-mail
	        Transport.send(msg);
	 
	    }
	 
	    /**
	     * Test the send e-mail method
	     *
	     */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		//Get Request Parameter
		
		String requestEmailId=request.getParameter("email");
		String requestPassword=request.getParameter("password");
		
		
        // SMTP server information
    	System.out.println("hello");
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom =requestEmailId;
        String password =requestPassword;
 
        // outgoing message information
        String mailTo = "neerraghuwanshi22@gmail.com";
        String subject = "Hello my friend";
        String message = "Hi guy, Hope you are doing well. Duke.";
 
        SentMail mailer = new SentMail();
 
        try {
        	System.out.println("try");
            mailer.sendPlainTextEmail(host, port, mailFrom, password, mailTo,subject, message);
        	System.out.println("try1");
            out.println("Email sent.");
        } catch (Exception ex) {
        	System.out.println("fail");
            out.println("Failed to sent email.");
            ex.printStackTrace();
        }

	}

}
