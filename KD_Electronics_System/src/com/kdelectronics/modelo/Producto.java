package com.kdelectronics.modelo;

public class Producto {

    private String codigoProducto;
    private String nombreProducto;
    private String descripcion;
    private double precioBase;
    private double precioVenta;
    private String categoria; // ← TEXTO
    private int cantidadDisponible;
    private int estado;

    public Producto() {}

    public Producto(String codigoProducto, String nombreProducto, String descripcion,
                    double precioBase, double precioVenta, String categoria,
                    int cantidadDisponible, int estado) {

        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.precioVenta = precioVenta;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.estado = estado;
    }

    public String getCodigoProducto() { return codigoProducto; }
    public void setCodigoProducto(String codigoProducto) { this.codigoProducto = codigoProducto; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public int getEstado() { return estado; }
    public void setEstado(int estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "----- PRODUCTO -----\n" +
               "Código: " + codigoProducto + "\n" +
               "Nombre: " + nombreProducto + "\n" +
               "Descripción: " + descripcion + "\n" +
               "Precio Base: " + precioBase + "\n" +
               "Precio Venta: " + precioVenta + "\n" +
               "Categoría: " + categoria + "\n" +
               "Stock: " + cantidadDisponible + "\n";
    }
}