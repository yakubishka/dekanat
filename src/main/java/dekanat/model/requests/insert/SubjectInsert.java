package dekanat.model.requests.insert;

import dekanat.model.db.Subjects;
import dekanat.model.requests.select.SubjectSelect;

public class SubjectInsert extends SubjectSelect {

  private final Subjects subject;

  public SubjectInsert(Subjects subject) {
    this.subject = subject;
  }

  @Override
  public String getSelectRequest() {
    return "insert into \"subjects\" (\"name\") values ('" + subject.getName() + "') returning *;";
  }

}
