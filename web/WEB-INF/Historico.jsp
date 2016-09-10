<%-- 
    Document   : Historico
    Created on : 09/09/2016, 21:48:56
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historico</title>
        <style>
            .lista{
                margin-right: 30px;
                /* margin-bottom: 10px; */
                background-color: #457355;
                color: white;
                padding: 5px;
            }
            li{
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Historico</h1>
        <form action="historico.html" method=post>
            <table>
                <tr>
                    <td>
                        <select name="aluno">
                            <c:forEach items="${alunos}" var="aluno">
                                <option value="${aluno.codAluno}"><c:out value="${aluno.nomeAluno}" /></option>
                            </c:forEach>
                        </select> 
                    </td>
                    <td>
                        <select name="professor">
                            <c:forEach items="${professores}" var="professor">
                                <option value="${professor.codProfessor}"><c:out value="${professor.nomeProfessor}" /></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Descricao:</td>
                    <td><textarea name="txtDescricao" cols="40" rows="5"></textarea></td>
                </tr>
                <tr>
                    <td>Nota:</td>
                    <td><input type="text" name="txtNota"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
                <tr><td></td><td><hr></td></tr>
                <tr>
                    <TD></TD>
                    <td>

                        <c:forEach var="historico" items="${historicos}">
                    <li class="lista" style="margin-bottom:10px;font-family: arial; ">
                        <span>${historico.codAluno}</span>
                        <span>${historico.codProfessor}</span>
                        <span>${historico.ponto}</span>
                        <span>${historico.descricao}</span>
                        <span>${historico.data}</span>
                    </li>
                </c:forEach>
                </td>
                </tr>
            </table>
        </form>
    </body>
</html>
