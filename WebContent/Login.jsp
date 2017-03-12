<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  </style>
</head>
<body>




  <!-- Modal -->

    
      <!-- Modal content-->
      <div class="container" style="width:40%">
        <div class="modal-header" style="padding:10px 50px;">
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        <!-- login form -->
          <form role="form" method = "post" action = "Login">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" name="userName" value="${cookie.rememberCookie.value}">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="text" class="form-control" name="psw" placeholder="Enter password">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" name ="checkbox" value="remember" checked>Remember me</label>
            </div>
              <!-- <button type="submit" class="btn btn-success btn-block">
              <span class="glyphicon glyphicon-off"></span> Login</button> -->
              <input type = "submit" class="btn btn-success btn-block" value = "Login">
          </form>
        </div>
        <div class="modal-footer">
          
          <p>Not a member? <a href="Register.jsp">Sign Up</a></p>
          <p>Forgot <a href="#">Password?</a></p>
        </div>
      </div>


 

</body>
</html>
