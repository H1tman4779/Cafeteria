package Modelo;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Englert - Septiembre 2.023
 */
public class ProductoABM {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto buscar(int id) {
        Producto pr = new Producto();
        String sql = "select * from producto where id_producto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId_producto(rs.getInt(1));
                pr.setProducto(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return pr;
    }

    public int actualizarStock(int id, int stock) {
        String sql = "update producto set stock=? where id_producto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public List listar() {

        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pr = new Producto();
                pr.setId_producto(rs.getInt(1));
                pr.setProducto(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                lista.add(pr);
            }

        } catch (Exception e) {

        }
        return lista;
    }

    public int agregar(Producto pr) {

        String sql = "insert into producto(producto, precio, stock) values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getProducto());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;
    }

    public Producto listarId(int id) {

        Producto pro = new Producto();
        String sql = "select * from producto where id_producto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setId_producto(rs.getInt(1));
                pro.setProducto(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
            }
        } catch (Exception e) {

        }
        return pro;
    }

    public int actualizar(Producto pr) {

        String sql = "update producto set producto=?, precio=?, stock=? where id_producto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getProducto());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());
            ps.setInt(4, pr.getId_producto());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;

    }

    public void eliminar(int id) {

        String sql = "delete from producto where id_producto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }

}
