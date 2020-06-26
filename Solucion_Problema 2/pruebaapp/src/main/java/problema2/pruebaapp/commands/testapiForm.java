package problema2.pruebaapp.commands;

import problema2.pruebaapp.domain.testapi;

public class testapiForm {

  private Integer id;
  private String dato1;
  private String dato2;

  public testapiForm() {}

  public testapiForm(Integer id, String d1, String d2) {
    this.id = id;
    this.dato1 = d1;
    this.dato2 = d2;
  }

  public Integer getId() {
    return id;
  }

  public String getDato1() {
    return dato1;
  }

  public String getDato2() {
    return dato2;
  }

  public void setDato2(String dato2) {
    this.dato2 = dato2;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setDato1(String dato1) {
    this.dato1 = dato1;
  }


  public static testapiForm fromModel(testapi entity){
    testapiForm dto = new testapiForm();

    dto.setId(entity.getId());
    dto.setDato1(entity.getDato1());
    dto.setDato2(entity.getDato2());

    return dto;
  }

}
