<%-- 
    Document   : atualizarCliente
    Created on : 10/03/2016, 16:36:18
    Author     : Aluísio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar cliente</title>
    </head>
    <body>

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
                <button id="voltar" name="voltar" class="btn btn-success">Cancelar</button>
                <button id="salvar" name="salvar" class="btn btn-warning">Salvar</button>                
            </div>
        </div>



        !--<button id="btnTornarAdmin" class="btn btn-warning glyphicon glyphicon-pencil" disabled></button>-->
        <a href="admLivro"><button id="btnAddLivro" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus-sign"></span> Adicionar</button></a>
        <!--<button id="btnDesabilitarAdmin" type="button" class="btn btn-danger" disabled><span class="glyphicon glyphicon-trash"></span> Desabilitar</button>-->

        <!--antigos e pequenos -->
        <!--<button class="btn btn-info glyphicon glyphicon-plus"></button>-->
        <!--<button id="btn-deletar" class="btn btn-danger glyphicon glyphicon-trash" disabled></button>-->



    </body>
</html>
