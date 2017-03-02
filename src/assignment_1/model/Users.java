package assignment_1.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment_1.model.Users;



public class Users {
	
	private String userName;
	private String password;
	private int type; //customer = 1, seller = 0
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userName, String password, int type) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void addCustomerUser(Users aUser){
		UsersDB uDB = new UsersDB();
		uDB.connectMeIn();
		uDB.addCustomerUserDAO(aUser);
		uDB.closeConnection();
	}
	
	public boolean validateUserByUsername(String aUserName){
		boolean userExists = false;
		UsersDB uDB = new UsersDB();
		uDB.connectMeIn();
		userExists = uDB.validateUserByUsernameDAO(aUserName);
		uDB.closeConnection();
		
		return userExists;
	}
	public boolean validateUser(String aUserName, String aPassword){
		boolean userExists = false;
		UsersDB uDB = new UsersDB();
		uDB.connectMeIn();
		userExists = uDB.validateUserDAO(aUserName, aPassword);
		uDB.closeConnection();
		
		return userExists;
	}
	
	public Users returnUserByUsername(String aUserName) {   
		UsersDB db = new UsersDB();
	   	db.connectMeIn();
	   	Users aUser = db.returnUserByUsernameDAO(aUserName);
	   	db.closeConnection();
	   	
	   	return aUser;
    }
	
	
	/*
	public void registerUser(Users aUser, String propFilePath) {
		
		Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(aUser.getUserName(), aUser.getPassword());
			p.store(new FileOutputStream(propFilePath), null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// validateUser
	public void validateUser(Users aUser, String propFilePath, HttpServletRequest request, HttpServletResponse response) throws IOException{
//		ServletContext sc = this.getServletContext();
//		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
		
		Properties p = new Properties();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			
			p.load(fis);
				
			// Check whether the username exists or not
			if(!p.containsKey(userName)) {			
				// Link-redirection
				response.sendRedirect("Register.jsp");
			} else { // Check whether the password matches or not
				String pword = p.getProperty(userName);  
				if(!pword.equals(password)) {
					response.sendRedirect("Register.jsp"); // Link-redirection
				} else {
					String name = request.getParameter("submit");
					String acceptHeaderString = request.getHeader("accept");

					
			        boolean isChrome = false;
			        if(acceptHeaderString.contains("webp")) {
			     	   isChrome = true;
			        } 
			        
		
			       	 
					
					response.setHeader("Refresh", "2; URL=Home.jsp");
					
			        response.setContentType("text/html");
					
					PrintWriter out = response.getWriter();
				    
				    String docType =
				    	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				    	      "Transitional//EN\">\n";
				    	    String title = "Splash Screen";
				    	    out.println
				    	      (docType +
				    	       "<HTML>\n" +
				    	       "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
				    	       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
				    	       "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n");
				    	    if(isChrome) {
						  		 out.println("<H3> Wait 2 seconds!</H3>");
						  		 out.println("<H4> Welcome Chrome user:</H4>");
						  	       out.println("<CENTER><IMG SRC=Pics/adidas.webp></CENTER>");
						  	    } else {
						  	    	out.println("<H3> Wait 2 seconds!</H3>");
						  	    	 out.println("<H4> You are not a Chrome user, we will display jpg images for you:</H4>");
						  	       out.println("<CENTER><IMG SRC=Pics/adidas.jpg></CENTER>");
						  	    }
				    	   
				    	   
				    	    out.println("</BODY></HTML>");
					 // Link-redirection
				}
			}
			}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				fis.close();
			}
		}
	}
	
	// removeUser
	public void removeUser(Users aUser, String propFilePath, HttpServletResponse response){
		Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.remove(aUser.getUserName(), aUser.getPassword());
			p.store(new FileOutputStream(propFilePath), null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	*/
	
}
