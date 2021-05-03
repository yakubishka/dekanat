package dekanat.model.requests.select;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Selectable<T> {

  String getSelectRequest();

  T buildFromResult(ResultSet resultSet) throws SQLException;

}
