package problema2.pruebaapp.Services;


import problema2.pruebaapp.commands.testapiForm;
import problema2.pruebaapp.domain.testapi;


import java.text.ParseException;
import java.util.Map;
import java.util.logging.Logger;

import java.util.List;

public interface testapiService {




  public final static Logger LOGGER = Logger.getLogger(" problema2.pruebaapp.Services");

  List<testapi> listAll();

  testapi getById(Integer id);

  testapi saveOrUpdate(testapi api);

  void delete(Integer id);

  testapi saveOrUpdateTestapiForm(testapiForm apiForm);

  public Boolean getTimeZoneUTC(Map response) throws ParseException;




}
