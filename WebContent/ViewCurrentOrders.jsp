<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Current Orders</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>


  </style>    
    
    
</head>
<body>
<!-- navbar-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">View Current Order</a>
    </div>
    
        
      
    <ul class="nav navbar-nav navbar-right">
	 <li><a href="ManageProducts.jsp"><span class="glyphicon glyphicon-user"></span> Manage Products</a></li>
      <li><a href="SellerHomePage.jsp"><span class="glyphicon glyphicon-user"></span> Home Page</a></li>
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--Search bar-->

<div class="container">
  <h2>Current Orders</h2>
  <p>Here are your current orders:</p>
  <p>For orders details, please click view</p>
  
  <div class="row">
    <div class="col-md-4">
      <div class="thumbnail">
       
          <img src="Pics/adidas.jpg" alt="Lights" style="width:100%">
          <div class="caption">
            <p>order number:3432423424</p>
			 <p>ordered date:1/1/2017</p>
			 <p>ordered status: in transit</p>
			  <a href="ViewOrderDetail.jsp" target="_blank">
			   <button type="button" class="btn btn-primary btn-md">view</button>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
         <img src="Pics/adidas.jpg" alt="Lights" style="width:100%">
          <div class="caption">
            <p>order number:543665546</p>
			 <p>ordered date:1/2/2017</p>
			 <p>ordered status: in transit</p>
			  <a href="ViewOrderDetail.jsp" target="_blank">
			   <button type="button" class="btn btn-primary btn-md">view</button>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-4">
      <div class="thumbnail">
        <img src="Pics/adidas.jpg" alt="Lights" style="width:100%">
          <div class="caption">
            <p>order number:23432545</p>
			 <p>ordered date:1/3/2017</p>
			 <p>ordered status: in transit</p>
			  <a href="ViewOrderDetail.jsp" target="_blank">
			     <button type="button" class="btn btn-primary btn-md">view</button>
          </div>
        </a>
      </div>
    </div>
  </div>
</div>

</body>
</html>
