package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Cristian Englert - Septiembre 2.023
 */
public class PedidoABM {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String GenerarFactura() {
        String numeroFactura = "";
        String sql = "select max(numero_factura) from pedido";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroFactura = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroFactura;
    }

    public String idPedido() {
        String idPedido = "";
        String sql = "select max(id_pedido) from pedido";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idPedido = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idPedido;
    }

    public int guardarPedido(Pedido pe) {
        String sql = "insert into pedido (id_cliente, numero_factura, fecha_pedido, monto) values (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pe.getId_cliente());
            ps.setString(2, pe.getNro_factura());
            ps.setString(3, pe.getFecha());
            ps.setDouble(4, pe.getTotal());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public int guardarDetallePedido(Pedido pe) {
        String sql = "insert into detalle_pedido (id_pedido, id_producto, cantidad, subtotal) values (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pe.getId());
            ps.setInt(2, pe.getId_producto());
            ps.setInt(3, pe.getCantidad());
            ps.setDouble(4, pe.getSubtotal());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
