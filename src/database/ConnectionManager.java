/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

/**
 *
 * @author User
 */
public class ConnectionManager {
    private static Connection connection;

  public static Connection getConnection() {
    if (connection == null) {
      // koneksi ke database MySQL
      String host = "jdbc:mysql://localhost:3306/epok";
      String username = "root";
      String password = "root";

      try {
        connection = DriverManager.getConnection(host, username, password);
      } catch (SQLException e) {
        System.out.println("Koneksi gagal dibuat: " + e.getMessage());
      }
    }
    return connection;
  }
}
