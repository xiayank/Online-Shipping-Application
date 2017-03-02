<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Order Detail</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>

  </style>    
    
												    
</head>
<body>
<%
String name = request.getParameter("name");
String date = request.getParameter("date");
String number = request.getParameter("number");
if(name == null || name == "" || date == null || date == "" || number == null || number == ""){
	name = "UPS";
	date = "1/23/2017";
	number = "6291236382";
}
%>



<!-- navbar-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">View Order Detail</a>
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
                            <h4>order information</h4>
                        </div>
                        <div class="panel-body">
						 <div class="col-md-12">
                                    <strong>Order Number</strong>
                                    <div class="pull-right"><span>124348212</span></div>
                                    <hr>
                                </div>
                                <div class="col-md-12">
                                    <strong>Order total (# item)</strong>
                                    <div class="pull-right"><span>$</span><span>32.97</span></div>
                                </div>
                                <div class="col-md-12">
                                    <strong>Tax</strong>
                                    <div class="pull-right"><span>$</span><span>2.03</span></div>
                                </div>
								<div class="col-md-12">
                                    <strong>total price</strong>
                                    <div class="pull-right"><span>$</span><span>35.00</span></div>
                                </div>

                                <div class="col-md-12">
                                    <small>order status</small>
                                    <div class="pull-right"><span>Shipping</span></div>
                                    <hr>
                                </div>
								<div class="col-md-12">
                                    <strong>Order Date</strong>
                                   
                                    <div class="pull-right"><span></span><span>1/1/2017</span></div><br/>
                                    </div>
								<div class="col-md-12">
                                    <strong>Shipment Date</strong>
                                    <div class="pull-right"><span></span><span><%= date %></span></div><br/>
								</div>
								<div class="col-md-12">
                                    <strong>Carrier name</strong>
                                    <div class="pull-right"><span></span><span><%= name %></span></div><br/>
								</div>
								<div class="col-md-12">
                                    <strong>Tracking number</strong>
                                    <div class="pull-right"><span></span><span><%= number %></span></div><br/>
								</div>
                                  
                                
                                
                                
                                     
                                
                                
								<div class="col-md-12">
								 <hr>
                                    <strong>Costumer Name</strong>
                                    <div class="pull-right"><span></span><span>David James</span></div><br/>
								
                                    <hr>
                                </div>
                                <div class="col-md-12">
                                    <strong>Billing Address</strong><br/>
                                    <div class="pull-left"><span>$</span><span>123 ST, Lincoln NE 68588</span></div><br/>
									<strong>Shipping Address</strong><br/>
									<div class="pull-left"><span>$</span><span>123 ST, Lincoln NE 68588</span></div>
                                    <hr>
                                </div>
                                <a href="UpdateOrderStatus.jsp">
                                <button type="button" class="btn btn-primary btn-lg btn-block">Update Order Status</button>
                                </a>
                        </div>
                        
                    </div>
                    <!--REVIEW ORDER END-->
                </div>
                <div class="col-md-7 col-sm-5 col-xs-11 col-md-pull-5 col-sm-pull-5">
                    <!--SHIPPING METHOD-->
                    <div class="panel panel-default">
                        <div class="panel-heading text-center"><h4>items in the order</h4></div>
                        <div class="panel-body">
                           <table class="table borderless">
    						<thead>
                               
    						</thead>
    						<tbody>
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							<tr>
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
    								<td class="text-right"><a href="ProductDetail.jsp"><button type="button" class="btn btn-danger">View</button></a>
    								<br/><br/><a href="SellerCancelOrder.jsp"><button type="button" class="btn btn-danger">cancel</button></a></td>
    							</tr>
                                <tr>
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
    								<td class="text-center">1</td>
    								<td class="text-right"> $10.99</td>
    								<td class="text-right"><a href="ProductDetail.jsp"><button type="button" class="btn btn-danger">View</button></a>
    								<br/><br/><a href="SellerCancelOrder.jsp"><button type="button" class="btn btn-danger">cancel</button></a></td>
								
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
