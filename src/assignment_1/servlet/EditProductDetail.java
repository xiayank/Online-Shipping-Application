package assignment_1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment_1.model.Products;
import assignment_1.model.ProductsInfo;

/**
 * Servlet implementation class EditProductDetail
 */
@WebServlet("/EditProductDetail")
public class EditProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String refer = request.getHeader("referer");
		if(refer.contains("ManageProducts")) {
		int ID = Integer.parseInt(request.getParameter("ID"));
		Products aProduct = new Products();
		aProduct = aProduct.returnProductsByID(ID);
		request.setAttribute("selectedProduct", aProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditProductDetails.jsp");
		//System.out.println(aProduct.getProductDescription());
		dispatcher.forward(request, response);
		}
		else {
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		String description = request.getParameter("Description");
		int ID = Integer.parseInt(request.getParameter("ID"));
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String imageaddress = request.getParameter("imageaddress");
		int categoryindex= Integer.parseInt(request.getParameter("category"));
		Products aProduct = new Products();
		aProduct = aProduct.returnProductsByID(ID);
		aProduct.editProducts(aProduct, name, price,quantity,description,categoryindex,imageaddress);
		request.setAttribute("selectedProduct", aProduct);
		
		ProductsInfo aInfo = new ProductsInfo();
		aInfo = aInfo.returnQABeanByProductID(ID);
		
		aInfo.editQA(aInfo, ID, question, answer);
		request.setAttribute("QA", aInfo);
		
	
	
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditProductDetails.jsp");
		dispatcher.forward(request, response);
		}
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
