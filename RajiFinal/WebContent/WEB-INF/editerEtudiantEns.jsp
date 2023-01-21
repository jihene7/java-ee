<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title> Modification des étudiants</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="headerEn.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Modification des étudiants
  </div>
  <div class="card-body">
      <form action="updateEtudEns" method="post" >
      <div hidden class="form-group"  >
       <label class="control-label">ID Etudiantt :</label>
       <input type="text" name="id" class="form-control" value="${etudiant.idEtud}"/>
      </div>
      <div class="form-group">
       <label class="control-label">Nom Etudiant :</label>
       <input type="text" name="nom" class="form-control" value="${etudiant.nom}"/>   
      </div>   
       <div class="form-group">
       <label class="control-label">Prénom Etudiant :</label>
       <input type="text" name="prenom" class="form-control" value="${etudiant.prenom}"/>   
      </div> 
       <div class="form-group">
       <label class="control-label">Email  :</label>
       <input type="text" name="email" class="form-control" value="${etudiant.email}"/>   
      </div> 
       <div class="form-group">
       <label class="control-label">Contact :</label>
       <input type="text" name="contact" class="form-control" value="${etudiant.contact}"/>   
      </div> 
       <div class="form-group">
       <label class="control-label">Gender :</label>
       <input type="text" name="gender" class="form-control" value="${etudiant.gender}"/>   
      </div>     
      <div class="form-group">
       <label class="control-label">Date Catégorie :  </label>   
          <fmt:formatDate pattern="yyyy-MM-dd" value="${etudiant.dateNaissance}" var="formatDate" />
           <input  type="date" name="dateNaissance" class="form-control"  value="${formatDate}"></input> 
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