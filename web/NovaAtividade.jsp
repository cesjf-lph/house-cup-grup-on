<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Atividade</title>
    </head>
    <body>
        <h1>Nova Atividade</h1>
        <form action="novaatividade.html" method="POST" > 
            <p>Nova Atividade</p>
            <input type="text" name="nome">
            <p>Situação</p>
            <select name="situacao">
                <option value="1">Ativo</option>
                <option value="2">Desativo</option>
            </select>
            <input type="submit" text="Enviar"> 
        </form>
    </body>
</html>
