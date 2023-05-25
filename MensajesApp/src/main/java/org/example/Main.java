package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Conection conection = new Conection();

        try (Connection cnx = conection.get_connection()) {

        } catch (Exception e) {

        }
    }
}