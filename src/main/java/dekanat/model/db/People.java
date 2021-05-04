package dekanat.model.db;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class People {

  private LongProperty id;
  private StringProperty firstName;
  private StringProperty lastName;
  private StringProperty fatherName;
  private LongProperty groupId;
  private StringProperty type;

  public People(long id, String firstName, String lastName, String fatherName, long groupId, String type) {
    this.id = new SimpleLongProperty(id);
    this.firstName = new SimpleStringProperty(firstName);
    this.lastName = new SimpleStringProperty(lastName);
    this.fatherName = new SimpleStringProperty(fatherName);
    this.groupId = new SimpleLongProperty(groupId);
    this.type = new SimpleStringProperty(type);
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

  public String getFirstName() {
    return firstName.get();
  }

  public StringProperty firstNameProperty() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName.set(firstName);
  }

  public String getLastName() {
    return lastName.get();
  }

  public StringProperty lastNameProperty() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName.set(lastName);
  }

  public String getFatherName() {
    return fatherName.get();
  }

  public StringProperty fatherNameProperty() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName.set(fatherName);
  }

  public long getGroupId() {
    return groupId.get();
  }

  public LongProperty groupIdProperty() {
    return groupId;
  }

  public void setGroupId(long groupId) {
    this.groupId.set(groupId);
  }

  public String getType() {
    return type.get();
  }

  public StringProperty typeProperty() {
    return type;
  }

  public void setType(String type) {
    this.type.set(type);
  }
}
