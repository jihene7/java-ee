<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<style>
body {
  background-image: url('https://c0.wallpaperflare.com/preview/893/216/985/accounting-analyzing-opposite-applicant.jpg');
   background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

</style>
<body>
<br>
<br>
<br>
    <div class="container">
<div class="card">
  <div class="card-header">
  Login
  </div>
  <div class="card-body">
        <form action="login" method="post">
            <label for="email">Email:</label>
            <input name="email" class="form-control" />
            <br><br>
            <label for="pwd">Password:</label>
            <input type="password" name="pwd" class="form-control" />
            <br>${message}
            <br><br>           
            <button type="submit" class="btn btn-secondary">Login</button>
        </form>
         </div>
    </div>
     </div>
      </div>
</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         
                pwd: "required",
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                 
                pwd: "Please enter password"
            }
        });
 
    });
</script>
</html>