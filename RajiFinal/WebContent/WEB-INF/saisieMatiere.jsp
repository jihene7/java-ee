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
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Saisie des matiere
  </div>
  <div class="card-body">
      <form action="saveMatiere" method="post">
      <div class="form-group">
       <label class="control-label">Nom Matiere :</label>
       <input type="text" name="nomMatiere" class="form-control"/>
      </div>
      <div class="form-group">
       <label class="control-label">Coef :</label>
       <input type="text" name="coef" class="form-control"/>
      </div>
      
     
        <div class="form-group">
           <label class="control-label">Filiere :</label>   
       <select name="filiere" class="form-control">
<c:forEach items="${filModel.filieres}" var="cat">

 <option value="${cat.idFil}">${cat.nom}</option>

   </c:forEach>
       </select>
     </div>
     
     
        <div class="form-group">   
           <label class="control-label">Enseignant :</label>
       <select name="user" class="form-control">
<c:forEach items="${UserModel.users}" var="cat">

 <option value="${cat.id}">${cat.name}</option>

   </c:forEach>
       </select>
     </div>
      
      <div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
      </div>
      </form>     
     
  </div>
</div>
</div>
</body>
<%@include file="footer.jsp" %>
</html>
