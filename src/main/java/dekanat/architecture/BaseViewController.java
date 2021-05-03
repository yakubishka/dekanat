package dekanat.architecture;


import dekanat.app.MainApp;

public abstract class BaseViewController {

  protected MainApp app;

  public void setMainApp(MainApp app) {
    this.app = app;
  }

}