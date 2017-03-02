package assignment_1.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assignment_1.model.Users;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private long modTime;
	public void init() throws ServletException {
		modTime = System.currentTimeMillis() / 1000*1000;
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    
		String userName = request.getParameter("userName");
		String password = request.getParameter("psw");
		
		boolean userExists = false;
		Users aUser = new Users();
		
		if((userName!=null) && (!userName.trim().equals(""))&&(password!=null) && (!password.trim().equals(""))){
			userExists = aUser.validateUser(userName, password);
			if(userExists){
				
				aUser = aUser.returnUserByUsername(userName);
				
				HttpSession session = request.getSession();
			    session.setAttribute("userBean", aUser);
			    
			    String address = "Home.jsp";
			    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			    dispatcher.forward(request, response);
			}else{
				response.sendRedirect("Login.jsp");
			}
		}else{
			response.sendRedirect("Login.jsp");
		}
		
//		ServletContext sc = this.getServletContext();
//		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
//		
//		Users aUser = new Users(userName, password);
//		aUser.validateUser(aUser, propFilePath, request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public long getLastModified(HttpServletRequest request){
		return (modTime); 
		
	}
	public void destroy() {
		//persistState();
	}

}
