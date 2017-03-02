<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>EditProductDetails</title>
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
      <a class="navbar-brand" href="#">Edit Product Detail</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
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
                            <h4>Product Details</h4>
                        </div>
                        <form action="ManageProducts.jsp" method = "get">
                        <div class="panel-body">
						 <div class="col-md-12">
                                    <strong>Product name</strong>
                                    <div class="pull-right"><span><input name = "name" type="text" placeholder="name"></span></div>
                                    <hr>
                                </div>
                               <div class="col-md-12">
                                    <strong>Product category</strong>
                                    <div class="pull-right"><span><input name = "category" type="text" placeholder="category"></span></div>
                                    <hr>
                                </div>
                                <div class="col-md-12">
                                    <strong>Product price</strong>
                                    <div class="pull-right"><span><input name = "price" type="text" placeholder="price"></span></div>
                                    <hr>
                                </div>
								<div class="col-md-12">
                                    <strong>Estimate shipping time</strong>
                                    <div class="pull-right"><span><input name = "time" type="text" placeholder="shipping time"></span></div>
                                    <hr>
                                </div>
								<div class="col-md-12">
                                    <strong>Number of items in stock</strong>
                                    <div class="pull-right"><span><input name = "stocknumber"  type="text" placeholder="numbers"></span></div>
                                    <hr>
                                </div>
								<div class="col-md-12">
                                    <strong>Product description</strong>
                                    <div class="pull-right"><span><input name = "description" type="text" placeholder="description"></span></div>
                                    <hr>
                                </div>
								<div class="col-md-12">
                                    <strong>Costumers Q&A</strong>
                                    <div class="pull-right"><textarea name = "QA"  cols = 30 rows = 5 type="text" placeholder="Q&A"></textarea></div>
                                    
                                </div>
                                <input type="submit" value = "Save" class="btn btn-primary btn-lg btn-block"><br/>
								 <a href="ManageProducts.jsp"><button type="button" class="btn btn-primary btn-lg btn-block">Cancel</button></a>
                                
                        </div>
                        </form>
                    </div>
                    <!--REVIEW ORDER END-->
                </div>
                <div class="col-md-7 col-sm-5 col-xs-11 col-md-pull-5 col-sm-pull-5">
                    <!--SHIPPING METHOD-->
                    <div class="panel panel-default">
                        <div class="panel-heading text-center"><h4>Product Image</h4></div>
                        <div class="panel-body">
                           <table class="table borderless">
    						<thead>
                               
    						</thead>
    						<tbody>
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							<tr>
    								<td class="col-md-3">
    								    <div class="media">
    								         <a class="thumbnail pull-left" href="#"> <img class="media-object" src="Pics/adidas.jpg" style="width: 630px; height: 540px;"> </a>
    								         <div class="media-body">
    								            
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
