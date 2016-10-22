<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        
        <hr>    
        
             <ul>
                    
                <c:forEach var="atividade" items="${atividades}">
                            <li style="margin-bottom:10px;font-family: arial; ">
                                <span style="background:lightgray;padding:5px">${atividade.nomeAtividade}</span>
                                <span style="background:lightgreen;padding:5px">${atividade.sitAtividade}</span>
                            </li>
                        </c:forEach>
                    </ul>
        
        
    </body>
</html>
