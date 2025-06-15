package qmp.guardarropa.sugerencia;

import qmp.guardarropa.Guardarropa;
import qmp.prenda.Prenda;
import qmp.Usuario;

public class SugerenciaAdd extends Sugerencia {

  public SugerenciaAdd(Usuario sugeridor, Prenda prenda, Guardarropa guardarropa) {
    super(sugeridor, prenda, guardarropa);
  }

  @Override
  public void exec(Guardarropa guardarropa) {
    guardarropa.addPrenda(this.getPrenda());
  }

  @Override
  public void rollback(Guardarropa guardarropa) {
    guardarropa.eliminarPrenda(this.getPrenda());
  }


}
