package QMP.Clima;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public abstract class ServicioMeteorologico {
  private final Duration periodoValidez;
  private final Map<String, RespuestaClima> consultas = new HashMap<>();

  public ServicioMeteorologico(Duration periodoValidez) {
    this.periodoValidez = periodoValidez;
  }

  public EstadoClima getEstadoClima(String ciudad) {
    if(consultas.containsKey(ciudad) || consultas.get(ciudad).isExpired()) {
      consultas.put(ciudad, new RespuestaClima(this.getClima(ciudad),
          LocalDateTime.now().plus(periodoValidez)));
    }
    return consultas.get(ciudad).clima();
  }

  protected abstract EstadoClima getClima(String ciudad);

}
