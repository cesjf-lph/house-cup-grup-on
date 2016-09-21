<%-- 
    Document   : ListaGrupo
    Created on : 20/09/2016, 20:19:37
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Grupo</title>
    </head>
    <body>
        <h1>Lista Grupo</h1>
        <form action="listagrupo.html" method="POST"  >
            <table>
                <tr> 
                    <td>
                        <select name="kaka" id="FiltroGrupo">
                            <option value="9">Todos</option>
                            <c:forEach items="${grupos}" var="grupo">
                                <option value="${grupo}"><c:out value="${grupo}" /></option>
                            </c:forEach>
                        </select></td>
                    <td>
                        <input type="submit" text="Filtrar"> </td>
                </tr>
            </table>                    </form>

        <br>

        <ul>
            <c:forEach var="aluno" items="${alunos}">
                <li style="margin:20px;">
                    <span>${aluno.codAluno} - ${aluno.nomeAluno}</span>  <span style="background-color:green;color:white;padding:10px;">Grupo: ${aluno.codGrupo}</span>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
