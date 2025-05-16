/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.*;

/**
 *
 * @author Ing. Narvaez Mejia
 */
public class Clientes {

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    // Método para listar todos los clientes desde la base de datos
    public ResultSet listarCliente() {
        Conector db = new Conector();
        ResultSet rs = null;

        try {
            db.conectar();
            String query = "SELECT * FROM clientes";
            rs = db.executeSelect(query);
        } catch (SQLException e) {
            System.err.println("Error al listar los clientes Metodo: " + e.getMessage());
        }

        return rs;
    }

    // Método para insertar un nuevo cliente en la base de datos usando parámetros
    public int guardarCliente(String nombre, String apellido, String direccion, String telefono) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO clientes (nombre, apellido, direccion, telefono) VALUES (?, ?, ?, ?)";
        return db.executeUpdate(query, nombre, apellido, direccion, telefono);
    }

    // Método para insertar un nuevo cliente usando los atributos de la clase
    public int guardarCliente() throws SQLException {
        return guardarCliente(this.nombre, this.apellido, this.direccion, this.telefono);
    }

    // Método para actualizar un cliente existente en la base de datos
    public int actualizarCliente(int id, String nombre, String apellido, String direccion, String telefono) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE clientes SET nombre = ?, apellido = ?, direccion = ?, telefono = ? WHERE id = ?";
        return db.executeUpdate(query, nombre, apellido, direccion, telefono, id);
    }

    // Método para eliminar un cliente de la base de datos
    public int eliminarCliente(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM clientes WHERE id = ?";
        return db.executeUpdate(query, id);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
