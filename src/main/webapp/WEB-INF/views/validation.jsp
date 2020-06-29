<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link href="http://localhost/dryouch/resources/css/all.css" rel="stylesheet">
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
                   
                    <li class="nav-item">
                        <a class="nav-link" href="http://localhost/dryouch/voirarticles" >Voir les catalogues</a> 
                    </li>
                 
                    <li class="nav-item">
                    
                        <a class="nav-link" href="http://localhost/dryouch/voirpanier?name=${pageContext.request.userPrincipal.name}">Consulter votre Panier</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="http://localhost/dryouch/valider?name=${pageContext.request.userPrincipal.name}" >Consulter vos commandes</a>
                    </li>
                    
                    <li class="nav-item">
                    <button type="button"  class="header-btn" onclick="document.forms['logoutForm'].submit()">Déconnexion</button>
                </li>
        </ul>
               
            </div>
        </nav>





<br>



<c:forEach var="VarCatalogues" items="${list}" >
<c:set var="totale" value="${VarCatalogues.prix }"/>
<c:set var="nombre" value="${VarCatalogues.number }" />
<c:set var="date" value="${VarCatalogues.datecommande }" />
  </c:forEach>


<section class="pricing py-5"   >
  <div class="container" >

   
  
      <div class="col-lg-4" style = '  left:30%;'>
        <div class="card mb-5 mb-lg-0">
          <div class="card-body">
            <h5 class="card-title text-muted text-uppercase text-center">Totale</h5>
            <h6 class="card-price text-center"><c:out value="${totale} DH" /><span class="period">/cash</span></h6>
            <hr>
            <ul class="fa-ul">
           
           
              <li><span class="fa-li"><i class="fas fa-check"></i></span><strong><c:out value="${nombre} " />Produits </strong></li>
            <c:forEach var="VarCatalogues" items="${list}" >
              <li><span class="fa-li"><i class="fas fa-check"></i></span><c:out value="${VarCatalogues.designation }" />................................................</li>
             </c:forEach>
              <li class="text-muted"><span class="fa-li"><i class="fas fa-times"></i></span>Client: Mr. ${pageContext.request.userPrincipal.name},    Le : <c:out value="${date }" /></li>
            </ul>
            <a href="http://localhost/dryouch/valider/terminer?name=${pageContext.request.userPrincipal.name}" class="btn btn-block btn-primary text-uppercase">Payer</a>
          </div>
        </div>
      </div>
      <!-- Pro Tier -->
    

  </div>
</section>

































</body>
</html>