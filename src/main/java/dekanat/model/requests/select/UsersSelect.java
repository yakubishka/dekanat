package dekanat.model.requests.select;

import dekanat.model.User;
import dekanat.model.requests.SelectInsertable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersSelect implements SelectInsertable<User> {

  private String login;
  private String password;

  public UsersSelect(String login, String password) {
    this.login = login;
    this.password = password;
  }

  @Override
  public String getSelectRequest() {
    return "select checkPassword('" + login +"', '" + password + "')";
  }

  @Override
  public User buildFromResult(ResultSet resultSet) throws SQLException {
    Integer status = resultSet.getInt("checkpassword");
    return new User(login, password, status);
  }
}
