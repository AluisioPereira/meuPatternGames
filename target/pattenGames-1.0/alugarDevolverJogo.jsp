<%-- 
    Document   : alugarDevolverJogo
    Created on : 06/03/2016, 19:48:32
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Site de Notícias</title>
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

        <title>Aluga, Devolver Jogos</title>
    </head>
    <body style="padding: 1% 8% 4% 8%">
        <header style="text-align: center">
            <%@ include file="cabecalho.jsp"%>
        </header>
        <div class="menu">
            <%@ include file="barraMenu.jsp"%>
        </div>

        <form class="form-horizontal">
            <fieldset>

                <form class="form-horizontal" action="">
                    
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Emprestar jogo</legend>

                        <!-- Prepended text-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="cpf"></label>
                            <div class="col-md-8">
                                <div class="input-group">
                                    <span class="input-group-addon">CPF</span>
                                    <input id="cpf" name="cpf" class="form-control" placeholder="Ex.: 19294954543" type="text">
                                </div>
                                <p class="help-block">Informe o CPF do cliente</p>
                            </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="cpf"></label>
                            <div class="col-md-4">
                                <button id="cpf" name="cpf" class="btn btn-primary">Pesquise</button>
                            </div>
                        </div>

                    </fieldset>
                </form>
                <form class="form-horizontal">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Pesquise jogo</legend>

                        <!-- Prepended text-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="jogo"></label>
                            <div class="col-md-8">
                                <div class="input-group">
                                    <span class="input-group-addon">Jogo</span>
                                    <input id="jogo" name="jogo" class="form-control" placeholder="Ex.: super mário" type="text">
                                </div>
                                <p class="help-block">Informe o nome do jogo</p>
                            </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="cpf"></label>
                            <div class="col-md-4">
                                <button id="cpf" name="cpf" class="btn btn-primary">Pesquise</button>
                            </div>
                        </div>

                    </fieldset>
                </form>
            </fieldset>
        </form>





        <h1>Alugar, Devolver Jogos!</h1>



        <%@ include file="rodape.jsp" %>




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
