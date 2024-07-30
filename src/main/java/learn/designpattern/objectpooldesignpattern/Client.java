package learn.designpattern.objectpooldesignpattern;

import java.sql.SQLException;

public class Client {
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    DbConnectionPoolManager poolManager = new DbConnectionPoolManager();
    DBConnection dbConnection1 = poolManager.getDbConnection();
    DBConnection dbConnection2 = poolManager.getDbConnection();
    DBConnection dbConnection3 = poolManager.getDbConnection();
    DBConnection dbConnection4 = poolManager.getDbConnection();
    DBConnection dbConnection5 = poolManager.getDbConnection();
    DBConnection dbConnection6 = poolManager.getDbConnection();
    poolManager.getDbConnection();
    poolManager.relaseDbConnection(dbConnection6);
  }
}
