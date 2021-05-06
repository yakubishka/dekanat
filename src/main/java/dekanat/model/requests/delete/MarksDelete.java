package dekanat.model.requests.delete;

public class MarksDelete implements Deletable{
  @Override
  public String getDeleteByIdRequest(long id) {
    return "delete from marks where id = " + id;
  }
}
