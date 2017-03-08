<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Manage Product</title>
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
<!-- navbar-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Home.jsp">Manage Product</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">New Arrive</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">MEN<span class="caret"></span></a>
        
        <ul class="dropdown-menu">
          <li><a href="#">SHOES</a></li>
          <li><a href="#">TOP</a></li>
          <li><a href="#">BOTTOM</a></li>
          <li><a href="#">ACCESSORIES</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">WOMEN<span class="caret"></span></a>
        
        <ul class="dropdown-menu">
          <li><a href="#">SHOES</a></li>
          <li><a href="#">TOP</a></li>
          <li><a href="#">BOTTOM</a></li>
          <li><a href="#">ACCESSORIES</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">KIDS<span class="caret"></span></a>
        
        <ul class="dropdown-menu">
          <li><a href="#">SHOES</a></li>
          <li><a href="#">TOP</a></li>
          <li><a href="#">BOTTOM</a></li>
          <li><a href="#">ACCESSORIES</a></li>
        </ul>
      </li>    
    </ul>
    <ul class="nav navbar-nav navbar-right">
   	 <li><a><span class="glyphicon glyphicon-user"></span> Hi ${userBean.userName}</a></li>
      <li><a href="ViewOrders.jsp"><span class="glyphicon glyphicon-user"></span> View My Order</a></li>
      <li><a href="AddNewProduct.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Add New Product</a></li>
      <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--results -->
<div class="container ">

    <div class="text-center">

  
  
	


  <br>
    </div>
    <table class="table">
    <thead>
      <tr>
        <th></th>
        <th>Name</th>
        <th>Category</th>
        <th>available quantity</th>
        <th>Price</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    
    
    <c:forEach var="productResultBean" items="${productResult}">
      <tr>
        <td><div class="col-sm-12">
        
      <a href="#demo3" data-toggle="collapse">
       <img src= ${productResultBean.productThumbnail} class=" person" alt="Random Name" width="255" height="255">
      </a>
     
      
      </div>
        </td>
        <td>${productResultBean.productName}</td>
        <td>${productResultBean.productCategory}</td>
        <td>${productResultBean.availableQuantity}</td>
        <td>${productResultBean.price} $</td>
   
        
         <!-- use a hidden input tag to store the ID and submit it to servlet when corresponding button been clicked -->
        <form action = "EditProductDetail" method = "post"  />
        <input type="hidden" name="ID" value="<c:out value="${productResultBean.ID}" />">
        <td> <button type="submit" class="btn btn-success">Edit Product</button>   </td>
        </form>
        
      </tr>
    
    </c:forEach>
    </tbody>
  </table>
</div>

    
    
</body>
</html>