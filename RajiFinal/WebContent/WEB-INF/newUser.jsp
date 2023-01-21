<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <html>

        <head>
     </head>

        <body>

            <header>
              <%@include file="header.jsp" %>     
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                       
                           
                            <form action="insert" method="post">
                     

                        <caption>
                            <h2>
                               
                               
                                    Add New User
                              
                            </h2>
                        </caption>

                       
			
				
		

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						 class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						 class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Role</label> <input type="text"
						 class="form-control"
						name="role">
				</fieldset>
				
		
					<fieldset class="form-group">
					<label>Pwd</label> <input type="text"
						 class="form-control"
						name="pwd">
				</fieldset>
                         
                         

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
<%@include file="footer.jsp" %>
        </html>