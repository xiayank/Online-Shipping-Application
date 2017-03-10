<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
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
      <li><a><span class="glyphicon glyphicon-user"></span> Hi ${userBean.userName}</a></li>
        <li><a href="ViewOrders.jsp"><span class="glyphicon glyphicon-user"></span> View My Order</a></li>
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
  </div>
</nav>
<!--results -->

    <div class="text-center">
  <h2>Order Detail of Order number: ${ordernumber}</h2>
  
  <br>
      <!--shopping list-->
    <div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:8%">Images</th>
                            <th style="width:8%">Product Name</th>
							<th style="width:8%">Price</th>
							<th style="width:8%">Quantity</th>
                            <th style="width:8%">Estimated delivery date</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%">Check to Cancel</th>
						</tr>
					</thead>
					
					
					<c:forEach var="anOrderItem" items="${orderdetail}">
					<tbody>
					
						<tr>
							<td data-th="Product">
								<div class="row">
									<img src= ${anOrderItem.products.productThumbnail} alt="..." class="img-responsive"/></div>
									
							
							</td>
                            <td data-th="ProductName"> ${anOrderItem.products.productName }</td>
							<td data-th="Price">${anOrderItem.products.price }$ </td>
							<td data-th="Quantity">${anOrderItem.requestQuantity }</td>
                            <td data-th="date" class="text-center">1/1/2017</td>
							<td data-th="Subtotal" class="text-center">${anOrderItem.subTotal}</td>
							
								
								<form action = "CancelOrder" method = "post"  />
						        <input type="hidden" name="orderItemId" value="<c:out value="${anOrderItem.id}" />">
						        <td> <button type="submit" class="btn btn-danger btn-sm">Delete</button>   </td>
						        </form>
								
								
								
<!-- 							<button class="btn btn-danger btn-sm">Delete<i class="fa fa-trash-o"></i></button>						
                                <form>
                            <div class="checkbox">
                            <label><input type="checkbox" value=""></label>
                                 </div>
                                </form> -->
							
						</tr>
						
						
					</tbody>
        </c:forEach>
					<tfoot>
                     

					</tfoot>
				</table>
</div>
   
    
    
</body>
</html>
