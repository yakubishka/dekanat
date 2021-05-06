package dekanat.utils;

import dekanat.model.requests.delete.Deletable;
import dekanat.model.requests.select.Selectable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

  private static final String url = "jdbc:postgresql://localhost:5432/dekanat";
  private static final String user = "user";
  private static final String password = "12341234";

  public static <T> List<T> getAllByRequest(Selectable<T> selectable) {
    ArrayList<T> selectList = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      try (Statement statement = connection.createStatement()) {
        try (ResultSet result = statement.executeQuery(selectable.getSelectRequest())) {
          while (result.next())
            selectList.add(selectable.buildFromResult(result));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return selectList;
  }

  public static int deleteByRequest(long id, Deletable deletable) {
    int rowAffected = 0;
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      try (Statement statement = connection.createStatement()) {
        rowAffected = statement.executeUpdate(deletable.getDeleteByIdRequest(id));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rowAffected;
  }

}
