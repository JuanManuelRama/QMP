package qmp.servicios.meteorologico;

import java.util.List;
import java.util.Map;

//Es interface porque no la implemente, esto en realidad es una clase definida que se importa
public interface AccuWeatherApi {
  Map<String, Object> getWeather(String city);
  Map<String, List<String>> getAlerts(String city);
}
