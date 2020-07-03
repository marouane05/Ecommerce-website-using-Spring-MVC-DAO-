<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <c:set var="contextPath" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="http://localhost/dryouch/resources/css/bootstrap.min.css" rel="stylesheet">
 <link href="http://localhost/dryouch/resources/css/common.css" rel="stylesheet">
 <link href="http://localhost/dryouch/resources/css/regler.css" rel="stylesheet" type="text/css" > 
 <link href="http://localhost/dryouch/resources/css/bootstrap.css" rel="stylesheet" type="text/css" > 
 <link href="http://localhost/dryouch/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
 <link href="http://localhost/dryouch/resources/css/stylesss.css" rel="stylesheet" type="text/css" > 
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
 <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


</head>
<body>

<nav class="navbar fixed-top navbar-expand-md navbar-new-bottom">
            <div class="navbar-collapse collapse pt-2 pt-md-0" id="navbar1">
   
                  
                  <ul class="navbar-nav w-100 justify-content-center px-3">
         
                   <li class="nav-item active">
                        <a class="nav-link" href="http://localhost/dryouch/welcome">Accueil</a>
                    </li>
                     <li class="nav-item active">
                        <a class="nav-link" href="http://localhost/dryouch/ajout">Ajouter Produit</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="http://localhost/dryouch/produit/supprimer">Supprimer Produit</a>
                    </li>
                   
                    <li class="nav-item">
                    <button type="button"  class="header-btn" onclick="document.forms['logoutForm'].submit()">Déconnexion</button>
                </li>
              </ul>
                
            </div>
        </nav>


<c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="http://localhost/dryouch/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

 
    </c:if>







<br>

<table class="table">
<thead>
    <tr>
      <th scope="col">code</th>
      <th scope="col">Titre</th>
      <th scope="col">Prix</th>
      <th scope="col">Stock</th>
      
            <th scope="col">Action</th>
    </tr>
  </thead>
  
<c:forEach var="VarCatalogues" items="${list}" >
  
  <tbody>
    <tr>
      <th scope="row"><a href="http://localhost/dryouch/detailCatalogue?ref=${VarCatalogues.codearticle }" ><c:out value="${VarCatalogues.codearticle }" /></a></th>
      <td><c:out value="${VarCatalogues.designation }" /></td>
      <td><c:out value="${VarCatalogues.prix } DH" /></td>
      <td><c:out value="${VarCatalogues.stock }" /></td>
      
      <td> <a class="btn btn-danger btn-xs" href="http://localhost/dryouch/produit/supprimer/bycat?ref=${VarCatalogues.codearticle }" ><span class="glyphicon glyphicon-remove"></span>Supprimer</a>
      </td>
    </tr>
    </tbody>
    </c:forEach>
</table>














</body>
</html>