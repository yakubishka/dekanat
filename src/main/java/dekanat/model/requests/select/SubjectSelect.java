package dekanat.model.requests.select;

import dekanat.model.db.Subjects;
import dekanat.model.requests.SelectInsertable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectSelect implements SelectInsertable<Subjects> {
  @Override
  public String getSelectRequest() {
    return "select * from subjects";
  }

  @Override
  public Subjects buildFromResult(ResultSet resultSet) throws SQLException {
    long id = resultSet.getLong("id");
    String name = resultSet.getString("name");
    return new Subjects(id, name);
  }
}
