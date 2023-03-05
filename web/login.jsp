<%-- 
    Document   : login
    Created on : Jan 31, 2023, 9:10:22 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE <HTML UTF-8>
<html>
  <head>
    <link rel="stylesheet" href="css/login.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

  </head>
  
  <body>
  <div class="login-page">
    <div class="form">
      <form class="register-form">
        <input type="text" placeholder="name"/>
        <input type="password" placeholder="password"/>
        <input type="text" placeholder="email address"/>
        <button>create</button>
        <p class="message">Remember password? <a href="#">Sign In</a></p>
      </form>
      <form class="login-form" action="LoginController" method="post">
          <p class="text-danger">${mess}</p>
        <input name="email" type="text" placeholder="email"/>
        <input name="password" type="password" placeholder="password"/>
        <button type="submit" >login</button>
        <p class="message">Forgot password? <a href="#">Re-pass</a></p>
      </form>
    </div>
  </div>
  </body>
  <script language="javascript" src="js/login.js"></script>
</html>

