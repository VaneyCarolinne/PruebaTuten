package problema2.pruebaapp.converters;


import problema2.pruebaapp.commands.testapiForm;
import problema2.pruebaapp.domain.testapi;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class testapiToTestapiForm implements Converter<testapi, testapiForm>{

  @Override
  public testapiForm convert(testapi api) {
    testapiForm apForm = new testapiForm();
    apForm.setId(api.getId());
    apForm.setDato1(api.getDato1());
    apForm.setDato2(api.getDato2());

    return apForm;
  }
}
