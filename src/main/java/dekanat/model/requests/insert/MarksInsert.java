package dekanat.model.requests.insert;

import dekanat.model.db.Marks;
import dekanat.model.requests.select.MarksSelect;

public class MarksInsert extends MarksSelect {

  private final Marks marks;

  public MarksInsert(Marks marks) {
    this.marks = marks;
  }

  @Override
  public String getSelectRequest() {
    return "";
  }

}
