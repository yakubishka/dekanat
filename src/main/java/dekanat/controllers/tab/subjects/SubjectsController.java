package dekanat.controllers.tab.subjects;

import dekanat.architecture.BaseTabViewController;
import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Subjects;
import dekanat.utils.WriteFileHelper;
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
  public BaseTabViewPresenter<Subjects> createPresenter() {
    return new SubjectsPresenter();
  }

  @Override
  public void exportToFile() {
    WriteFileHelper.writeToFile("subjects.csv", presenter.getList());
  }

}

