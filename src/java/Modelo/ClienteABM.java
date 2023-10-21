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
public class ClienteABM {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente buscar(String dni) {

        Cliente c = new Cliente();
        String sql = "select * from cliente where dni=" + dni;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_cliente(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setNombre(rs.getString(4));
            }
        } catch (Exception e) {
        }
        return c;
    }

    public List listar() {

        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setApellido(rs.getString(3));
                cl.setNombre(rs.getString(4));
                lista.add(cl);
            }

        } catch (Exception e) {

        }
        return lista;
    }

    public int agregar(Cliente cl) {

        String sql = "insert into cliente (dni, apellido, nombre) values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getApellido());
            ps.setString(3, cl.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;
    }

    public Cliente listarId(int id) {

        Cliente cli = new Cliente();
        String sql = "select * from cliente where id_cliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setDni(rs.getString(2));
                cli.setApellido(rs.getString(3));
                cli.setNombre(rs.getString(4));
            }
        } catch (Exception e) {

        }
        return cli;
    }

    public int actualizar(Cliente cl) {

        String sql = "update cliente set dni=?, apellido=?, nombre=? where id_cliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getApellido());
            ps.setString(3, cl.getNombre());
            ps.setInt(4, cl.getId_cliente());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return r;

    }

    public void eliminar(int id) {

        String sql = "delete from cliente where id_cliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }

}
