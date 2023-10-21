<%-- 
    Document   : Cliente
    Author     : Cristian Englert - Septiembre 2.023
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <title>Cliente</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Apellido</label>
                            <input type="text" value="${cliente.getApellido()}" name="txtApellido" class="form-control">
                        </div>
                        <br>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${cliente.getNombre()}" name="txtNombre" class="form-control">
                        </div>
                        <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>APELLIDO</th>
                            <th>NOMBRE</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cl" items="${clientes}">
                            <tr>
                                <td>${cl.getId_cliente()}</td>
                                <td>${cl.getDni()}</td>
                                <td>${cl.getApellido()}</td>
                                <td>${cl.getNombre()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cl.getId_cliente()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Eliminar&id=${cl.getId_cliente()}">Eliminar</a>
                                </td>
                            </tr>  
                        </c:forEach>
                    </tbody>
                </table>
            </div>    
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    </body>
</html>
