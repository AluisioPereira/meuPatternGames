<%-- 
    Document   : alugarDevolverJogo
    Created on : 06/03/2016, 19:48:32
    Author     : Aluísio
--%>

<%@page import="br.edu.ifpb.pattengames.contole.ControleDatas"%>
<%@page import="br.edu.ifpb.pattengames.entidades.Jogo"%>
<%@page import="br.edu.ifpb.pattengames.model.BuscaJogoBo"%>
<%@page import="br.edu.ifpb.pattengames.model.BuscaClienteBo"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpb.pattengames.entidades.Cliente"%>
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
        <!--<script src="js/tabela.js"></script>-->
        <script src="js/tabela_1.js"></script>
        <script src="js/tabela_2.js"></script>
        <script src="js/jquery.js"></script>
        <script  src="js/jquery.dataTables.js"></script> 
        
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
            <section class="seçãoDir" style="float: right; display: ;">
             <table class="table table-bordered table-hover table-selectable" id="tb">
                     <thead>
                <tr class="alert-info text-center">
                    <th id="tableHeadId" class="text-center">Código</th>
                    <th id="tableHeadNome"class="text-center">Nome</th>
                    <th id=""class="text-center">Status</th>
                    <th>Remover</th>
                    <th>Editar</th>
                </tr>
                </thead>
                <tbody id="usersTable" class="searchable">
                    <%  BuscaJogoBo busca = new BuscaJogoBo();
                        List<Jogo> allGame = busca.buscarTodos();
                                     
                        for(Jogo j: allGame){%>
                <tr >
                    <td ><%=j.getId()%></td>
                    <td ><%=j.getNome()%></td>
                    <td ><%=j.getEstado().toString()%></td>
                    
                   
                    
                     
                    <td class="text-center"><button id="salvar" name="salvar" class="btn btn-success" onclick="document.getElementById('client').style.display='block';">Busc Client</button></td>
                    <td class="text-center"><button id="salvar" name="salvar" class="btn btn-success" onclick="document.getElementById('novo').style.display='block';">Devolver</button></td>

                        
                    
                </tr>
                <%}%>
                </tbody>

            </table>
                </section >
            </div>
        </div>
                
        
<div class="panel panel-default">

            <div class="panel-body" id="client">
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

               <section >         <!-- Table Usuários-->
            <table class="table table-bordered table-hover table-selectable" id="tb1">
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
                                <%  
                                    
                                    BuscaClienteBo busca2 = new BuscaClienteBo();
                                    List<Cliente> allUser = busca2.buscarTodos();
                                     
                        for(Cliente c: allUser){%>
                <tr >
                    <td ><%=c.getId()%></td>
                    <td ><%=c.getNome()%></td>
                    <td ><%=c.getCPF()%></td>
                    
                     
                    <td><button id="salvar" name="salvar" class="btn btn-success" onclick="document.getElementById('aluguel').style.display='block';">Prosseguir</button></td>
                    <td><button id="salvar" name="salvar" class="btn btn-success" onclick="document.getElementById('client').style.display='none';">Cancelar</button></td>

                        
                    
                </tr>
                <%}%>
                </tbody>

            </table>
               </section>


            </div>

        </div> <!-- fim painel -->   
        <section class="seçãoDir" style="float: right; display: ;" id="aluguel">
            
            <form class="form-horizontal" action="ServletCadastroCliente" >
                <fieldset>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="cpf"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">Cod Jogo</span>
                                <input  id="codJogo" name="cpf" class="form-control" placeholder="Ex.: 10028243561" type="text">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 control-label" for="nome"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">Cod Cliente</span>
                                <input id="codCliente" name="nomec" class="form-control" placeholder="Ex.: João Paulo da Silva" type="text">
                            </div>
                        </div>
                    </div>
                    <!-- Prepended text-->
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="email"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">Jogo</span>
                                <input id="nomeJogo1" name="email" class="form-control" placeholder="Ex.: seunome@dominio.com" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="email"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">Data Loc</span>
                                <%
                                    ControleDatas con = new ControleDatas();
                                %>
                                <input id="emailc" name="email" value="<%=con.dataCadastro()%>" class="form-control" placeholder="Ex.: seunome@dominio.com" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="email"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">Data Devol</span>
                                <input id="emailc" value="<%=con.dataDevolucao()%>" name="" class="form-control" placeholder="Ex.: seunome@dominio.com" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="email"></label>
                        <div class="col-md-5">
                            <div class="input-group">
                                <span class="input-group-addon">Tipo</span>
                                <input id="emailc" value="<%=con.tipoLocacao()%>" name="email" class="form-control" placeholder="Ex.: seunome@dominio.com" type="email">
                            </div>
                        </div>
                    </div>

                    <!-- Button (Double) -->
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="salvar"></label>
                        <div class="col-md-4">
                            <input type="button" id="cancelar"  class="btn btn-success" value="Cancelar" onclick="document.getElementById('aluguel').style.display='none';">
                            <button id="salvar" name="salvar" class="btn btn-success">Cadastrar</button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </section>

       


        <%@ include file="rodape.jsp" %>




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
