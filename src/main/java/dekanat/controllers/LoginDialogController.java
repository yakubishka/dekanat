package dekanat.controllers;

import com.sun.istack.NotNull;
import dekanat.app.DialogStageHelper;
import dekanat.app.MainApp;
import dekanat.model.User;
import dekanat.model.requests.select.UsersSelect;
import dekanat.resources.LayoutRes;
import dekanat.utils.DBHelper;
import dekanat.utils.UserUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.List;

public class LoginDialogController {

  private Stage dialogStage;
  private MainApp app;

  @FXML
  private TextField loginField;

  @FXML
  private TextField passwordField;

  @FXML
  private void onOkClick() {
    List<User> users = DBHelper.getAllByRequest(new UsersSelect(loginField.getText(), passwordField.getText()));
    if (!users.isEmpty()) {
      User selectedUser = users.get(0);
      System.out.println(selectedUser.getStatus());
      if (selectedUser.getStatus() != null && (selectedUser.getStatus() == 2 || selectedUser.getStatus() == 1)) {
        UserUtils.setUser(users.get(0));
        dialogStage.close();
      }
    }
  }

  @FXML
  private void onExitClick() {
    dialogStage.close();
    app.close();
  }


  public static void showAsDialog(MainApp app) {
    FXMLLoader loader = app.createLoader(LayoutRes.LOGIN_LAYOUT);
    AnchorPane dialogLayout = app.getPaneFromLoader(loader);

    LoginDialogController controller = loader.getController();

    Stage dialogStage = new DialogStageHelper.Builder(app)
        .setPane(dialogLayout)
        .setTitle("Authorize")
        .build()
        .createDialogStage();

    controller.dialogStage = dialogStage;
    controller.app = app;

    dialogStage.showAndWait();
  }

}
