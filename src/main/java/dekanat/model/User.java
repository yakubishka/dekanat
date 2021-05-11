package dekanat.model;

public class User {

  private String login;
  private String password;
  private Integer status;

  public User(String login, String password, Integer status) {
    this.login = login;
    this.password = password;
    this.status = status;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
