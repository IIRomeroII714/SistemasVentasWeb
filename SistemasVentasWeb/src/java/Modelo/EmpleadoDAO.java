
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    String msj;
    Empleado em=new Empleado();
    
    public Empleado validar (String user, String dni){
        Empleado empleado=null;
        String sql="select * from empleado where User=? and Dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            if(rs.next()){
                empleado=new Empleado();
                empleado.setDni(rs.getString(1));
                empleado.setNom(rs.getString(2));
                empleado.setTel(rs.getString(3));
                empleado.setEstado(rs.getString(4));
                empleado.setUser(rs.getString(5));
                return empleado;
            }
            
        } catch (Exception e) {
        }
        return empleado;
    }
    //Operaciones CRUD
    public List listar(){
        String sql="select * from empleado";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
            
               
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public String agregar(String dni, String nombre, String tel, String estado, String user){
        String sql="insert into empleado(Dni,Nombres,Telefono,Estado,User)values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, tel);
            ps.setString(4, estado);
            ps.setString(5, user);
            r=ps.executeUpdate();
            if(r==1){
                msj="Usuario Agregado";
            }else{
                msj="Error";
            }
            
        } catch (Exception e) {
        }
        return msj;
    }
    public Empleado listarId (int id){
       String sql="select * from empleado where IdVendedor="+id;
       Empleado emp=new Empleado();
         try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setId(rs.getInt(1));
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
      return emp;
    }
    public String actualizar(int id, String dni, String nombre, String telefono, String estado, String user){
        String sql="update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdVendedor="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setString(4, estado);
            ps.setString(5, user);
            r=ps.executeUpdate();
            if(r==1){
                msj="Empleado actualizado";
            }else{
                msj="Error";
            }
            
            
        } catch (Exception e) {
        }
        return msj;
    }
    public Empleado delete(int id){
        String sql="delete from empleado where IdVendedor="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return em;
    }
}
