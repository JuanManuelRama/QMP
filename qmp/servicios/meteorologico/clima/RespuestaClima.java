package qmp.servicios.meteorologico.clima;

import java.time.LocalDateTime;

public record RespuestaClima(EstadoClima clima, LocalDateTime fechaExpiracion) {

  public boolean isExpired() {
    return LocalDateTime.now().isAfter(fechaExpiracion);
  }
}
