package dekanat.model.requests.select;

import dekanat.model.db.People;
import dekanat.model.requests.SelectInsertable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleSelect implements SelectInsertable<People> {

  @Override
  public String getSelectRequest() {
    return "select people.*, groups.name as group_name from people left join groups on people.group_id = groups.id";
  }

  @Override
  public People buildFromResult(ResultSet resultSet) throws SQLException {
    long id = resultSet.getLong("id");
    String firstName = resultSet.getString("first_name");
    String lastName = resultSet.getString("last_name");
    String fatherName = resultSet.getString("father_name");
    long groupId = resultSet.getLong("group_id");
    String type = resultSet.getString("type");
    String groupName= resultSet.getString("group_name");
    return new People(id, firstName, lastName, fatherName, groupId, type, groupName);
  }
}
