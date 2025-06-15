package qmp.prenda.sugerencia;

import qmp.prenda.Formalidad;
import qmp.prenda.Prenda;
import qmp.Usuario;
import java.util.function.Predicate;

public class MotorSugerenciaEdad extends MotorSugerencia {

  public MotorSugerenciaEdad() {
  }

  @Override
  protected Predicate<Prenda> filtroPropio(Usuario usuario) {
    return prenda -> !usuario.esAdultoMayor()
        || prenda.formalidad().equals(Formalidad.FORMAL);
  }
}
