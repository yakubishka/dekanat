package dekanat.controllers.dialogs;

import com.sun.istack.NotNull;
import dekanat.app.DialogStageHelper;
import dekanat.app.MainApp;
import dekanat.model.db.Groups;
import dekanat.model.db.People;
import dekanat.model.requests.select.GroupsSelect;
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

public class AddEditPeopleDialogController {

  @FXML
  private TextField firstNameField;

  @FXML
  private TextField lastNameField;

  @FXML
  private TextField fatherNameField;

  @FXML
  private ComboBox<Groups> groupField;

  @FXML
  private TextField typeField;

  private People people;
  private Stage dialogStage;
  private final ObservableList<Groups> groupsList = FXCollections.observableArrayList();

  @FXML
  private void initialize() {
    groupsList.addAll(DBHelper.getAllByRequest(new GroupsSelect()));
    groupField.setItems(groupsList);
  }

  public static void showAsDialog(MainApp app, @NotNull People people) {
    FXMLLoader loader = app.createLoader(LayoutRes.ADD_EDIT_PEOPLE);
    AnchorPane dialogLayout = app.getPaneFromLoader(loader);

    AddEditPeopleDialogController controller = loader.getController();
    controller.setPeople(people);

    String title = people.isEmpty() ? "Add people" : "Edit people";
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
      if (people != null) {
        people.setFirstName(firstNameField.getText());
        people.setLastName(lastNameField.getText());
        people.setFatherName(fatherNameField.getText());
        people.setGroupId(groupField.getSelectionModel().getSelectedItem().getId());
        people.setGroupName(groupField.getSelectionModel().getSelectedItem().getName());
        people.setType(typeField.getText());
      }
      dialogStage.close();
  }

  @FXML
  private void onCloseClick() {
    dialogStage.close();
  }

  public void setPeople(People people) {
    this.people = people;
    firstNameField.setText(people.getFirstName());
    lastNameField.setText(people.getLastName());
    fatherNameField.setText(people.getFatherName());
    typeField.setText(people.getType());

    int selectedIndex = 0;
    for (int i = 0; i < groupsList.size(); i++) {
      if (people.getGroupId() == groupsList.get(i).getId())
        selectedIndex = i;
    }
    groupField.getSelectionModel().select(selectedIndex);
  }

}
