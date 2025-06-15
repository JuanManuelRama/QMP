package qmp.servicios.meteorologico;

import qmp.Ciudad;
import qmp.servicios.meteorologico.alertas.Alertas;
import qmp.servicios.meteorologico.alertas.RespuestaAlertas;
import qmp.servicios.meteorologico.clima.EstadoClima;
import qmp.servicios.meteorologico.clima.RespuestaClima;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioMeteorologicoCacheado implements ServicioMeteorologico {
  private final Duration periodoValidez;
  private final Map<Ciudad, RespuestaClima> consultasClima = new HashMap<>();
  private final Map<Ciudad, RespuestaAlertas> consultasAlertas = new HashMap<>();
  private final ServicioMeteorologico servicioMeteorologico;

  public ServicioMeteorologicoCacheado(Duration periodoValidez,
                                       ServicioMeteorologico servicioMeteorologico) {
    this.periodoValidez = periodoValidez;
    this.servicioMeteorologico = servicioMeteorologico;
  }

  @Override
  public EstadoClima getClima(Ciudad ciudad) {
    if (consultasClima.containsKey(ciudad) || consultasClima.get(ciudad).isExpired()) {
      consultasClima.put(ciudad, new RespuestaClima(servicioMeteorologico.getClima(ciudad),
          LocalDateTime.now().plus(periodoValidez)));
    }
    return consultasClima.get(ciudad).clima();
  }

  @Override
  public List<Alertas> getAlertas(Ciudad ciudad) {
    if (consultasAlertas.containsKey(ciudad) || consultasAlertas.get(ciudad).isExpired()) {
      consultasAlertas.put(ciudad, new RespuestaAlertas(servicioMeteorologico.getAlertas(ciudad),
          LocalDateTime.now().plus(periodoValidez)));
    }
    return consultasAlertas.get(ciudad).alertas();
    }
}
