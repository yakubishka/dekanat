package dekanat.controllers.dialogs;

import com.sun.istack.NotNull;
import dekanat.app.DialogStageHelper;
import dekanat.app.MainApp;
import dekanat.model.db.Groups;
import dekanat.model.db.Subjects;
import dekanat.resources.LayoutRes;
import dekanat.utils.AlertHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddEditSubjectDialogController {

  @FXML
  private TextField subjectNameTextField;

  private Subjects subjects;
  private Stage dialogStage;

  @FXML
  private void initialize() { }

  public static void showAsDialog(MainApp app, @NotNull Subjects subjects) {
    FXMLLoader loader = app.createLoader(LayoutRes.ADD_EDIT_SUBJECTS);
    AnchorPane dialogLayout = app.getPaneFromLoader(loader);

    AddEditSubjectDialogController controller = loader.getController();
    controller.setSubjects(subjects);

    String title = subjects.isEmpty() ? "Add subject" : "Edit subject";
    Stage dialogStage = new DialogStageHelper.Builder(app)
        .setPane(dialogLayout)
        .setTitle(title)
        .build()
        .createDialogStage();

    controller.dialogStage = dialogStage;

    dialogStage.showAndWait();
  }

  @FXML
  private void onOkClick() {
    if (isInputValid()) {
      if (subjects != null)
        subjects.setName(subjectNameTextField.getText());
      dialogStage.close();
    }
  }

  @FXML
  private void onCloseClick() {
    dialogStage.close();
  }

  public boolean isInputValid() {
    String errorMessage = "";

    if (subjectNameTextField.getText() == null || subjectNameTextField.getText().length() == 0)
      errorMessage += "No valid subject name!\n";

    if (errorMessage.length() == 0) {
      return true;
    } else {
      AlertHelper.createErrorAlert(dialogStage, errorMessage);
      return false;
    }
  }

  public void setSubjects(Subjects subjects) {
    this.subjects = subjects;
    subjectNameTextField.setText(subjects.getName());
  }
}
