package learn.designpattern.objectpooldesignpattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.Getter;

@Getter
public class DBConnection {
  Connection connection;
  String url =
      "jdbc:sqlite:/Users/karthikp/Library/DBeaverData/workspace6/.metadata/sample-database-sqlite-1/Chinook.db";

  public DBConnection() throws SQLException, ClassNotFoundException {
    Class.forName("org.sqlite.JDBC");
    this.connection = DriverManager.getConnection(url);
  }

  public DBConnection(String url) throws SQLException, ClassNotFoundException {
    // Load the SQLite JDBC driver
    Class.forName("org.sqlite.JDBC");
    this.connection = DriverManager.getConnection(url);
  }

  public void closeConnection(Connection connection) throws SQLException {
    if (connection != null) {
      connection.close();
    }
  }

  public void closeStatement(Statement statement) throws SQLException {
    if (statement != null) {
      statement.close();
    }
  }

  public void closePreparedStatement(PreparedStatement preparedStatement)
      throws SQLException {
    if (preparedStatement != null) {
      preparedStatement.close();
    }
  }

  public void closeResultSet(ResultSet resultSet) throws SQLException {
    if (resultSet != null) {
      resultSet.close();
    }
  }

  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    String sql = "SELECT * FROM Album where AlbumId = ?";
    try (Connection connection = new DBConnection(
        "jdbc:sqlite:/Users/karthikp/Library/DBeaverData/workspace6/.metadata/sample-database-sqlite-1/Chinook.db").getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
             sql);) {
      preparedStatement.setInt(1, 5);
      try (ResultSet resultSet = preparedStatement.executeQuery();) {
        while (resultSet.next()) {
          String res =
              resultSet.getInt("AlbumId") + " " + resultSet.getString("Title");
          System.out.println("res = " + res);
        }
      }
    }
  }
}
