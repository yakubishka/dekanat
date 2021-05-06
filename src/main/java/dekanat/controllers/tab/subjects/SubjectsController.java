package dekanat.controllers.tab.subjects;

import dekanat.architecture.BaseTabViewController;
import dekanat.architecture.BaseTabViewPresenter;
import dekanat.controllers.tab.groups.GroupsPresenter;
import dekanat.model.db.Subjects;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class SubjectsController extends BaseTabViewController<Subjects> {

  @FXML
  private TableColumn<Subjects, Long> idColumn;

  @FXML
  private TableColumn<Subjects, String> nameColumn;


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
  public void onEditClick() {

  }

  @Override
  public BaseTabViewPresenter<Subjects> createPresenter() {
    return new SubjectsPresenter();
  }

}

