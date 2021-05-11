package dekanat.controllers.tab.people;

import dekanat.architecture.BaseTabViewController;
import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.People;
import dekanat.utils.WriteFileHelper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class PeopleController extends BaseTabViewController<People> {

  @FXML
  private TableColumn<People, Long> idColumn;

  @FXML
  private TableColumn<People, String> firstNameColumn;

  @FXML
  private TableColumn<People, String> lastNameColumn;

  @FXML
  private TableColumn<People, String> fatherNameColumn;

  @FXML
  private TableColumn<People, String> groupColumn;

  @FXML
  private TableColumn<People, String> typeColumn;

  @Override
  protected void initialize() {
    super.initialize();
    idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    fatherNameColumn.setCellValueFactory(cellData -> cellData.getValue().fatherNameProperty());
    groupColumn.setCellValueFactory(cellData -> cellData.getValue().groupNameProperty());
    typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
  }

  @Override
  public BaseTabViewPresenter<People> createPresenter() {
    return new PeoplePresenter();
  }

  @Override
  public void exportToFile() {
    WriteFileHelper.writeToFile("people.csv", presenter.getList());
  }

}
