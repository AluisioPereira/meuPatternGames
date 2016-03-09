<%-- 
    Document   : cadastroCliente
    Created on : 06/03/2016, 18:44:56
    Author     : Aluísio
--%>

<%@page import="br.edu.ifpb.pattengames.model.BuscaClienteBo"%>
<%@page import="br.edu.ifpb.pattengames.entidades.Cliente"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
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
        <title>cadastro cliente</title>



    </head>
    <body style="padding: 1% 8% 4% 8%">
        <header style="text-align: center">
            <%@ include file="cabecalho.jsp"%>
        </header>
        <div class="menu">
            <%@ include file="barraMenu.jsp"%>
        </div>














        <section class="seçãoDir" style="float: right">
            <form class="form-horizontal" action="ServletCadastroCliente">
                <fieldset>
                    <div id="botoesAcoesUsarios" class="container-fluid panel-footer">
                        <h4>Ambiente cliente</h4>
                    </div>                    
                    <h4>I - Cadastrar novo cliente</h4>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="cpf"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">CPF</span>
                                <input  pattern="\d{11}" id="cpf" name="cpf" class="form-control" placeholder="Ex.: 10028243561" type="text">
                            </div>
                            <p class="help-block">Informe o CPF do cliente</p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="nome"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">Nome</span>
                                <input id="nome" name="nome" class="form-control" placeholder="Ex.: João Paulo da Silva" type="text">
                            </div>
                            <p class="help-block">Informe o nome do cliente</p>
                        </div>
                    </div>
                    <!-- Prepended text-->
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="email"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">E-mail</span>
                                <input id="email" name="email" class="form-control" placeholder="Ex.: seunome@dominio.com" type="email">
                            </div>
                            <p class="help-block">Informe o E-mail do cliente</p>
                        </div>
                    </div>

                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="salvar"></label>
                        <div class="col-md-4">
                            <button id="salvar" name="salvar" class="btn btn-success">Cadastrar</button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </section>


        <h4>II - Editar ou  Excluir cliente</h4>

        <div class="panel panel-default">

            <div class="panel-body">
                <form class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-offset-10 control-label" for="prependedtext"></label>
                            <div class="col-md-6">
                                <div class="input-group">
                                    <span class="input-group-addon">Pesquise</span>
                                    <input id="filter" name="pesquise" class="form-control" placeholder="Ex.: nome do cliente" type="text">
                                </div>
                                <p class="help-block">Pesquise por informações do cliente</p>
                            </div>
                        </div>



                    </fieldset>
                </form>
            </div>
            <!-- Table Usuários-->
            <table class="table table-bordered table-hover table-selectable">
                <thead>
                    <tr class="alert-info text-center">
                        <th id="tableHeadId" class="text-center">ID</th>
                        <th id="tableHeadId" class="text-center">CPF</th>
                        <th id="tableHeadNome"class="text-center">Nome</th>
                        <th id="tableHeadEmail" class="text-center">E-mail</th> 
                    </tr>
                </thead>
                <tbody id="usersTable" class="searchable">
                    <%  BuscaClienteBo busca = new BuscaClienteBo();
                        List<Cliente> allUser = busca.buscarTodos();
                        for (Cliente u : allUser) {
                            out.print("<tr>");
                            out.print("<th class=\"text-center\" \"id\">" + u.getId() + "</th>");
                            out.print("<th class=\"text-center\" \"id\">" + u.getCPF() + "</th>");
                            out.print("<th>" + u.getNome() + "</th>");
                            out.print("<th class=\"text-center\">" + u.getEmail() + "</th>");
                            out.print("</tr>");
                        }
                    %>
                <div id="botoesAcoesUsarios" class="container-fluid panel-footer">

                    <button id="btnTornarAdmin" class="btn btn-warning glyphicon glyphicon-pencil" disabled> Editar</button>
                    <button id="btn-deletar" class="btn btn-danger glyphicon glyphicon-trash"> Excluir</button>
                </div>
                </tbody>
            </table>



            

        </div> <!-- fim painel -->






























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

        <script type="text/javascript">
            //função que faz o filtro digitando no formulário de busca dos usuários
            $(document).ready(function () {
                (function ($) {
                    $('#filter').keyup(function () {
                        var rex = new RegExp($(this).val(), 'i');
                        $('.searchable tr').hide();
                        $('.searchable tr').filter(function () {
                            return rex.test($(this).text());
                        }).show();
                    });
                }(jQuery));
            });
            //ações nos cliques dos botões de habilitar e desabilitar
            $("#btnTornarAdmin").click(function () {
                var idUsuario = $('.table-selectable > #usersTable > tr.active').find('th:first-child').text();
                changeToAdmin(idUsuario, "true");
            });

            $("#btnDesabilitarAdmin").click(function () {
                var idUsuario = $('.table-selectable > #usersTable > tr.active').find('th:first-child').text();
                changeToAdmin(idUsuario, "false");
            });
            //chama servlet que muda Status de Admin
            function changeToAdmin(id, habilitar) {
                $.ajax({
                    url: "ConfigurarUsuarioAdmin",
                    type: "POST",
                    data: {id: id, habilitar: habilitar},
                    success: function (data) {
                        location.reload();
                    }
            }
            );


        </script>




    </body>
</html>
