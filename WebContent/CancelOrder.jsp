<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Cancel Orders</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
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
    
    <!--shopping list-->
    <div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:36%">Product</th>
                            <th style="width:8%">Seller</th>
							<th style="width:8%">Price</th>
							<th style="width:8%">Quantity</th>
                            <th style="width:8%">Estimated delivery date</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%">Check item to cancel</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-4 hidden-xs"><img src="Pics/adidas.jpg" alt="..." class="img-responsive"/></div>
									<div class="col-sm-4">
										<h4 class="nomargin">Adidas Running shoe</h4>
										<p></p>
									</div>
								</div>
							</td>
                            <td data-th="Seller">Adidas</td>
							<td data-th="Price">$199</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="1">
							</td>
                            <td data-th="Subtotal" class="text-center">1/1/2017</td>
							<td data-th="Subtotal" class="text-center">%199</td>
							<td class="actions" data-th="">
								
<!--								<button class="btn btn-danger btn-sm">Delete<i class="fa fa-trash-o"></i></button>								-->
                                <form>
                            <div class="checkbox">
                            <label><input type="checkbox" value=""></label>
                                 </div>
                                </form>
							</td>
						</tr>
					</tbody>
        <tbody>
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-4 hidden-xs"><img src="Pics/adidas.jpg" alt="..." class="img-responsive"/></div>
									<div class="col-sm-4">
										<h4 class="nomargin">Adidas Running shoe</h4>
										<p></p>
									</div>
								</div>
							</td>
                            <td data-th="Seller">Adidas</td>
							<td data-th="Price">$199</td>
							<td data-th="Quantity">
								<input type="number" class="form-control text-center" value="1">
							</td>
                            <td data-th="Subtotal" class="text-center">1/1/2017</td>
							<td data-th="Subtotal" class="text-center">$199</td>
							<td class="actions" data-th="">
								
<!--								<button class="btn btn-danger btn-sm">Delete<i class="fa fa-trash-o"></i></button>								-->
                             <form>
                            <div class="checkbox">
                            <label><input type="checkbox" value=""></label>
                                 </div>
                                </form>
							</td>
						</tr>
					</tbody>
					<tfoot>
                        
						<tr>
							
							<td colspan="5" class="hidden-xs"></td>
							
							<td><a href="CancellationConfirmation.jsp" class="btn btn-danger btn-block">Confirm Cancellation <i class="fa fa-angle-right"></i></a></td>
                            <td><a href="#" class="btn btn-success btn-block">Discard Cancellation <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>
    
    
    </body>
</html>
