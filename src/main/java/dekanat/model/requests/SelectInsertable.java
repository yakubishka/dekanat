package dekanat.model.requests;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SelectInsertable<T> {

  String getSelectRequest();

  T buildFromResult(ResultSet resultSet) throws SQLException;

}
