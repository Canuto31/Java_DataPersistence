package org.example;

import java.util.Scanner;

public class MessageService {

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String messageText = sc.nextLine();

        System.out.println("Nombre del autor: ");
        String autor = sc.nextLine();

        Message message = new Message();
        message.setMensaje(messageText);
        message.setAutor_mensaje(autor);
        MessageDao.crearMensaje(message);
    }

    public static void listarMensajes() {
        MessageDao.leerMensaje();
    }

    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar: ");
        int idMensaje = sc.nextInt();
        MessageDao.borrarMensaje(idMensaje);
    }

    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el mensaje actualizado");
        String messajeText = sc.nextLine();
        System.out.println("Indica el ID del mensaje a editar: ");
        int idMensaje = sc.nextInt();
        Message message = new Message();
        message.setId_mensaje(idMensaje);
        message.setMensaje(messajeText);
        MessageDao.actualizarMensaje(message);
    }
}
