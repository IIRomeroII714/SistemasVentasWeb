/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Producto {
    int id;
    String nombres;
    double prrecio;
    int stock;
    int estado;

    public Producto() {
    }

    public Producto(int id, String nombres, double prrecio, int stock, int estado) {
        this.id = id;
        this.nombres = nombres;
        this.prrecio = prrecio;
        this.stock = stock;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getPrrecio() {
        return prrecio;
    }

    public void setPrrecio(double prrecio) {
        this.prrecio = prrecio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
