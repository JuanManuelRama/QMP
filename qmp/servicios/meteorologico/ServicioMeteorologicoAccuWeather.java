package qmp.servicios.meteorologico;

import qmp.Ciudad;
import qmp.servicios.meteorologico.alertas.Alertas;
import qmp.servicios.meteorologico.clima.EstadoClima;
import qmp.servicios.meteorologico.clima.Humedad;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {

  private final AccuWeatherApi accuWeatherApi;

  public ServicioMeteorologicoAccuWeather(AccuWeatherApi accuWeatherApi) {
    this.accuWeatherApi = accuWeatherApi;
  }


  @Override
  public EstadoClima getClima(Ciudad ciudad) {
    Map<String, Object> clima = accuWeatherApi.getWeather(ciudad.getNombre());
    return new EstadoClima(
        (double) clima.get("Temperatura"),
        Humedad.getHumedad((double) clima.get("Humedad")));
  }

  @Override
  public List<Alertas> getAlertas(Ciudad ciudad) {
    return (accuWeatherApi.getAlerts(ciudad.getNombre()).get("CurrentAlerts")
        .stream().map(this::getAlerta)).collect(Collectors.toList());
  }

  private Alertas getAlerta(String alerta) {
    return switch (alerta) {
      case "STORM" -> Alertas.TORMENTA;
      case "HAIL" -> Alertas.GRANIZO;
      default -> throw new IllegalArgumentException("Alerta invalida");
    };
  }
}
