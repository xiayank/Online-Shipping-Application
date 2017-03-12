<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Cancellation Confirmation </title>
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
      <a class="navbar-brand" href="#">Cancellation Confirmation</a>
    </div>
     <ul class="nav navbar-nav navbar-right">
      <li><a href="SellerHomePage.jsp"><span class="glyphicon glyphicon-user"></span> Home </a></li>
        <li><a href="ViewCurrentOrders.jsp"><span class="glyphicon glyphicon-user"></span> View My Order</a></li>
      <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<div class="container">
<div class="row">
	 <br>
            
    <h2>Your cancellation is successful!</h2>        
                           <table class="table borderless">
    						<thead>
                               
    						</thead>
    						<tbody>
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							<tr>
								<div class="media">
    								        
    								             <h4 class="media-heading">Order number: 434234242</h4><br>
    								             
    								         </div>
											 <h4>You have cancelled the following items</h4>
    								<td class="col-md-3">
									
    								    <div class="media">
    								         <a class="thumbnail pull-left" href="#"> <img class="media-object" src="Pics/adidas.jpg" style="width: 72px; height: 72px;"> </a>
    								         <div class="media-body">
    								             <h5 class="media-heading"> Product Name</h5>
    								             <h5 class="media-heading"> Product Code</h5>
												 <h5 class="media-heading"> Shipping status</h5>
    								         </div>
    								    </div>
    								</td>
    								<td class="text-center">$199</td>
    								<td class="text-center">1</td>
    								<td class="text-right">$199</td>
    								
                               
    						</tbody>
    					</table> 
								<div class="media">
    								        
    								             <h4 class="media-heading">$199 has refunded back to the credit card account.</h4><br>
    								             
    								         </div>
											 
    								<td class="col-md-3">
                        </div>
                    </div>
                
  
</body>
</html>