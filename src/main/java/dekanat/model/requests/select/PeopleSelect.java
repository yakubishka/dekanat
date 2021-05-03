package dekanat.model.requests.select;

import dekanat.model.db.People;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleSelect implements Selectable<People> {

  @Override
  public String getSelectRequest() {
    return "select * from people";
  }

  @Override
  public People buildFromResult(ResultSet resultSet) throws SQLException {
    long id = resultSet.getLong("id");
    String firstName = resultSet.getString("first_name");
    String lastName = resultSet.getString("last_name");
    String fatherName = resultSet.getString("father_name");
    long groupId = resultSet.getLong("group_id");
    String type = resultSet.getString("type");
    return new People(id, firstName, lastName, fatherName, groupId, type);
  }
}
