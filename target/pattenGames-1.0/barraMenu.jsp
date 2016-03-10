<%--
    Document   : barraMenu
    Created on : 06/03/2016, 13:16:34
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Barra de Menu</title>
    </head>
    <body>
        <div id="navarea">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="true" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>             
                    </div>

                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav custom_nav">
                            <li> <span class="icon-user2"> <strong>CLIENTES: </strong></span> </li>
                            <li> <a href="cadastroCliente.jsp"> <span class = "icon-plus">Cadastrar <span class="icon-spinner11">Atualizar </span><span class="icon-trash">Excluir</span></span></a></li>
                            <li> <span class="icon-pacman"> <strong>JOGOS: </strong></span>
                            <li><a href="alugarDevolverJogo.jsp"> <span class="icon-cart">Alugar <span class="icon-enter">Devolver</span></span></a></li>
                            <li><a href="observaJogo.jsp"> <span class="icon-binoculars"> Observar</span></a></li>
                            <li> <a href="cadastroJogo.jsp"> <span class = "icon-plus">Cadastrar <span class="icon-spinner11">Atualizar </span><span class="icon-trash">Excluir</span></span></a></li>
                        </ul>

                    </div><!--/.nav-collapse -->

                </div><!--/.container-fluid -->
            </nav>
        </div>
        <!-- start site main content -->

    </body>
</html>
