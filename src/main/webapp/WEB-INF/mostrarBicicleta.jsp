<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Bicicletas</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
            </head>

            <body>
                <div class="container">

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Marca</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">Color</th>
                                <th scope="col">Rodado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="bicicleta" items="${bicicletasCapturadas}">
                                <tr>
                                    <th scope="row">${bicicleta.id}</th>
                                    <td>${bicicleta.marca}</td>
                                    <td>${bicicleta.tipo}</td>
                                    <td>${bicicleta.color}</td>
                                    <td>${bicicleta.rodado}</td>
                                    <td><a class="btn btn-warning" href="/bicicleta/editar/${bicicleta.id}" role="button">Editar</a></td>
                                    <td><a class="btn btn-danger" href="eliminar/${bicicleta.id}" role="button">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            </body>

            </html>