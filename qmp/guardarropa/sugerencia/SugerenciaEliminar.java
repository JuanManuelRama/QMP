package qmp.guardarropa.sugerencia;

import qmp.guardarropa.Guardarropa;
import qmp.prenda.Prenda;
import qmp.Usuario;

public class SugerenciaEliminar extends Sugerencia {


  public SugerenciaEliminar(Usuario sugeridor, Prenda prenda, Guardarropa guardarropa) {
    super(sugeridor, prenda, guardarropa);
  }

  @Override
  public void exec(Guardarropa guardarropa) {
    guardarropa.eliminarPrenda(this.getPrenda());
  }

  @Override
  public void rollback(Guardarropa guardarropa) {
    guardarropa.addPrenda(this.getPrenda());
  }
}
