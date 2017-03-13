package assignment_1.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import assignment_1.model.Users;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private long modTime;
	public void init() throws ServletException {
		modTime = System.currentTimeMillis() / 1000*1000;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("psw");
		String type2 = request.getParameter("type");
		
		if (type2.equals("1")){
		Users aUser = new Users(userName, password, 1);//true = costumer
			boolean userExists = false;
			if((userName!=null) && (!userName.trim().equals(""))&&(password!=null) && (!password.trim().equals(""))) {
			
			userExists = aUser.validateUserByUsername(userName);
			if(!userExists){   
				aUser.addCustomerUser(aUser);
				response.sendRedirect("Login.jsp");
				//send emails
			
				 String to = "rogergui2014@hotmail.com";
				 
			      // Sender's email ID needs to be mentioned
			      String from = "renjie.gui@huskers.unl.edu";
			 
			      // Assuming you are sending email from localhost
			      String host = "localhost:8080";
			 
			      // Get system properties
			      Properties properties = System.getProperties();
			      properties.setProperty("mail.user", "renjie.gui@huskers.unl.edu");
			      properties.setProperty("mail.password", "19921149GRJQwQw");
			      // Setup mail server
			      properties.setProperty("mail.smtp.host", host);
			 
			      // Get the default Session object.
			      Session session = Session.getDefaultInstance(properties);
			      
				  // Set response content type
			      response.setContentType("text/html");
			      PrintWriter out = response.getWriter();

			      try{
			         // Create a default MimeMessage object.
			         MimeMessage message = new MimeMessage(session);
			         // Set From: header field of the header.
			         message.setFrom(new InternetAddress(from));
			         // Set To: header field of the header.
			         message.addRecipient(Message.RecipientType.TO,
			                                  new InternetAddress(to));
			         // Set Subject: header field
			         message.setSubject("This is the Subject Line!");
			         // Now set the actual message
			         message.setText("This is actual message");
			         // Send message
			         Transport.send(message);
			         String title = "Send Email";
			         String res = "Sent message successfully....";
			         String docType =
			         "<!doctype html public \"-//w3c//dtd html 4.0 " +
			         "transitional//en\">\n";
			         out.println(docType +
			         "<html>\n" +
			         "<head><title>" + title + "</title></head>\n" +
			         "<body bgcolor=\"#f0f0f0\">\n" +
			         "<h1 align=\"center\">" + title + "</h1>\n" +
			         "<p align=\"center\">" + res + "</p>\n" +
			         "</body></html>");
			      }catch (MessagingException mex) {
			         mex.printStackTrace();
			      }
			   
			}else{
				//show a page to notice user that such username is no exist
				response.sendRedirect("Register.jsp");
			}
		}
		}
		if(type2.equals("2")){
			Users aUser2 = new Users(userName, password, 2);
		
			boolean user2Exists = false;
			if((userName!=null) && (!userName.trim().equals(""))&&(password!=null) && (!password.trim().equals(""))) {
			
			user2Exists = aUser2.validateUserByUsername(userName);
			if(!user2Exists){   
				aUser2.addSellerUser(aUser2);
				response.sendRedirect("Login.jsp");
				//sending emails
				String to = "rogergui2014@hotmail.com";
				 
			      // Sender's email ID needs to be mentioned
			      String from = "renjie.gui@huskers.unl.edu";
			 
			      // Assuming you are sending email from localhost
			      String host = "8080";
			 
			      // Get system properties
			      Properties properties = System.getProperties();
			 
			      // Setup mail server
			      properties.setProperty("mail.smtp.host", host);
			      properties.setProperty("mail.user", "renjie.gui@huskers.unl.edu");
			      properties.setProperty("mail.password", "19921149GRJQwQw");
			      // Get the default Session object.
			      Session session = Session.getDefaultInstance(properties);
			      
				  // Set response content type
			      response.setContentType("text/html");
			      PrintWriter out = response.getWriter();

			      try{
			         // Create a default MimeMessage object.
			         MimeMessage message = new MimeMessage(session);
			         // Set From: header field of the header.
			         message.setFrom(new InternetAddress(from));
			         // Set To: header field of the header.
			         message.addRecipient(Message.RecipientType.TO,
			                                  new InternetAddress(to));
			         // Set Subject: header field
			         message.setSubject("This is the Subject Line!");
			         // Now set the actual message
			         message.setText("This is actual message");
			         // Send message
			         Transport.send(message);
			         String title = "Send Email";
			         String res = "Sent message successfully....";
			         String docType =
			         "<!doctype html public \"-//w3c//dtd html 4.0 " +
			         "transitional//en\">\n";
			         out.println(docType +
			         "<html>\n" +
			         "<head><title>" + title + "</title></head>\n" +
			         "<body bgcolor=\"#f0f0f0\">\n" +
			         "<h1 align=\"center\">" + title + "</h1>\n" +
			         "<p align=\"center\">" + res + "</p>\n" +
			         "</body></html>");
			      }catch (MessagingException mex) {
			         mex.printStackTrace();
			      }
				
				
				
			}else{
				//show a page to notice user that such username is no exist
				response.sendRedirect("Register.jsp");
			}
			}
		}
		}
		//response.sendRedirect("Register.jsp");
		
		  
		
		
		
		
		//First check whether the user already exists via methods from Users class
		
		// Register the Users object
		//aUser.registerUser(aUser, propFilePath);
		 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public long getLastModified(HttpServletRequest request){
		return (modTime); 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void destroy() {
		
	}
}