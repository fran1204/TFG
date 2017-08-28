/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;

/**
 *
 * @author fran
 */
public class connection {

    private static Connection conexion;

    public static void setConexion () {
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/community_shopping", "root", "root");

        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        if (conexion == null){
            setConexion();
        }
        return conexion;
    }
}
