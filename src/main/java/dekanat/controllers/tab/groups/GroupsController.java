package dekanat.controllers.tab.groups;

import dekanat.architecture.BaseTabViewController;
import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Groups;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class GroupsController extends BaseTabViewController<Groups> {

  @FXML
  private TableColumn<Groups, Long> idColumn;

  @FXML
  private TableColumn<Groups, String> nameColumn;


  @Override
  protected void initialize() {
    super.initialize();
    idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
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

  @Override
  public BaseTabViewPresenter<Groups> createPresenter() {
    return new GroupsPresenter();
  }

}
