package assignment_1.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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