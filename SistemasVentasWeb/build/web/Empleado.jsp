<%-- 
    Document   : Empleado
    Created on : 04/06/2021, 11:53:15 PM
    Author     : i7
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
             <div class="card col-sm-3">
            <div class="card-body">
                <form action="Controlador?menu=Empleado" method="POST">
                    <div class="form-group">
                        <label>Dni</label>
                        <input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Nombres</label>
                        <input type="text" value="${empleado.getNom()}" name="txtNombres" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Telefono</label>
                        <input type="text" value="${empleado.getTel()}" name="txtTel" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Usuario</label>
                        <input type="text" value="${empleado.getUser()}" name="txtUser" class="form-control">
                    </div>
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
                        <th>NOMBRES</th>
                        <th>TELEFONO</th>
                        <th>ESTADO</th>
                        <th>USER</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="em" items="${empleados}">
                    
              <tr>
                        <td>${em.getId()}</td>
                        <td>${em.getDni()}</td>
                        <td>${em.getNom()}</td>
                        <td>${em.getTel()}</td>
                        <td>${em.getEstado()}</td>
                        <td>${em.getUser()}</td>
                        <td>
                            <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}">Delete</a>
                        </td>
                    </tr>
                      </c:forEach>
                </tbody>
            </table> 
        </div>
        </div>
       
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script> 
    </body>
</html>
