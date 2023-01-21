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
Modification des Produits
</div>
<div class="card-body">
<form action="updateMatEns" method="post">
<div hidden class="form-group">
<label class="control-label">ID Matiere :</label>
<input type="text" name="id" class="form-control" value="${matiere.idMat}"/>
</div>
<div class="form-group">
<label class="control-label">Nom Matiere :</label>
<input type="text" name="nomMatiere" class="form-control" value="${matiere.nomMatiere}"/>
</div>
<div class="form-group">
<label class="control-label">Coef :</label>
<input type="text" name="coef" class="form-control" value="${matiere.coef}"/>
</div>
   <div class="form-group">   
       <select name="filiere" class="form-control">
<option value="${matiere.filiere.idFil}" selected>${matiere.filiere.nom}</option>
<c:forEach items="${filModel.filieres}" var="cat">
<c:if test="${cat.idFil != matiere.filiere.idFil}">
 <option value="${cat.idFil}">${cat.nom}</option>
</c:if>
   </c:forEach>
       </select>
     </div>
     <div class="form-group">   
       <select name="user" class="form-control">
<option value="${matiere.user.id}" selected>${matiere.user.name}</option>
<c:forEach items="${UserModel.users}" var="cat">
<c:if test="${cat.id != matiere.user.id}">
 <option value="${cat.id}">${cat.name}</option>
</c:if>
   </c:forEach>
       </select>
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
