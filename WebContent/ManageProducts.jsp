<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Manage Products</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
     .container {
      padding: 80px 10px;
  }
  
  </style>    

    
</head>
<body>
<%
String name = request.getParameter("name");
String category = request.getParameter("category");
String price = request.getParameter("price");
String stocknumber = request.getParameter("stocknumber");

String addname = request.getParameter("addname");
String addcategory = request.getParameter("addcategory");
String addprice = request.getParameter("addprice");
String addstocknumber = request.getParameter("addstocknumber");

if(name == "" || category == "" || price == "" || stocknumber == "" || name == null || category == null || price == null || stocknumber == null){
	name = "ADIDAS RUNNING SHOE";
	category = "Men Shoe";
	price = "100";
	stocknumber = "123";
}
%>
<!-- navbar-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Manage Products</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="ViewCurrentOrders.jsp"><span class="glyphicon glyphicon-user"></span> View Current Orders</a></li>
      <li><a href="SellerHomePage.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Seller Homepage</a></li>
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--results -->
<div class="container ">
    
  <h2>Here are your products for selling:</h2>
<td><a href="AddNewProduct.jsp">
<button type="button" class="btn btn-success"  style="float: right;">Add New Product</button></a></td>
  <br>
    
    <table class="table">
    <thead>
      <tr>
        <th></th>
        <th> Name</th>
        <th> Category</th>
        <th>Price</th>
		<th>Number of Purchases</th>
		<th>Number of items in stock</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><div class="col-sm-12">
      <a href="#demo3" data-toggle="collapse">
        <img src="Pics/adidas.jpg" class=" person" alt="Random Name" width="255" height="255">
      </a>
      </div>
        </td>
        <td><%= name %></td>
        <td><%= category %></td>
        <td><%= price %></td>
		<td>10</td>
		<td><%= stocknumber %></td>
		
        <td><a href="EditProductDetails.jsp"><button type="button" class="btn btn-success">Edit</button></a></td>
      </tr>
      <%
      if(addname != null && addname != null){
    	  
      }
      %>

	<%
	if(addname != null && addname != ""){
	%>
		<tr>
        <td><div class="col-sm-12">
      <a href="#demo3" data-toggle="collapse">
        <img src="Pics/adidas.jpg" class=" person" alt="Random Name" width="255" height="255">
      </a>
      </div>
        </td>
        <td><%= addname %></td>
        <td><%= addcategory %></td>
        <td><%= addprice %></td>
		<td>10</td>
		<td><%= addstocknumber %></td>
		
        <td><a href="EditProductDetails.jsp"><button type="button" class="btn btn-success">Edit</button></a></td>
      </tr>
	<%
		} 
		
	%>
    
     
    </tbody>
  </table>
</div>

    
    
</body>
</html>