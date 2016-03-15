<%-- 
    Document   : Home
    Created on : 05/03/2016, 15:14:26
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pattern Games</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- for fontawesome icon css file -->
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <!-- for content animate css file -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- google fonts  -->
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'> 
        <!-- slick slider css file -->
        <link href="css/slick.css" rel="stylesheet">     
        <!-- <link href="css/theme-red.css" rel="stylesheet"> -->  
        <link href="css/theme.css" rel="stylesheet">	 
        <!-- main site css file -->    
        <link href="style.css" rel="stylesheet" title="default">
        <link href="contraste.css" rel=" alternate stylesheet" title="contraste">
        <link href="icomoon/style.css" rel="stylesheet" title="default">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HomePagina</title>
    </head>
    <body style="padding: 1% 8% 4% 8%">

        <header style="text-align: center">
            <%@ include file="cabecalho.jsp"%>
        </header>
        <div class="menu">
            <%@ include file="barraMenu.jsp"%>
        </div>
        <%@include file="Jogos.jsp" %>

        <hr>
        <hr>
        <br>
        <%@ include file="rodape.jsp" %>
        <script type="text/javascript" src="js/acessibilidade.js"></script>

        <!-- jQuery google CDN Library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
        <!-- For content animatin  -->
        <script src="js/wow.min.js"></script>
        <!-- bootstrap js file -->
        <script src="js/bootstrap.min.js"></script> 
        <!-- slick slider js file -->
        <script src="js/slick.min.js"></script> 
        <!-- custom js file include -->
        <script src="js/custom.js"></script> 
        <!-- contraste- js file-->
        <script src="js/file.js"></script>
    </body>
</html>
