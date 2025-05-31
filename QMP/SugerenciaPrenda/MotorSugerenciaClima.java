package QMP.SugerenciaPrenda;

import QMP.Clima.ServicioMeteorologico;
import QMP.Prenda.Prenda;
import QMP.Usuario;
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
