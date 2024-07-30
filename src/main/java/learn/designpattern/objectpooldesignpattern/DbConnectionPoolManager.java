package learn.designpattern.objectpooldesignpattern;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbConnectionPoolManager {

  List<DBConnection> freeConnectionsInPool = new ArrayList();
  List<DBConnection> connectionsCurrentlyInUse = new ArrayList();
  int INITIAL_POOL_SIZE = 3;
  int MAX_POOL_SIZE = 6;

  public DbConnectionPoolManager() throws SQLException, ClassNotFoundException {
    for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
      freeConnectionsInPool.add(new DBConnection());
    }
  }

  public DBConnection getDbConnection()
      throws SQLException, ClassNotFoundException {
    if (freeConnectionsInPool.isEmpty() &&
        connectionsCurrentlyInUse.size() < MAX_POOL_SIZE) {
      freeConnectionsInPool.add(new DBConnection());
    } else if (freeConnectionsInPool.isEmpty() &&
        connectionsCurrentlyInUse.size() >= MAX_POOL_SIZE) {
      System.out.println(
          "maximum pool size reached : " + MAX_POOL_SIZE + " not adding..");
    }
    DBConnection dBConnection =
        freeConnectionsInPool.remove(freeConnectionsInPool.size() - 1);
    connectionsCurrentlyInUse.add(dBConnection);
    System.out.println(
        "Adding DBConnection into use pool , size of connectionsCurrentlyInUse is :" +
            connectionsCurrentlyInUse.size());
    return dBConnection;
  }

  public void relaseDbConnection(DBConnection dbConnection) {
    if (dbConnection != null) {
      connectionsCurrentlyInUse.remove(dbConnection);
      System.out.println(
          "Removing DBconnection from use pool and size : " +
              connectionsCurrentlyInUse.size());
      freeConnectionsInPool.add(dbConnection);
      System.out.println("Adding DBconnection into free pool and size : " +
          freeConnectionsInPool.size());
    }
  }
}
