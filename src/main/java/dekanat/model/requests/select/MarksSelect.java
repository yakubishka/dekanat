package dekanat.model.requests.select;

import dekanat.model.db.Marks;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksSelect implements Selectable<Marks> {
  @Override
  public String getSelectRequest() {
    return "with students_marks as "
        + "(select marks.*, subjects.name as subject_name, people.last_name as student_name"
        + " from marks left join subjects on marks.subject_id = subjects.id "
        + "left join people on people.id = marks.student_id)"
        + " select students_marks.*, people.last_name as teacher_name from students_marks "
        + "left join people on students_marks.teacher_id = people.id;";
  }

  @Override
  public Marks buildFromResult(ResultSet resultSet) throws SQLException {
    long id = resultSet.getLong("id");
    long studentId = resultSet.getLong("student_id");
    long subjectId = resultSet.getLong("subject_id");
    long teacherId = resultSet.getLong("teacher_id");
    String teacherName= resultSet.getString("teacher_name");
    String studentName= resultSet.getString("student_name");
    String subjectName = resultSet.getString("subject_name");
    int mark = resultSet.getInt("value");
    return new Marks(id, studentId, studentName, teacherId, teacherName, subjectId, subjectName,  mark);
  }
}
