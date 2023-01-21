<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Notes</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Recherche des Notes
  </div>
  <div class="card-body">
           <form action="notes" method="get">
        <label>Mot Clé</label>
        <input type="text" name="motCle" value="${model.motCle}" />
        <button type="submit" class="btn btn-primary">Chercher</button>
      </form> 
      <table class="table table-striped">
        <tr>
          <th>ID</th><th>Nom Etudiant</th><th>Prenom Etudiant</th><th>Enseignant</th><th>Note</th><th>Matiere</th><th>Coef de la Matiere</th><th>Moyenne Matiere</th><th><th>Actions</th>
         </tr>
         <c:forEach items="${model.notes}" var="p">
           <tr>
              <td>${p.idNote }</td>
             
               <td>${p.etudiant.nom }</td>
               <td>${p.etudiant.prenom }</td>
                <td>${p.matiere.user.name }</td>
                 <td>${p.noteFinal }</td>
             
              <td>${p.matiere.nomMatiere }   </td>
              <td>${p.matiere.coef }</td>
                 <td class="table-info">${(p.matiere.coef*p.noteFinal) }</td>
              <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerNot?id=${p.idNote }">Supprimer</a></td>
              <td><a href="editerNot?id=${p.idNote }">Edit</a></td>
                
           </tr>
         </c:forEach>        
      </table>
  </div>
</div>
</div>
</body>
<%@include file="footer.jsp" %>
</html>
    