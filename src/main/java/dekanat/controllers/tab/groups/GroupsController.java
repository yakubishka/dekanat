package dekanat.controllers.tab.groups;

import dekanat.architecture.BaseTabViewController;
import dekanat.model.db.Groups;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GroupsController implements BaseTabViewController<Groups> {

  private final GroupsPresenter presenter = new GroupsPresenter();

  @FXML
  private TableView<Groups> groupTableView;

  @FXML
  private TableColumn<Groups, Long> idColumn;

  @FXML
  private TableColumn<Groups, String> nameColumn;


  @FXML
  private void initialize() {
    idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    groupTableView.setItems(presenter.getGroups());
  }

  @Override
  public void onInsertClick() {

  }

  @Override
  public void onDeleteClick() {

  }

  @Override
  public void inEditClick() {

  }

}
