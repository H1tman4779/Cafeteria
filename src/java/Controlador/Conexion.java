package Controlador;

import java.sql.*;

/**
 *
 * @author Cristian Englert - Septiembre 2.023
 */
public class Conexion {

    Connection con;
    String url = "jdbc:mysql://node156585-env-2916008.jelastic.saveincloud.net:3306/cafeteria_db";
    String user = "root";
    String pass = "MySql";

    public Connection Conexion() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println("Error en conexion" + e.getMessage());
        }

        return con;

    }

}
