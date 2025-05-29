package QMP.Clima;

import java.time.Duration;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather extends ServicioMeteorologico {

  private final AccuWeatherApi accuWeatherApi;

  public ServicioMeteorologicoAccuWeather(AccuWeatherApi accuWeatherApi, Duration periodoValidez) {
    super(periodoValidez);
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
