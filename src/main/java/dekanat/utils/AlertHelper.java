package dekanat.utils;

import javafx.scene.control.Alert;
import javafx.stage.Window;

public class AlertHelper {

  public static void createErrorAlert(Window owner, String errorMessage) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.initOwner(owner);
    alert.setTitle("Invalid Fields");
    alert.setHeaderText("Please correct invalid fields");
    alert.setContentText(errorMessage);
    alert.showAndWait();
  }

}
