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
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <script src="js/ajax.js"></script>
        <script src="js/tabela.js"></script>
        <script src="js/tabela_1.js"></script>
        <script src="js/jquery.js"></script>
        <script  src="js/jquery.dataTables.js"></script>     

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




        <button id="salvar" name="salvar" class="btn btn-success" onclick="document.getElementById('novo').style.display='block';">Novo</button>
        <button id="salvar" name="salvar" class="btn btn-success" onclick="document.getElementById('editar').style.display='block';">Editar</button>
        <button id="salvar" name="salvar" class="btn btn-success" onclick="document.getElementById('excluir').style.display='block';">Excluir</button>

        <section class="seçãoDir" style="float: right; display: none;" id="novo">
            <form class="form-horizontal" action="ServletCadastroCliente" >
                <fieldset>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="cpf"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">CPF</span>
                                <input  pattern="\d{11}" id="cpfc" name="cpfc" class="form-control" placeholder="Ex.: 10028243561" type="text">
                            </div>
                            <p class="help-block">Informe o CPF do cliente</p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="nome"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">Nome</span>
                                <input id="nomec" name="nomec" class="form-control" placeholder="Ex.: João Paulo da Silva" type="text">
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
                                <input id="emailc" name="emailc" class="form-control" placeholder="Ex.: seunome@dominio.com" type="email">
                            </div>
                            <p class="help-block">Informe o E-mail do cliente</p>
                        </div>
                    </div>

                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="salvar"></label>
                        <div class="col-md-4">
                            <input type="button" id="cancelar"  class="btn btn-success" value="Cancelar" onclick="document.getElementById('novo').style.display='none';">
                            <button id="salvar" name="salvar" class="btn btn-success">Cadastrar</button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </section>
        

        <section class="seçãoDir" style="float: right; display: none;" id="editar">
            <form class="form-horizontal" action="atualizarcliente" method="post">
                <fieldset>
                    
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
                            <input type="button" id="Cancelar"  class="btn btn-success" value="Cancelar" onclick="document.getElementById('editar').style.display='none';">
                            <button id="salvar" name="salvar" class="btn btn-success">Salvar</button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </section>
        
        <section class="seçãoDir" style="float: right; display: none;" id="excluir">
            <form class="form-horizontal" action="excluir" method="post">
                <input type="text" id="delete" name="delete">
                <h4> Tem certeza que deseja EXCLUIR o(s) registro(s) selecionado(s)?</h4>
                <div id="grupo">
                <input type="button" id="cancelar"  class="btn btn-success" value="Não" onclick="document.getElementById('excluir').style.display='none';">
                <button id="salvar" name="salvar" class="btn btn-success">Sim</button>
                </div>
            </form>
        </section>


        <h4>II - Editar ou  Excluir cliente</h4>

        <div class="panel panel-default" id="">

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

               <section>         <!-- Table Usuários-->
            <table class="table table-bordered table-hover table-selectable" id="tb">
                <thead>
                <tr class="alert-info text-center">
                    <th id="tableHeadId" class="text-center">CPF</th>
                    <th id="tableHeadNome"class="text-center">Nome</th>
                    <th id="tableHeadEmail" class="text-center">E-mail</th> 
                    <th>Remover</th>
                    <th>Editar</th>
                </tr>
                </thead>
                <tbody id="usersTable" class="searchable">
                                <%  BuscaClienteBo busca = new BuscaClienteBo();
                                    List<Cliente> allUser = busca.buscarTodos();
                                     
                        for(Cliente c: allUser){%>
                <tr >
                    <td ><%=c.getCPF()%></td>
                    <td ><%=c.getNome()%></td>
                    <td ><%=c.getEmail()%></td>
                    
                     
                    <td class="text-center"><button type="button" class='btn btn-warning glyphicon glyphicon-pencil' onclick="document.getElementById('editar').style.display='block';"></button></td>
                    <td class="text-center"><button class='btn btn-danger glyphicon glyphicon-trash' onclick="document.getElementById('excluir').style.display='block';"></button></td>

                        
                    
                </tr>
                <%}%>
                </tbody>

            </table>
               </section>


            </div>

        </div> <!-- fim painel -->

        <%@ include file="rodape.jsp" %>

        <script type="text/javascript" src="js/acessibilidade.js"></script>

        <!-- jQuery google CDN Library -->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>--> 
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

        </script>




    </body>
</html>
