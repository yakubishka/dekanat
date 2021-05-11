package dekanat.controllers.dialogs;

import com.sun.istack.NotNull;
import dekanat.app.DialogStageHelper;
import dekanat.app.MainApp;
import dekanat.model.db.Marks;
import dekanat.model.db.People;
import dekanat.model.db.Subjects;
import dekanat.model.requests.select.PeopleSelect;
import dekanat.model.requests.select.SubjectSelect;
import dekanat.resources.LayoutRes;
import dekanat.utils.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class AddEditMarksDialogController {

  @FXML
  private ComboBox<People> studentField;

  @FXML
  private ComboBox<Subjects> subjectField;

  @FXML
  private ComboBox<People> teacherField;

  @FXML
  private TextField markField;

  private Marks mark;
  private Stage dialogStage;
  private final ObservableList<People> teacherList = FXCollections.observableArrayList();
  private final ObservableList<People> studentList = FXCollections.observableArrayList();
  private final ObservableList<Subjects> subjectsList = FXCollections.observableArrayList();

  @FXML
  private void initialize() {
    subjectsList.addAll(DBHelper.getAllByRequest(new SubjectSelect()));
    List<People> peopleList = DBHelper.getAllByRequest(new PeopleSelect());
    teacherList.addAll(peopleList.stream().filter((people -> people.getType().equals("P"))).collect(Collectors.toList()));
    studentList.addAll(peopleList.stream().filter((people -> people.getType().equals("S"))).collect(Collectors.toList()));
    studentField.setItems(studentList);
    teacherField.setItems(teacherList);
    subjectField.setItems(subjectsList);
  }

  public static void showAsDialog(MainApp app, @NotNull Marks mark) {
    FXMLLoader loader = app.createLoader(LayoutRes.ADD_EDIT_MARKS);
    AnchorPane dialogLayout = app.getPaneFromLoader(loader);
    AddEditMarksDialogController controller = loader.getController();
    controller.setMark(mark);

    String title = mark.isEmpty() ? "Add marks" : "Edit marks";
    Stage dialogStage = new DialogStageHelper.Builder(app)
        .setPane(dialogLayout)
        .setTitle(title)
        .build()
        .createDialogStage();

    controller.dialogStage = dialogStage;

    dialogStage.showAndWait();
  }

  @FXML
  private void onOKClick() {
    if (mark != null) {
//      people.setFirstName(firstNameField.getText());
//      people.setLastName(lastNameField.getText());
//      people.setFatherName(fatherNameField.getText());
//      people.setGroupId(groupField.getSelectionModel().getSelectedItem().getId());
//      people.setGroupName(groupField.getSelectionModel().getSelectedItem().getName());
//      people.setType(typeField.getText());
    }
    dialogStage.close();
  }

  @FXML
  private void onCloseClick() {
    dialogStage.close();
  }

  public void setMark(Marks mark) {
    this.mark = mark;
    int selectedStudentIndex = 0;
    int selectedTeacherIndex = 0;
    int selectedSubjectIndex = 0;

    for (int i = 0; i < studentList.size(); i++) {
      if (studentList.get(i).getId() == mark.getStudentId()) {
        selectedStudentIndex = i;
        break;
      }
    }

    for (int i = 0; i < teacherList.size(); i++) {
      if (teacherList.get(i).getId() == mark.getTeacherId()) {
        selectedTeacherIndex = i;
        break;
      }
    }

    for (int i = 0; i < subjectsList.size(); i++) {
      if (studentList.get(i).getId() == mark.getSubjectId()) {
        selectedSubjectIndex = i;
        break;
      }
    }

    studentField.getSelectionModel().select(selectedStudentIndex);
    teacherField.getSelectionModel().select(selectedTeacherIndex);
    subjectField.getSelectionModel().select(selectedSubjectIndex);
    markField.setText(mark.getValue() + "");
  }


}
