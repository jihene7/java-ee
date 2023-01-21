<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste des catégories</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
   Liste des filieres
  </div>
  <div class="card-body">
       
      <table class="table table-striped">
        <tr>
          <th>ID</th><th>Nom</th><th>Suppression<th>Edition</th>
         </tr>
         <c:forEach items="${model.filieres}" var="cat">
           <tr>   
              <td>${cat.idFil }</td>
              <td>${cat.nom }</td>
            
              <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerFil?id=${cat.idFil }">Supprimer</a></td>
              <td><a href="editerFil?id=${cat.idFil }">Edit</a></td>
           </tr>
         </c:forEach>        
      </table>
  </div>
</div>
</div>
</body>
<%@include file="footer.jsp" %>
</html>
