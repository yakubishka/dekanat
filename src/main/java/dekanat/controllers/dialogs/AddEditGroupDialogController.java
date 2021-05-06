package dekanat.controllers.dialogs;

import com.sun.istack.NotNull;
import dekanat.app.DialogStageHelper;
import dekanat.app.MainApp;
import dekanat.model.db.Groups;
import dekanat.resources.LayoutRes;
import dekanat.utils.AlertHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddEditGroupDialogController {

  @FXML
  private TextField groupNameTextField;

  private Groups group;
  private Stage dialogStage;

  @FXML
  private void initialize() { }

  public static void showAsDialog(MainApp app, @NotNull Groups group) {
    FXMLLoader loader = app.createLoader(LayoutRes.ADD_EDIT_GROUPS);
    AnchorPane dialogLayout = app.getPaneFromLoader(loader);

    AddEditGroupDialogController controller = loader.getController();
    controller.group = group;

    String title = group.isEmpty() ? "Add group" : "Edit group";
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
      if (group != null) {
        group.setName(groupNameTextField.getText());
      }
      dialogStage.close();
    }
  }

  @FXML
  private void onCloseClick() {
    dialogStage.close();
  }

  public boolean isInputValid() {
    String errorMessage = "";

    if (groupNameTextField.getText() == null || groupNameTextField.getText().length() == 0)
      errorMessage += "No valid group name!\n";

    if (errorMessage.length() == 0) {
      return true;
    } else {
      AlertHelper.createErrorAlert(dialogStage, errorMessage);
      return false;
    }
  }

}
