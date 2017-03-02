<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
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
      <a class="navbar-brand" href="#">Cancel order</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
	 
	  <li><a href="ViewCurrentOrders.jsp"><span class="glyphicon glyphicon-user"></span> View Current Orders</a></li>
      
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<div class="container">
<div class="row">
	 <br>
            
            
                           <table class="table borderless">
    						<thead>
                               
    						</thead>
    						<tbody>
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							<tr>
								<div class="media">
    								        
    								             <h4 class="media-heading">Order number: 434234242</h4><br>
    								             
    								         </div>
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
    								<td class="text-center">$10.99</td>
    								<td class="text-center">2</td>
    								<td class="text-right">$21.98</td>
    								
                               
    						</tbody>
    					</table> 
                        </div>
                    </div>
                
              
             <h3>Do you want to cancel this order?</h3>
<center>
<a href="SellerCancellationConfirmation.jsp"><button type="button" class="btn btn-info btn-circle btn-xl"><i class="glyphicon glyphicon-ok"> Confirm Cancellation</i></button></a>
<a href="SellerHomePage.jsp"><button type="button" class="btn btn-warning btn-circle btn-xl"><i class="glyphicon glyphicon-remove"> Discard Cacellation</i></button></a>
</center>
</body>
</html>
