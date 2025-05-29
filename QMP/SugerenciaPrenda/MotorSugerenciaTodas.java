package QMP.SugerenciaPrenda;

import QMP.Clima.ServicioMeteorologico;
import QMP.Prenda.Prenda;
import QMP.Usuario;
import java.util.function.Predicate;

public class MotorSugerenciaTodas extends MotorSugerencia {

  public MotorSugerenciaTodas() {
  }

  @Override
  protected Predicate<Prenda> filtroPropio(Usuario usuario) {
    return prenda -> true;
  }
}
