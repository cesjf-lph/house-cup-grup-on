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
            .tabela{


            }
            tr{

            }
            th {
                /* border: 1px solid black; */
                text-align: left;
                padding-right: 35px;
            }
            .tabela td {
                border: 5px solid white;
                padding: 10px;
                background: aquamarine;}

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
                <br>
                </tr>
                <tr><td><hr></td><td><hr></td></tr>
                <tr>
                    <TD></TD>
                    <td>
                        <h2>Históricos</h2>
                        <br>
                        <table class="tabela">

                            <%--<tr style="border-bottom: 1px solid black;">
                                <td>
                                    <select name="aluno" id="FiltroAluno">
                                        <option value="0">Todos</option>
                                        <c:forEach items="${alunos}" var="aluno">
                                            <option value="${aluno.codAluno}"><c:out value="${aluno.nomeAluno}" /></option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>
                                    <select id="FiltroData">
                                        <option value="1">1º semestre</option>
                                        <option value="2">2º semestre</option>
                                    </select>
                                </td>
                                    <td>
                                    <select id="FiltroData">
                                        <option value="1">Grupo 1</option>
                                        <option value="2">Grupo 2</option>
                                         <option value="1">Grupo 3</option>
                                        <option value="2">Grupo 4</option>
                                    </select>
                                </td>
                                <td>
                                    <form action="historico.html" method="POST"  >
                                        <input type="submit" text="Filtrar"> 
                                    </form>
                                </td>
                            </tr>     --%>
                            <tr><th>Aluno</th><th>Grupo</th><th>Professor</th><th>Ponto</th><th>Descricao</th><th>Data</th></tr>
                                    <c:forEach var="historico" items="${historicos}">
                                <tr>
                                    <td><span>${historico.aluno.codAluno} - ${historico.aluno.nomeAluno}</span></td>
                                    <td><span>${historico.aluno.codGrupo}</span></td>
                                    <td>    <span>${historico.professor.codProfessor} - ${historico.professor.nomeProfessor} </span></td>
                                    <td>    <span>${historico.ponto}</span></td>
                                    <td>    <span>${historico.descricao}</span></td>
                                    <td>   <span>${historico.data}</span></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
