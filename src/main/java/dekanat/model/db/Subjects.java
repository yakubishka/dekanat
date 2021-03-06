package dekanat.model.db;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subjects implements CSVWriteable {

  private LongProperty id;
  private StringProperty name;

  public Subjects(long id, String name) {
    this.id = new SimpleLongProperty(id);
    this.name = new SimpleStringProperty(name);
  }

  public long getId() {
    return id.get();
  }

  public LongProperty idProperty() {
    return id;
  }

  public void setId(long id) {
    this.id.set(id);
  }

  public String getName() {
    return name.get();
  }

  public StringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public boolean isEmpty() {
    return id.getValue() == -1 && name.getValue().isEmpty();
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public String getRow() {
    return String.join(",", getId() + "", getName()) + "\n";
  }

  @Override
  public String getHeader() {
    return "id, name\n";
  }
}
