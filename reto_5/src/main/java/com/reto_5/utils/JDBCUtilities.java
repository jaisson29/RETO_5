package com.reto_5.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
 // Atributos de clase para gestión de conexión con la base de datos
    private static final String UBICACION_BD = "C:\\Users\\jaiss\\OneDrive\\Documentos\\minTic2022\\ciclo_2\\Retos\\reto_5\\ProyectosConstruccion.db";
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    } 

}