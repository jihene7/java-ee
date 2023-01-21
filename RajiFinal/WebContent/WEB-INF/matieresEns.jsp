<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="headerEn.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Recherche des Matieres
  </div>
  <div class="card-body">
           <form action="matieresEns" method="get">
        <label>Mot Clé</label>
        <input type="text" name="motCle" value="${model.motCle}" />
        <button type="submit" class="btn btn-primary">Chercher</button>
      </form> 
      <table class="table table-striped">
        <tr>
          <th>ID</th><th>Nom Matiere</th><th>Coef</th><th>Filiere</th><th>Enseignant</th><th>Actions</th>
         </tr>
         <c:forEach items="${model.matieres}" var="p">
           <tr>
              <td>${p.idMat }</td>
              <td>${p.nomMatiere }</td>
              <td>${p.coef }</td>
              <td>${p.filiere.nom }</td>
               <td>${p.user.name }</td>
              <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerMatEns?id=${p.idMat }">Supprimer</a></td>
              <td><a href="editerMatEns?id=${p.idMat }">Edit</a></td>
                
           </tr>
         </c:forEach>        
      </table>
  </div>
</div>
</div>
</body>
<%@include file="footer.jsp" %>
</html>
