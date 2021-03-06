package dekanat.model.requests.select;

import dekanat.model.db.Groups;
import dekanat.model.requests.SelectInsertable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupsSelect implements SelectInsertable<Groups> {

  @Override
  public String getSelectRequest() {
    return "select * from groups";
  }

  @Override
  public Groups buildFromResult(ResultSet resultSet) throws SQLException {
    long id = resultSet.getLong("id");
    String name = resultSet.getString("name");
    return new Groups(id, name);
  }
}