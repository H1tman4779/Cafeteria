package Modelo;

/**
 *
 * @author Cristian Englert - Septiembre 2.023
 */
public class Cliente {

    int id_cliente;
    String dni;
    String apellido;
    String nombre;

    public Cliente() {
    }

    public Cliente(int id_cliente, String dni, String apellido, String nombre) {
        this.id_cliente = id_cliente;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;

    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
