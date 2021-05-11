package dekanat.controllers.tab.groups;

import dekanat.architecture.BaseTabViewController;
import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Groups;
import dekanat.utils.WriteFileHelper;
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
  public BaseTabViewPresenter<Groups> createPresenter() {
    return new GroupsPresenter();
  }

  @Override
  public void exportToFile() {
    WriteFileHelper.writeToFile("groups.csv", presenter.getList());
  }

}
