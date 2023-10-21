package Modelo;

/**
 *
 * @author Cristian Englert - Septiembre 2.023
 */
public class Producto {

    int id_producto;
    String producto;
    double precio;
    int stock;

    public Producto() {
    }

    public Producto(int id_producto, String producto, double precio, int stock) {
        this.id_producto = id_producto;
        this.producto = producto;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
