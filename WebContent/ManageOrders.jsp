<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Manage Orders</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
     .container {
      padding: 80px 10px;
  }
/*
 * BOOTSTRAP
 */
.container{
    border: none;
}
.panel-footer{
    background:#fff;
}
.btn{
    border-radius: 1px;
}
.btn-sm, .btn-group-sm > .btn{
    border-radius: 1px;
}
.input-sm, .form-horizontal .form-group-sm .form-control{
    border-radius: 1px;
}

.panel-info {
    border-color: #999;
}

.panel-heading {
    border-top-left-radius: 1px;
    border-top-right-radius: 1px;
}
.panel {
    border-radius: 1px;
}
.panel-info > .panel-heading {
    color: #eee;
    border-color: #999;
}
.panel-info > .panel-heading {
    background-image: linear-gradient(to bottom, #555 0px, #888 100%);
}

hr {
    border-color: #999 -moz-use-text-color -moz-use-text-color;
}

.panel-footer {
    border-bottom-left-radius: 1px;
    border-bottom-right-radius: 1px;
    border-top: 1px solid #999;
}

.btn-link {
    color: #888;
}

hr{
    margin-bottom: 10px;
    margin-top: 10px;
}
  </style>    

    
</head>
<body>
<!-- navbar-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SHOPPING YOU WANT!</a>
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
      <li><a href="Home.jsp"><span class="glyphicon glyphicon-user"></span> Home </a></li>
        <li><a href="ViewOrders.jsp"><span class="glyphicon glyphicon-user"></span> View My Order</a></li>
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--results -->
<div class=" ">
    <div class="text-center">
  <h2>Order Detail of Order number: 246871236</h2>
  
  <br>
    </div>
    <table class="table">
    <thead>
      <tr>
        <th></th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Seller name</th>
        <th>Shipping status</th>
        <th>Total price</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><div class="col-sm-12">
      <a href="#demo3" data-toggle="collapse">
        <img src="Pics/adidas.jpg" class=" person" alt="Random Name" width="100" height="100">
      </a>
      </div>
        </td>
        <td>ADIDAS RUNNING SHOE</td>
        <td>1</td>
        <td>Adidas</td>
        <td>shipping</td>
        <td>$199</td>  
        <td><a href="ProductDetail.jsp" type="button" class="btn btn-success">View</a></td>
          <td><a href="CancelOrder.jsp" type="button" class="btn btn-danger">Cancel</a></td>
      </tr>
   
     
    </tbody>
  </table>
</div>
    <hr>
<div class="container">
	<table id="cart" class="  table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:20%">Order number</th>
                            <th style="width:15%">Ordered date</th>							
							<th style="width:15%">Order Total</th>
                            <th style="width:15%">Shipping address</th>
							
							
						</tr>
					</thead>
					<tbody>
						<tr>
							
                            <td data-th="Seller">246871236</td>
                            <td data-th="Seller">1/1/2017</td>
							<td data-th="Price">$199</td>
                            <td data-th="Price">2527H ST APT1, Lincoln, NE</td>
							
							
						</tr>
					</tbody>

				</table>        
    </div>
    <hr>
    
    
</body>
</html>