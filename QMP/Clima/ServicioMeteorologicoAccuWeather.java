package QMP.Clima;

import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {

  private final AccuWeatherApi accuWeatherApi;

  public ServicioMeteorologicoAccuWeather(AccuWeatherApi accuWeatherApi) {
    this.accuWeatherApi = accuWeatherApi;
  }


  @Override
  public EstadoClima getClima(String ciudad) {
    Map<String, Object> clima = accuWeatherApi.getWeather(ciudad);
    return new EstadoClima(
        (double) clima.get("Temperatura"),
        Humedad.getHumedad((double) clima.get("Humedad")));
  }
}
