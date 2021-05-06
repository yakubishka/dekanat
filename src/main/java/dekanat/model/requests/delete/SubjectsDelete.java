package dekanat.model.requests.delete;

public class SubjectsDelete implements Deletable{
  @Override
  public String getDeleteByIdRequest(long id) {
    return "delete from subjects where id = " + id;
  }
}
