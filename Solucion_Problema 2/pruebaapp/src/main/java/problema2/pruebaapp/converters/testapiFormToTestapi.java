package problema2.pruebaapp.converters;

import problema2.pruebaapp.commands.testapiForm;
import problema2.pruebaapp.domain.testapi;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class testapiFormToTestapi implements Converter<testapiForm, testapi>   {

  @Override
  public testapi convert(testapiForm testapiForm) {
    testapi api = new testapi();
    if (testapiForm.getId() != null  && !StringUtils.isEmpty(testapiForm.getId())) {
      api.setId(new Integer(testapiForm.getId()));
    }
    api.setId(testapiForm.getId());
    api.setDato1(testapiForm.getDato1());
    api.setDato2(testapiForm.getDato2());
    return api;
  }


}
