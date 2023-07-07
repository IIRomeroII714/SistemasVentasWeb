/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Servicios")
public class Servicios {
    EmpleadoDAO edao=new EmpleadoDAO();
    ProductoDAO pdao=new ProductoDAO();

    //CONSULTAS SQL EMPLEADO
    @WebMethod(operationName = "listarempleado")
    public List<Empleado> listarempleado() {
        List datos=edao.listar();
        return datos;
    }

    @WebMethod(operationName = "agregarempleado")
    public String agregarempleado(@WebParam(name = "dni") String dni, @WebParam(name = "nombres") String nombres, @WebParam(name = "telefono") String telefono, @WebParam(name = "estado") String estado, @WebParam(name = "user") String user) {
        String datos=edao.agregar(dni, nombres, telefono, estado, user);
        return datos;
    }

    @WebMethod(operationName = "EliminarEmpleado")
    public Empleado EliminarEmpleado(@WebParam(name = "id") int id) {
        Empleado em=edao.delete(id);
        return em;
    }

    @WebMethod(operationName = "listarIDEmpleado")
    public Empleado listarIDEmpleado(@WebParam(name = "id") int id) {
        Empleado emp=edao.listarId(id);
        return emp;
    }

    @WebMethod(operationName = "ActualizarEmpleado")
    public String ActualizarEmpleado(@WebParam(name = "id") int id, @WebParam(name = "dni") String dni, @WebParam(name = "nombres") String nombres, @WebParam(name = "telefono") String telefono, @WebParam(name = "estado") String estado, @WebParam(name = "user") String user) {
        String datos=edao.actualizar(id, dni, nombres, telefono, estado, user);
        return null;
    }
    
    //CONSULTAS SQL PRODUCTOS
    @WebMethod(operationName = "listarproducto")
    public List<Producto> listarproducto() {
        List datosp=pdao.listar();
        return datosp;
    }

    @WebMethod(operationName = "agregarProducto")
    public String agregarProducto(@WebParam(name = "nombres") String nombres, @WebParam(name = "prrecio") double prrecio, @WebParam(name = "stock") int stock, @WebParam(name = "estado") int estado) {
        String datosp=pdao.agregar(nombres, prrecio, stock, estado);
        return datosp;
    }

    @WebMethod(operationName = "listarIdProducto")
    public Producto listarIdProducto(@WebParam(name = "id") int id) {
        Producto pr=pdao.listarId(id);
        return pr;
    }

    @WebMethod(operationName = "actualizarProducto")
    public String actualizarProducto(@WebParam(name = "id") int id, @WebParam(name = "nombres") String nombres, @WebParam(name = "prrecio") double prrecio, @WebParam(name = "stock") int stock, @WebParam(name = "estado") int estado) {
        String datos=pdao.actualizar(id, nombres, prrecio, stock, estado);
        return null;
    }

    @WebMethod(operationName = "eliminarProducto")
    public Producto eliminarProducto(@WebParam(name = "id") int id) {
        Producto pr=pdao.delete(id);
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Validar")
    public Empleado Validar(@WebParam(name = "user") String user, @WebParam(name = "dni") String dni) {
        EmpleadoDAO emp=new EmpleadoDAO();
        Empleado empleado=emp.validar(user, dni);
        return empleado;
    }

    
    
}
