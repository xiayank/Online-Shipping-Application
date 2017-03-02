<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <title>Update Order Status</title>
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
      <a class="navbar-brand" href="#">Update Order Status</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
	<li><a href="ManageProducts.jsp"><span class="glyphicon glyphicon-user"></span> Manage Products</a></li>
	<li><a href="ViewCurrentOrders.jsp"><span class="glyphicon glyphicon-user"></span> View Current Order</a></li>
      <li><a href="SellerHomePage.jsp"><span class="glyphicon glyphicon-user"></span> Home Page</a></li>
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<div class="container">
<div class="row">
	 <br>
            <div class="col-md-12">
                <div class="col-md-5 col-sm-7 col-xs-13 col-md-push-7 col-sm-push-7">
                    <!--REVIEW ORDER-->
                    <div class="panel panel-default">
                        <div class="panel-heading text-center">
                            <h4>Order Status</h4>
                        </div>
                        <div class="panel-body">
						 <div class="col-md-12">
                                    <strong>Order status</strong>
                                    <div class="pull-right"><select>
										<option value="volvo">Accepted</option>
										<option value="saab">Shipped</option>
										<option value="mercedes">Delivered</option>
										<option value="mercedes">Completed</option>
										</select></span></div>
                                    <hr>
                                </div>
                                
								<form action = "ViewOrderDetail.jsp" method = "get">
                               <div class="col-md-12">
                                    <strong> Shipment date</strong>
                                    <div class="pull-right"><span><input type="text" name = "date" placeholder="dd/mm/yyyy"></span></div>
                                    <hr>
                                </div>
                                <div class="col-md-12">
                                    <strong>Carrier name</strong>
                                    <div class="pull-right"><span><input type="text" name = "name"placeholder="name"></span></div>
                                    <hr>
                                </div>
								<div class="col-md-12">
                                    <strong>Tracking number</strong>
                                    <div class="pull-right"><span><input type="text" name = "number" placeholder="number"></span></div>
                                    <hr>
                                </div>
								
                                <input type="submit"  value = "Update" class="btn btn-primary btn-lg btn-block"><br/>
								</form>
                                
                        </div>
                        
                    </div>
                    <!--REVIEW ORDER END-->
                </div>
                <div class="col-md-7 col-sm-5 col-xs-11 col-md-pull-5 col-sm-pull-5">
                    <!--SHIPPING METHOD-->
                    <div class="panel panel-default">
                        <div class="panel-heading text-center"><h4>Order Info</h4></div>
                        <div class="panel-body">
                           <table class="table borderless">
    						<thead>
                               
    						</thead>
    						<tbody>
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							<tr>
    								<td class="col-md-3">
    								    <div class="media">
    								         <a class="thumbnail pull-left" href="#"> <img class="media-object" src="Pics/adidas.jpg" style="width: 360px; height: 240px;"> </a>
    								         <div class="media-body">
    								             <h4 class="media-heading"> Order Number</h4>
    								             <h4 class="media-heading"> Order Date</h4>
												 <h4 class="media-heading"> Costumer Name</h4>
    								         
    								         </div>
    								    </div>
    								</td>
    								
    							</tr>
                               
    						</tbody>
    					</table> 
                        </div>
                    </div>
                    <!--SHIPPING METHOD END-->
                </div>
                </div>
                </div>
</div>
           
             
 
</body>
</html>
