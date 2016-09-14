<%-- 
    Document   : ListaAlunos
    Created on : 26/08/2016, 22:18:04
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Alunos</title>
    </head>
    <body>
        <h1>Lista Alunos</h1>
        
           <ul>
                    
                <c:forEach var="aluno" items="${alunos}">
                            <li style="margin-bottom:10px;font-family: arial; ">
                                <span>${aluno.codAluno}</span>
                                <span style="background:lightgray;padding:5px">${aluno.nomeAluno}</span>
                                <span style="background:lightgreen;padding:5px">${aluno.codGrupo}</span>
                            </li>
                        </c:forEach>
                    </ul>
    </body>
</html>
