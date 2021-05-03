package dekanat.controllers;

import dekanat.app.MainApp;
import dekanat.architecture.BaseViewController;
import dekanat.resources.LayoutRes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TableViewController extends BaseViewController {

  @FXML
  private TabPane tabPane;

  @FXML
  private void initialize() { }

  @Override
  public void setMainApp(MainApp app) {
    super.setMainApp(app);

    FXMLLoader loader = app.createLoader(LayoutRes.PEOPLE_LAYOUT);

//    Tab groupsTab = new Tab("Groups", new Label("Groups"));
    Tab peopleTab = new Tab("People", app.getPaneFromLoader(loader));
//    Tab marksTab = new Tab("Marks", new Label("Marks"));
//    Tab subjectsTab = new Tab("Subjects", new Label("Subjects"));

//    tabPane.getTabs().add(groupsTab);
    tabPane.getTabs().add(peopleTab);

//    tabPane.getTabs().add(marksTab);
//    tabPane.getTabs().add(subjectsTab);
  }

}
