package dekanat.app;

import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.*;

public class MainApp extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

  }

  public static void main(String[] args) throws ClassNotFoundException {

    String url      = "jdbc:postgresql://localhost:5432/dekanat";   //database specific url.
    String user     = "user";
    String password = "12341234";

    try(Connection connection = DriverManager.getConnection(url, user, password)) {
      try(Statement statement = connection.createStatement()){
        String sql = "select * from people";
        try(ResultSet result = statement.executeQuery(sql)){
          while(result.next()) {
            String name = result.getString("first_name");
            String lastName = result.getString("last_name");
            System.out.println(name + " " + lastName);
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



}
