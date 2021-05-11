package dekanat.app;

import dekanat.architecture.BaseViewController;
import dekanat.controllers.LoginDialogController;
import dekanat.model.User;
import dekanat.resources.LayoutRes;
import dekanat.resources.StringRes;
import dekanat.resources.WindowConstants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application  {

  private Stage primaryStage;
  private BorderPane rootLayout;

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    this.primaryStage.setWidth(WindowConstants.WINDOW_WIDTH);
    this.primaryStage.setHeight(WindowConstants.WINDOW_HEIGHT);
    this.primaryStage.setTitle(StringRes.APP_NAME);
    this.createRootView();
    showTableView();
    LoginDialogController.showAsDialog(this);
  }

  private void createRootView() {
    rootLayout = getPaneFromLoader(createLoader(LayoutRes.ROOT_LAYOUT));
    if (rootLayout != null)
      primaryStage.setScene(new Scene(rootLayout));
    primaryStage.show();
  }

  private void showTableView() {
    FXMLLoader loader = createLoader(LayoutRes.TABLE_VIEW_LAYOUT);
    AnchorPane pane = getPaneFromLoader(loader);
    if (pane != null) {
      if (loader.getController() instanceof BaseViewController)
        ((BaseViewController) loader.getController()).setMainApp(this);
      rootLayout.setCenter(pane);
    }
  }

  public FXMLLoader createLoader(String layoutFileName) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("/layout/" + layoutFileName));
    return loader;
  }

  public <T extends Pane> T getPaneFromLoader(FXMLLoader loader) {
    try {
      return loader.load();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void close() {
    primaryStage.close();
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }

  public static void main(String[] args) { launch(args); }

}
