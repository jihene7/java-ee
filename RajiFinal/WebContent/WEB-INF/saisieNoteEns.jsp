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
    Saisie des note
  </div>
  <div class="card-body">
      <form action="saveNoteEns" method="post">
      <div class="form-group">
       <label class="control-label">Note :</label>
       <input type="text" name="noteFinal" class="form-control"/>
      </div>
     
     
        <div class="form-group">   
       <select name="matiere" class="form-control">
<c:forEach items="${MatModel.matieres}" var="cat">

 <option value="${cat.idMat}">${cat.nomMatiere}</option>

   </c:forEach>
       </select>
     </div>
     
     
        <div class="form-group">   
       <select name="etudiant" class="form-control">
<c:forEach items="${EtudModel.etudiants}" var="cat">

 <option value="${cat.idEtud}">${cat.nom} ${cat.prenom}</option>

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