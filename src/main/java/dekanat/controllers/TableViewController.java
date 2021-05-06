package dekanat.controllers;

import dekanat.app.MainApp;
import dekanat.architecture.BaseViewController;
import dekanat.model.BaseTabHolder;
import dekanat.model.holder.GroupTabHolder;
import dekanat.model.holder.MarksTabHolder;
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
  private void onDeleteClick() {
    holders.get(getCurrentTabIndex()).getController().onDeleteClick();
  }

  @FXML
  private void onInsertClick() {
    holders.get(getCurrentTabIndex()).getController().onInsertClick();
  }

  @FXML
  private void onEditClick() {
    holders.get(getCurrentTabIndex()).getController().onEditClick();
  }

  private int getCurrentTabIndex() {
    return tabPane.getSelectionModel().getSelectedIndex();
  }

}
