<%-- 
    Document   : Cliente
    Created on : 01/05/2017, 11:52:41
    Author     : Jose Junio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro Cliente</h1>
        <form method="post" action="CadastrarClienteServlet">
            Nome:<input type="text" name="nome"/><br/>
            CPF:<input type="text" name="cpf"/><br/>
            E-mail:<input type="text" name="email"/><br/>
            Data nascimento:<input type="text" name="dataNasc"/><br/>
            <input type="submit" value="cadastrar"/><input type="reset" value="limpar campos"/>
        </form>
    </body>
</html>
