package QMP.Guardarropa;

import QMP.Prenda.Prenda;
import QMP.Usuario;

public class SugerenciaAdd extends SugerenciaGuardarropa {

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
