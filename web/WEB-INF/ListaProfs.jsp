<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Professor</title>
    </head>
    <body>
        <h1>Lista Professor</h1>
        
                     <ul>
                    
                        <c:forEach var="professor" items="${professores}">
                            <li style="margin-bottom:10px;font-family: arial; ">
                                <span>${professor.codProfessor}</span>
                                <span style="background:lightgray;padding:5px">${professor.nomeProfessor}</span>
                            </li>
                        </c:forEach>
                    </ul>
                   
    </body>
</html>
