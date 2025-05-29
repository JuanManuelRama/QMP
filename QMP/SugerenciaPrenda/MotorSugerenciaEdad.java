package QMP.SugerenciaPrenda;

import QMP.Clima.ServicioMeteorologico;
import QMP.Prenda.Formalidad;
import QMP.Prenda.Prenda;
import QMP.Usuario;
import java.util.function.Predicate;

public class MotorSugerenciaEdad extends MotorSugerencia {

  public MotorSugerenciaEdad() {
  }

  @Override
  protected Predicate<Prenda> filtroPropio(Usuario usuario) {
    return prenda -> usuario.getEdad() <= 50
        || prenda.formalidad().equals(Formalidad.FORMAL);
  }
}
