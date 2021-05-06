package dekanat.model.requests.delete;

public class PeopleDelete implements Deletable {
  @Override
  public String getDeleteByIdRequest(long id) {
    return "delete from people where id = " + id;
  }
}
