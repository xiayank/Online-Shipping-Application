package assignment_1.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;
import assignment_1.model.Products;
import assignment_1.model.Users;



/**
 * Servlet implementation class ProductsSearch
 */
@WebServlet("/ProductsSearch")
public class ProductsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		HttpSession session = request.getSession();
		Users aUser = (Users) session.getAttribute("userBean");
		String userName = aUser.getUserName();
		String keyword = request.getParameter("keyword");
		Products aProduct = new Products();
		 
		ArrayList<Products> searchResult = new ArrayList<Products>();
		searchResult = aProduct.returnProductsByKeyword(keyword);
		
		Cookie cookieList[] = request.getCookies();
		String ads = null;
		
		
		if(cookieList != null) {
			for (int i = 0; i < cookieList.length; i++) {
				Cookie aCookie = cookieList[i];
				String query = null;
				if(aCookie.getName().equals(userName)){
					 query = aCookie.getValue();
					 if(query.toUpperCase().contains("NIKE")){
						 ads = "Pics/nike.jpg";
					 }else if(query.toUpperCase().contains("AD")){
						 ads = "Pics/adidas.jpg";
					 }
					 Cookie c = new Cookie("ads", ads);
					 response.addCookie(c);
					 
				}else{
					Cookie c = new Cookie(userName, keyword);
					 response.addCookie(c);
					 //System.out.println(keyword);
				}
				
				
			}
		}
		
		
		
		
		
		
		//print results name
//		for(Products a : searchResult){
//			System.out.println(a.getQuestion());
//		}
		
		request.setAttribute("searchResult", searchResult);
		request.setAttribute("keyword", keyword);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SearchResult.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
