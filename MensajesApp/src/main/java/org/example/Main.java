package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("--------------------");
            System.out.println(" APLICACION DE MENSAJES  ");
            System.out.println("1. Crear mensajes.");
            System.out.println("2. Listar mensajes.");
            System.out.println("3. Eliminar mensaje;");
            System.out.println("4. Editar mensaje.");
            System.out.println("5. Salir.");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> MessageService.crearMensaje();
                case 2 -> MessageService.listarMensajes();
                case 3 -> MessageService.borrarMensaje();
                case 4 -> MessageService.editarMensaje();
                default -> {
                }
            }
        } while (opcion != 5);

        Conection conection = new Conection();

        try (Connection cnx = conection.get_connection()) {

        } catch (Exception e) {

        }
    }
}