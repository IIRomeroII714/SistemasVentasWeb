/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO {
    Producto pr=new Producto();
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    String msj;
    
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto pr=new Producto();
                pr.setId(rs.getInt(1));
                pr.setNombres(rs.getString(2));
                pr.setPrrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getInt(5));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public String agregar(String nombres, double prrecio, int stock, int estado){
        String sql="insert into producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, nombres);
            ps.setDouble(2, prrecio);
            ps.setInt(3, stock);
            ps.setInt(4, estado);
            r=ps.executeUpdate();
            if(r==1){
                msj="Producto Agregado";
            }else{
                msj="Error";
            }
            
        } catch (Exception e) {
        }
        return msj;
    }
    
    public Producto listarId (int id){
       String sql="select * from producto where IdProducto="+id;
       Producto pr=new Producto();
         try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setId(rs.getInt(1));
                pr.setNombres(rs.getString(2));
                pr.setPrrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getInt(5));
            }
        } catch (Exception e) {
        }
      return pr;
    }
    
    public String actualizar(int id, String nombres, double prrecio, int stock, int estado){
        String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, nombres);
            ps.setDouble(2, prrecio);
            ps.setInt(3, stock);
            ps.setInt(4, estado);
            r=ps.executeUpdate();
            if(r==1){
                msj="Producto actualizado";
            }else{
                msj="Error";
            }
            
            
        } catch (Exception e) {
        }
        return msj;
    }
    public Producto delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return pr;
    }
}
