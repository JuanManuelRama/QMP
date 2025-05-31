package QMP.Clima;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologicoCacheado {
  private final Duration periodoValidez;
  private final Map<String, RespuestaClima> consultas = new HashMap<>();
  private final ServicioMeteorologico servicioMeteorologico;

  public ServicioMeteorologicoCacheado(Duration periodoValidez,
                                       ServicioMeteorologico servicioMeteorologico) {
    this.periodoValidez = periodoValidez;
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public EstadoClima getClima(String ciudad) {
    if(consultas.containsKey(ciudad) || consultas.get(ciudad).isExpired()) {
      consultas.put(ciudad, new RespuestaClima(servicioMeteorologico.getClima(ciudad),
          LocalDateTime.now().plus(periodoValidez)));
    }
    return consultas.get(ciudad).clima();
  }
}
