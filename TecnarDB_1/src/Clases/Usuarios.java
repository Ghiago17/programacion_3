package Clases;

import java.sql.*;

public class Usuarios {
    String nombre;
    String apellido;
    String username;
    String password;
    String tipo;

    // Método para verificar las credenciales del usuario
    public boolean verificarCredenciales(String pUsername, String pPassword) {
        Conector db = new Conector();
        try {
            db.conectar();
            String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            ResultSet rs = db.executeSelect(query, pUsername, pPassword);
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        } finally {
            db.desconectar();
        }
    }

    // Método para listar usuarios
    public ResultSet listarUsuarios() {
        Conector db = new Conector();
        ResultSet rs = null;

        try {
            db.conectar();
            String query = "SELECT * FROM usuarios";
            rs = db.executeSelect(query);
        } catch (SQLException e) {
            System.err.println("Error al listar los usuarios: " + e.getMessage());
        }

        return rs;
    }

    // Método para insertar un nuevo usuario
    public int guardarUsuario(String nombre, String apellido, String username, String password, String tipo) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO usuarios (nombre, apellido, username, password, tipo) VALUES (?, ?, ?, ?, ?)";
        return db.executeUpdate(query, nombre, apellido, username, password, tipo);
    }

    // Método para actualizar un usuario existente
    public int actualizarUsuario(int id, String nombre, String apellido, String username, String password, String tipo) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE usuarios SET nombre = ?, apellido = ?, username = ?, password = ?, tipo = ? WHERE id = ?";
        return db.executeUpdate(query, nombre, apellido, username, password, tipo, id);
    }

    // Método para eliminar un usuario
    public int eliminarUsuario(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM usuarios WHERE id = ?";
        return db.executeUpdate(query, id);
    }
}
