package dekanat.controllers.tab.people;

import dekanat.architecture.BaseTabViewController;
import dekanat.model.db.People;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PeopleController implements BaseTabViewController<People> {

  private PeoplePresenter presenter = new PeoplePresenter();

  @FXML
  private TableView<People> peopleTableView;

  @FXML
  private TableColumn<People, Long> idColumn;

  @FXML
  private TableColumn<People, String> firstNameColumn;

  @FXML
  private TableColumn<People, String> lastNameColumn;

  @FXML
  private TableColumn<People, String> fatherNameColumn;

  @FXML
  private TableColumn<People, Long> groupColumn;

  @FXML
  private TableColumn<People, String> typeColumn;

  @FXML
  private void initialize() {
    idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    fatherNameColumn.setCellValueFactory(cellData -> cellData.getValue().fatherNameProperty());
    groupColumn.setCellValueFactory(cellData -> cellData.getValue().groupIdProperty().asObject());
    typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
    peopleTableView.setItems(presenter.getPeople());
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
