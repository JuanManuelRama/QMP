package QMP.Guardarropa;

import QMP.Prenda.Prenda;
import QMP.Usuario;

public class SugerenciaEliminar extends SugerenciaPrenda {
  public SugerenciaEliminar(Usuario sugeridor, Prenda prenda) {
    super(sugeridor, prenda);
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
