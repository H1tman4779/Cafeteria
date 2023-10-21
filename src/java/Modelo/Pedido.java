package Modelo;

/**
 *
 * @author Cristian Englert - Septiembre 2.023
 */
public class Pedido {

    int id, item, id_cliente, id_producto;
    String nro_factura, descripcion_p, fecha;
    Double precio;
    int cantidad;
    Double subtotal, total;

    public Pedido() {
    }

    public Pedido(int id, int item, int id_cliente, int id_producto, String nro_factura, String descripcion_p, String fecha, Double precio, int cantidad, Double subtotal, Double total) {
        this.id = id;
        this.item = item;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.nro_factura = nro_factura;
        this.descripcion_p = descripcion_p;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(String nro_factura) {
        this.nro_factura = nro_factura;
    }

    public String getDescripcion_p() {
        return descripcion_p;
    }

    public void setDescripcion_p(String descripcion_p) {
        this.descripcion_p = descripcion_p;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
