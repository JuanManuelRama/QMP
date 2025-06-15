package qmp.prenda.sugerencia;

import qmp.prenda.Prenda;
import qmp.Usuario;
import java.util.function.Predicate;

public class MotorSugerenciaTodas extends MotorSugerencia {

  public MotorSugerenciaTodas() {
  }

  @Override
  protected Predicate<Prenda> filtroPropio(Usuario usuario) {
    return prenda -> true;
  }
}
