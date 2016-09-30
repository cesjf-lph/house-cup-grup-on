<%-- 
    Document   : ListaSemestre
    Created on : 30/09/2016, 15:27:45
    Author     : Marcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Semestre</title>
    </head>
    <body>
        <h1>Lista Semestre</h1>
        <br>

        <form action="listasemestre.html" method="POST"  >
            <span>Semestre: </span>
            <select name="semestre">
                <option value="1">1</option>
                <option value="2">2</option>
            </select> 
            <span>Ano: </span>
            <select name="ano">
                <option value="2016">2016</option>
                <option value="2015">2015</option>
                <option value="2014">2014</option>
                <option value="2013">2013</option>
                <option value="2012">2012</option>
                <option value="2011">2011</option>
                <option value="2010">2010</option>
            </select> 
            <input type="submit" text="Filtrar">
        </form>

        <br><br>
        <span>${listagem}</span>
    </body>
</html>
