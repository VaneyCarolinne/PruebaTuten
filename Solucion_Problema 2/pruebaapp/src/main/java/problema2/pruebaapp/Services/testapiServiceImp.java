package problema2.pruebaapp.Services;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import problema2.pruebaapp.commands.testapiForm;
import problema2.pruebaapp.converters.testapiFormToTestapi;
import problema2.pruebaapp.domain.testapi;
import problema2.pruebaapp.repository.testapiRepository;

import java.text.ParseException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

public class testapiServiceImp implements testapiService{

  public final static Logger LOGGER = Logger.getLogger("problema2.pruebaapp.ServicesImp");

  private testapiRepository apiRepository;
  private testapiFormToTestapi apiFormToTestapi;

  @Autowired
  public testapiServiceImp(testapiRepository apiRepository, testapiFormToTestapi apiFormToTestapi) {
    this.apiRepository = apiRepository;
    this.apiFormToTestapi = apiFormToTestapi;
  }

  @Override
  public List<testapi> listAll() {
//    List<testapi> products = new ArrayList<>();
//    apiRepository.findAll().forEach(testapi::add); //fun with Java 8
//    return products;
    return null;
  }

  @Override
  public testapi getById(Integer id) {
    return apiRepository.findById(id).orElse(null);
  }

  @Override
  public testapi saveOrUpdate(testapi api) {
    apiRepository.save(api);
    return api;
  }

  @Override
  public void delete(Integer id) {
    apiRepository.deleteById(id);
  }

  @Override
  public testapi saveOrUpdateTestapiForm(testapiForm apiForm) {
    testapi savedApi = saveOrUpdate(apiFormToTestapi.convert(apiForm));
    LOGGER.log(Level.INFO, "this is the IDapi Saved: ", savedApi.getId());
    return savedApi;
  }

  @Override
  public Boolean getTimeZoneUTC(Map response) throws ParseException {

      //Validando
      testapiForm api = new testapiForm();
      api.setDato1(response.get("time").toString());
      api.setDato2(response.get("timezone").toString());

      final testapi testapi = this.saveOrUpdateTestapiForm(api);


    return true;
  }
}
