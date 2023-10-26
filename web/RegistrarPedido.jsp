<%-- 
    Document   : RegistrarPedido
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
        <title>Pedido</title>
        <style>
            @media print{
                .zona1, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5 zona1">
                <div class="card">
                    <form action="Controlador?menu=NuevoPedido" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label> 
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-5 d-flex">
                                    <input type="text" name="codigocliente" value="${cl.getDni()}" class="form-control" placeholder="Dni">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">  
                                </div>                                    
                            </div>
                            <div>
                                <br>
                                <div class="col-sm-10 d-flex">
                                    <input type="text" name="apellidocliente" value="${cl.getApellido()}" placeholder="Apellido Cliente" class="form-control" col-sm-6> 
                                    <input type="text" name="nombrecliente" value="${cl.getNombre()}" placeholder="Nombre Cliente" class="form-control" col-sm-6>
                                </div>  
                            </div>
                            <br>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="codigoproducto" value="${producto.getId_producto()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>  
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreproducto" value="${producto.getProducto()}" placeholder ="Datos Producto" class="form-control" col-sm-6>  
                                </div> 
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="S/.0.00">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cantidad" value="1" placeholder ="" class="form-control">  
                                </div> 
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}" placeholder ="Stock" class="form-control">  
                                </div>
                            </div>
                            <br>                            
                            <div class="form-group d-flex">
                                <div class="form-group">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                                </div>
                                <div>
                                    <input type="text" value="${insuficiente}" style="margin-left: 50px" class="fs-5 fw-bold text-center text-danger-emphasis bg-light-subtle border border-light-subtle">  
                                </div>
                            </div>
                        </div>                    
                    </form>                    
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="col-sm-3 ml-auto">
                            <label>Factura Nro</label>
                            <input type="text" name="nrofactura" value="${numerofactura}" class="form-control">
                            <label>Fecha</label>
                            <input type="text" name="fecha" value="${fecha}" class="form-control" style="margin-right: 10px">                            
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getId_producto()}</td>
                                        <td>${list.getDescripcion_p()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                    </tr>   
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevoPedido&accion=GenerarPedido" onclick="print()" class="btn btn-success">Generar Pedido</a>             
                        </div>
                        <div class="col-sm-5 ml-auto d-flex">
                            <label class="col-sm-6 text-right mt-2">Total a Pagar</label>
                            <input type="text" name="txtTotal" value="$ ${totalpagar}" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa" crossorigin="anonymous"></script>
    </body>
</html>
