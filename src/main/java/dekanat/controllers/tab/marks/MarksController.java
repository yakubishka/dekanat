package dekanat.controllers.tab.marks;

import dekanat.architecture.BaseTabViewController;
import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Marks;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class MarksController extends BaseTabViewController<Marks> {

  @FXML
  private TableColumn<Marks, Long> idColumn;

  @FXML
  private TableColumn<Marks, String> studentColumn;

  @FXML
  private TableColumn<Marks, String> subjectColumn;

  @FXML
  private TableColumn<Marks, String> teacherColumn;

  @FXML
  private TableColumn<Marks, Integer> valueColumn;

  @Override
  protected void initialize() {
    super.initialize();
    idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
    studentColumn.setCellValueFactory(cellData -> cellData.getValue().studentNameProperty());
    subjectColumn.setCellValueFactory(cellData -> cellData.getValue().subjectNameProperty());
    teacherColumn.setCellValueFactory(cellData -> cellData.getValue().teacherNameProperty());
    valueColumn.setCellValueFactory(cellData -> cellData.getValue().valueProperty().asObject());
  }

  @Override
  public BaseTabViewPresenter<Marks> createPresenter() {
    return new MarksPresenter();
  }
}
