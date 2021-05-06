package dekanat.controllers;

import dekanat.app.MainApp;
import dekanat.architecture.BaseViewController;
import dekanat.model.BaseTabHolder;
import dekanat.model.holder.GroupTabHolder;
import dekanat.model.holder.MarksTabHolder;
import dekanat.model.holder.PeopleTabHolder;
import dekanat.model.holder.SubjectsTabHolder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.ArrayList;

public class TableViewController extends BaseViewController {

  @FXML
  private TabPane tabPane;

  @FXML
  private void initialize() {
    System.out.println("init");
  }

  ArrayList<BaseTabHolder<?>> holders = new ArrayList<>();

  @Override
  public void setMainApp(MainApp app) {
    super.setMainApp(app);

    holders.add(new PeopleTabHolder(app));
    holders.add(new GroupTabHolder(app));
    holders.add(new SubjectsTabHolder(app));
    holders.add(new MarksTabHolder(app));

    for (BaseTabHolder<?> holder : holders)
      tabPane.getTabs().add(new Tab(holder.getType().getTitle(), holder.getLayout()));

    tabPane.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
      holders.get((int)newValue).getController().reloadList();
    });
  }

  @FXML
  void onDeleteClick() {
    int tabIndex = tabPane.getSelectionModel().getSelectedIndex();
    holders.get(tabIndex).getController().onDeleteClick();
  }

}
