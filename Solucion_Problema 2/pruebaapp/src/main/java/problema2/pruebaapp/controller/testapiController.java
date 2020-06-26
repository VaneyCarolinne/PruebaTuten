package problema2.pruebaapp.controller;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import problema2.pruebaapp.Services.testapiService;
import problema2.pruebaapp.commands.testapiForm;
import problema2.pruebaapp.converters.testapiToTestapiForm;
import problema2.pruebaapp.domain.testapi;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;



@RestController
@RequestMapping("/RestApi")
public class testapiController {

  private testapiService apiService;
  private testapiToTestapiForm apiToapiForm;

  public final static Logger LOGGER = Logger.getLogger("problema2.pruebaapp.testapiController");

  @Autowired
  public void settestapiToTestapiForm(testapiToTestapiForm apiToapiForm) {
    this.apiToapiForm = apiToapiForm;
  }

//  @Autowired
//  public void setTestapiService(testapiService apiService) {
//    this.apiService = apiService;
//  }


  @PostMapping("/getTimeZoneUTC_REST")
  public Map getTimeZoneUTC_REST(@RequestBody Map dato1) throws ParseException {
    LOGGER.log(Level.INFO, "VANEY IN this is the input: "+ dato1);
    if(dato1.isEmpty() || dato1.get("dato1") == null || dato1.get("dato1") == "" ||
      dato1.get("dato2") == null || dato1.get("dato2") == ""){
      LOGGER.log(Level.INFO, "ERROR PROBLEMA EN EL JSON DE ENTRADA ");
      dato1.put("ERROR: ", "EL JSON DE ENTRADA ES INVALIDO");

      return dato1;
    }else{

      int Hour = Integer.parseInt(dato1.get("dato1").toString().split(":")[0]);
      String split1 = dato1.get("dato1").toString().substring(3,5);
      int Min = Integer.parseInt(split1);
      String split2 = dato1.get("dato1").toString().substring(6,8);
      int Sec = Integer.parseInt(split2);
      LOGGER.log(Level.INFO, "VANEY IN Datos para sumar: "+Hour+" "+Min+" "+Sec);

      //validando zona horaria a sumar o restar
      int timeZone = Integer.parseInt(dato1.get("dato2").toString().split(":")[0]);

      if(dato1.get("dato2").toString().length()>3){
        if(timeZone > 0) {
          Min = Integer.parseInt(dato1.get("dato2").toString().substring(2, 4)) + Min;
//        if(dato1.get("dato2").toString().length()>4)
//          Sec = Integer.parseInt(dato1.get("dato2").toString().substring(5, 7)) + Sec;
        }else {
          Min = Integer.parseInt(dato1.get("dato2").toString().substring(3, 5)) + Min;
//        if(dato1.get("dato2").toString().length()>6)
//          Sec = Integer.parseInt(dato1.get("dato2").toString().substring(6, 8)) + Sec;
        }
      }

      timeZone=timeZone*-1;
      LOGGER.log(Level.INFO, "VANEY IN Datos TIMEZONE "+timeZone);
      Map response = new HashMap();
      Map data = new HashMap();

      if(Min > 59){
        if(Hour+1 > 23)
          Hour = 0;
        else
          Hour++;
        if(Min == 60){
          Min = 0;
        }else{
          Min = Min - 59;
        }

      }

      if(Hour+timeZone > 23){
        if(Hour+timeZone == 24){
          Hour = 0;
        }else{
          Hour=Hour+timeZone-23;
        }
      }else{
        Hour=Hour+timeZone;
      }

      if(Hour < 0){
        Hour=Hour*-1;
      }

      String HourString = "";

      if(Hour >= 0 && Hour < 10){
        HourString = "0"+String.valueOf(Hour);
      }else{
        HourString = String.valueOf(Hour);
      }

      String time = HourString+":"+String.valueOf(Min)+":"+String.valueOf(Sec);
      if(Min == 0){
        time = HourString+":"+String.valueOf(Min)+"0"+":"+String.valueOf(Sec);
      }


      response.put("timezone", "UTC");
      response.put("time", time);
      data.put("response", response);





      LOGGER.log(Level.INFO, "RESPONSE: ", response);
      return data;


    }
  }


}
