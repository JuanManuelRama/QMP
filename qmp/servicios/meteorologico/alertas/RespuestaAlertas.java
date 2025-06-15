package qmp.servicios.meteorologico.alertas;

import java.time.LocalDateTime;
import java.util.List;

public record RespuestaAlertas(List<Alertas> alertas, LocalDateTime fechaExpiracion) {

  public boolean isExpired() {
    return LocalDateTime.now().isAfter(fechaExpiracion);
  }
}

