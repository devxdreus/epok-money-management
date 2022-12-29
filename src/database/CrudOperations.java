package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudOperations {
  // method untuk menambahkan data ke tabel
  public static <T> boolean create(String namaTabel, Map<String, T> data) {
    try {
      StringBuilder sqlBuilder = new StringBuilder("INSERT INTO " + namaTabel + " (");
      StringBuilder valueBuilder = new StringBuilder("VALUES (");
      for (Map.Entry<String, T> entry : data.entrySet()) {
        sqlBuilder.append(entry.getKey()).append(", ");
        valueBuilder.append("?, ");
      }
      // hapus koma terakhir dari sqlBuilder dan valueBuilder
      sqlBuilder.setLength(sqlBuilder.length() - 2);
      valueBuilder.setLength(valueBuilder.length() - 2);
      sqlBuilder.append(") ").append(valueBuilder).append(")");
      String sql = sqlBuilder.toString();

      PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql);
      int index = 1;
      for (Map.Entry<String, T> entry : data.entrySet()) {
        statement.setObject(index, entry.getValue());
        index++;
      }
      int rowsAffected = statement.executeUpdate();
      System.out.println(rowsAffected + " baris terpengaruh");
      return true;
      
    } catch (SQLException e) {
      System.out.println("Terjadi kesalahan: " + e.getMessage());
      return false;
    }
  }

  
  // method untuk menampilkan data dari tabel berdasarkan kondisi
  public static List<Map<String, String>> read(String namaTabel, String kondisi) {
    List<Map<String, String>> data = new ArrayList<>();
    try {
      String sql;
      if (kondisi == null) {
        sql = "SELECT * FROM " + namaTabel;
      } else {
        sql = "SELECT * FROM " + namaTabel + " WHERE " + kondisi;
      }
      Statement statement = ConnectionManager.getConnection().createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      ResultSetMetaData metaData = resultSet.getMetaData();
      int columnCount = metaData.getColumnCount();
      while (resultSet.next()) {
        Map<String, String> row = new HashMap<>();
        for (int i = 1; i <= columnCount; i++) {
          String columnName = metaData.getColumnName(i);
          String value = resultSet.getString(columnName);
          row.put(columnName, value);
        }
        data.add(row);
      }
    } catch (SQLException e) {
      System.out.println("Terjadi kesalahan: " + e.getMessage());
    }
    return data;
  }
  
  // method untuk mengupdate data pada tabel
  public static void update(String namaTabel, Map<String, String> data, String id) {
    try {
      StringBuilder sqlBuilder = new StringBuilder("UPDATE " + namaTabel + " SET ");
      for (Map.Entry<String, String> entry : data.entrySet()) {
        sqlBuilder.append(entry.getKey()).append(" = ?, ");
      }
      // hapus koma terakhir dari sqlBuilder
      sqlBuilder.setLength(sqlBuilder.length() - 2);
      sqlBuilder.append(" WHERE id = ?");
      String sql = sqlBuilder.toString();

      PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql);
      int index = 1;
      for (Map.Entry<String, String> entry : data.entrySet()) {
        statement.setString(index, entry.getValue());
        index++;
      }
      statement.setString(index, id);
      int rowsAffected = statement.executeUpdate();
      System.out.println(rowsAffected + " baris terpengaruh");
    } catch (SQLException e) {
      System.out.println("Terjadi kesalahan: " + e.getMessage());
    }
  }
  
  
  // method untuk menghapus data dari tabel
  public static boolean delete(String namaTabel, String id) {
    try {
      String sql = "DELETE FROM " + namaTabel + " WHERE id = ?";
      PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql);
      statement.setString(1, id);
      int rowsAffected = statement.executeUpdate();
      System.out.println(rowsAffected + " baris terpengaruh");
      return true;
      
    } catch (SQLException e) {
      System.out.println("Terjadi kesalahan: " + e.getMessage());
      return false;
    }
  }
}
