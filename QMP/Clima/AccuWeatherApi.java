package QMP.Clima;

import java.util.Map;

//es interface porque no la implemente, esto en realidad es una clase definida que se importa
public interface AccuWeatherApi {
  public Map<String, Object> getWeather(String city);
}
