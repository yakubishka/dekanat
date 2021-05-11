package dekanat.architecture;

import dekanat.app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public abstract class BaseTabViewController<T> {

  @FXML
  protected TableView<T> tableView;

  protected BaseTabViewPresenter<T> presenter;

  protected MainApp app;

  public void setMainApp(MainApp app) {
    this.app = app;
    presenter.setMainApp(app);
  }

  @FXML
  protected void initialize() {
    presenter = createPresenter();
    presenter.loadData();
    tableView.setItems(presenter.getList());
  }

  public void onInsertClick() {
    presenter.onInsert();
  }

  public void onDeleteClick() {
    presenter.onDelete(tableView.getSelectionModel().getSelectedIndex());
  }

  public void onEditClick() {
    presenter.onEdit(tableView.getSelectionModel().getSelectedIndex());
  }

  public abstract BaseTabViewPresenter<T> createPresenter();

  public abstract void exportToFile();

  public void reloadList() {
    presenter.reloadList();
  }

}
