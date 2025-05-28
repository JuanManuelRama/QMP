package QMP;

import QMP.Clima.ServicioMeteorologico;
import QMP.Prenda.Prenda;
import java.util.function.Predicate;

public class MotorSugerenciaTodas extends MotorSugerencia {

  public MotorSugerenciaTodas(ServicioMeteorologico servicioMeteorologico) {
    super(servicioMeteorologico);
  }

  @Override
  protected Predicate<Prenda> filtroPropio(Usuario usuario) {
    return prenda -> true;
  }
}
