package dekanat.controllers;

import dekanat.app.MainApp;
import dekanat.architecture.BaseViewController;
import dekanat.model.BaseTabHolder;
import dekanat.model.holder.GroupTabHolder;
import dekanat.model.holder.PeopleTabHolder;
import dekanat.model.holder.SubjectsTabHolder;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.ArrayList;

public class TableViewController extends BaseViewController {

  @FXML
  private TabPane tabPane;

  @FXML
  private void initialize() { }

  @Override
  public void setMainApp(MainApp app) {
    super.setMainApp(app);

    ArrayList<BaseTabHolder<?>> holders = new ArrayList<>();

    holders.add(new PeopleTabHolder(app));
    holders.add(new GroupTabHolder(app));
    holders.add(new SubjectsTabHolder(app));

    for (BaseTabHolder<?> holder : holders)
      tabPane.getTabs().add(new Tab(holder.getType().getTitle(), holder.getLayout()));

  }

}
