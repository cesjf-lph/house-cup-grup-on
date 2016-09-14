<%-- 
    Document   : NovoAluno
    Created on : 16/08/2016, 21:17:08
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Aluno</title>
    </head>
    <body>
        <h1>Novo Aluno</h1>
        <form action="NovoAluno.html" method="POST"  >
            <p>Nome:</p>
            <input type="text" name="nome">
            <p>Grupo:</p>
            <select name="grupo">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <input type="submit" text="Enviar"> 
        </form>
    </body>
</html>
