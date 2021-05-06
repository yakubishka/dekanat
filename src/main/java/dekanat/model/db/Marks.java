package dekanat.model.db;

import javafx.beans.property.*;

public class Marks {

  private LongProperty id;
  private LongProperty studentId;
  private StringProperty studentName;
  private LongProperty teacherId;
  private StringProperty teacherName;
  private LongProperty subjectId;
  private StringProperty subjectName;
  private IntegerProperty value;

  public Marks(long id,
               long studentId,
               String studentName,
               long teacherId,
               String teacherName,
               long subjectId,
               String subjectName,
               int value
  ) {
    this.id = new SimpleLongProperty(id);
    this.studentId = new SimpleLongProperty(studentId);
    this.studentName = new SimpleStringProperty(studentName);
    this.teacherId = new SimpleLongProperty(teacherId);
    this.teacherName = new SimpleStringProperty(teacherName);
    this.subjectId = new SimpleLongProperty(subjectId);
    this.subjectName = new SimpleStringProperty(subjectName);
    this.value = new SimpleIntegerProperty(value);
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

  public long getStudentId() {
    return studentId.get();
  }

  public LongProperty studentIdProperty() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId.set(studentId);
  }

  public long getTeacherId() {
    return teacherId.get();
  }

  public LongProperty teacherIdProperty() {
    return teacherId;
  }

  public void setTeacherId(long teacherId) {
    this.teacherId.set(teacherId);
  }

  public long getSubjectId() {
    return subjectId.get();
  }

  public LongProperty subjectIdProperty() {
    return subjectId;
  }

  public void setSubjectId(long subjectId) {
    this.subjectId.set(subjectId);
  }

  public int getValue() {
    return value.get();
  }

  public IntegerProperty valueProperty() {
    return value;
  }

  public void setValue(int value) {
    this.value.set(value);
  }

  public String getStudentName() {
    return studentName.get();
  }

  public StringProperty studentNameProperty() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName.set(studentName);
  }

  public String getTeacherName() {
    return teacherName.get();
  }

  public StringProperty teacherNameProperty() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName.set(teacherName);
  }

  public String getSubjectName() {
    return subjectName.get();
  }

  public StringProperty subjectNameProperty() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName.set(subjectName);
  }
}
