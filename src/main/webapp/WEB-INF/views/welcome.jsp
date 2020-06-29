<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>


     <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://localhost/dryouch/resources/css/common.css" rel="stylesheet">
    <link href="http://localhost/dryouch/resources/css/regler.css" rel="stylesheet" type="text/css" > 
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css" > 
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" >
<link href="http://localhost/dryouch/resources/css/stylesss.css" rel="stylesheet" type="text/css" > 

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

  

<nav class="navbar fixed-top navbar-expand-md navbar-new-bottom">
            <div class="navbar-collapse collapse pt-2 pt-md-0" id="navbar1">
   
                  
                <ul class="navbar-nav w-100 justify-content-center px-3">
         
                   <li class="nav-item active">
                        <a class="nav-link" href="${contextPath}/welcome">Accueil</a>
                    </li>
                   
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/voirarticles" >Voir les catalogues</a> 
                    </li>
                 
                    <li class="nav-item">
                    
                        <a class="nav-link" href="${contextPath}/voirpanier?name=${pageContext.request.userPrincipal.name}">Consulter votre Panier</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="http://localhost/dryouch/valider?name=${pageContext.request.userPrincipal.name}">Consulter vos commandes</a>
                    </li>
                    
                    <li class="nav-item">
                    <button type="button"  class="header-btn" onclick="document.forms['logoutForm'].submit()">Déconnexion</button>
                </li>
        </ul>
               
            </div>
        </nav>





<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

 
    </c:if>

</div>

 <section id="home" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				
				<a href="#gallery" class="smoothScroll btn btn-default">Bienvenue ${pageContext.request.userPrincipal.name}</a>			</div>
		</div>
	</div>		
</section>






















<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
