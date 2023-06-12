package org.example;

import java.sql.*;

public class MessageDao {

    public static void crearMensaje(Message mensaje) {
        Conection dbConnect = new Conection();

        try(Connection conection = dbConnect.get_connection()) {
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = conection.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensaje() {
        Conection dbConnect = new Conection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conection = dbConnect.get_connection()) {
            try {
                String query = "select * from mensajes";
                ps = conection.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("MENSAJE: " + rs.getString("mensaje"));
                    System.out.println("AUTOR: " + rs.getString("autor_mensaje"));
                    System.out.println("FECHA: " + rs.getString("fecha_mensaje"));
                    System.out.println();
                }
            } catch (SQLException e) {
                System.out.println("No se pudieron consultar los mensajes");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void borrarMensaje(int idMensaje) {
        Conection dbConnect = new Conection();

        try(Connection conection = dbConnect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "delete from mensajes where id_mensaje = ?";
                ps = conection.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("El mensaje fue eliminado");

            } catch (SQLException e) {
                System.out.println("El mensaje no pudo ser eliminado");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarMensaje(Message mensaje) {
        Conection dbConnect = new Conection();

        try(Connection conection = dbConnect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conection.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue editado");

            } catch (SQLException e) {
                System.out.println("El mensaje no pudo ser editado");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
