package qmp.prenda.sugerencia;

import qmp.servicios.meteorologico.ServicioMeteorologico;
import qmp.prenda.Prenda;
import qmp.Usuario;
import java.util.function.Predicate;

public class MotorSugerenciaClima extends MotorSugerencia {
  private final ServicioMeteorologico servicioMeteorologico;

  public MotorSugerenciaClima(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  @Override
  protected Predicate<Prenda> filtroPropio(Usuario usuario) {
    return prenda ->
        prenda.sirveEnClima(servicioMeteorologico.getClima(usuario.getCiudad()));
  }
}
