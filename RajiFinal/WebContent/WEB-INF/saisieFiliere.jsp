<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Saisie Catégorie</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Saisie des Filieres
  </div>
  <div class="card-body">
      <form action="saveFiliere" method="post">
      <div class="form-group">
       <label class="control-label">Nom Filiere :</label>
       <input type="text" name="nom" class="form-control"/>
      </div>   
     
      <div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
      </div>
      </form>     
  </div>
</div>
</div>
</body>

</html>
<%@include file="footer.jsp" %>
