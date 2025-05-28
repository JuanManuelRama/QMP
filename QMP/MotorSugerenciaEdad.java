package QMP;

import QMP.Clima.ServicioMeteorologico;
import QMP.Prenda.Formalidad;
import QMP.Prenda.Prenda;
import java.util.function.Predicate;

public class MotorSugerenciaEdad extends MotorSugerencia {

  public MotorSugerenciaEdad(ServicioMeteorologico servicioMeteorologico) {
    super(servicioMeteorologico);
  }

  @Override
  protected Predicate<Prenda> filtroPropio(Usuario usuario) {
    return prenda -> usuario.getEdad() <= 50
        || prenda.getFormalidad().equals(Formalidad.FORMAL);
  }
}
