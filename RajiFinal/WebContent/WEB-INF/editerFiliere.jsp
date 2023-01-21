<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title> Modification des catégories</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Modification des filieres
  </div>
  <div class="card-body">
      <form action="updateFil" method="post" >
      <div hidden class="form-group"  >
       <label class="control-label">ID Filiere :</label>
       <input type="text" name="id" class="form-control" value="${filiere.idFil}"/>
      </div>
    <div class="form-group">
       <label class="control-label">Nom Filiere :</label>
       <input type="text" name="nom" class="form-control" value="${filiere.nom}"/>   
      </div>  
     
      <div>     
       <button type="submit" class="btn btn-primary">Modifier</button>
      </div>
      </form>     
  </div>
</div>
</div>
</body>
<%@include file="footer.jsp" %>
</html>
