package qmp.guardarropa.sugerencia;

import qmp.guardarropa.Guardarropa;
import qmp.prenda.Prenda;
import qmp.Usuario;

public abstract class Sugerencia {
  private final Usuario sugeridor;
  private final Prenda prenda;
  private final Guardarropa guardarropa;
  protected Estado estado = Estado.PENDENTE;

  public Sugerencia(Usuario sugeridor, Prenda prenda, Guardarropa guardarropa) {
    this.sugeridor = sugeridor;
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  public Usuario getSugeridor() {
    return sugeridor;
  }

  public Prenda getPrenda() {
    return prenda;
  }

  public Guardarropa getGuardarropa() {
    return guardarropa;
  }

  public void aceptar() {
    if(this.estado != Estado.PENDENTE) {
      throw new SugerenciaException("Sugerencia ya tratada");
    }
    estado = Estado.ACEPTADA;
    this.exec(guardarropa);
  }

  public void rechazar() {
    if(this.estado == Estado.RECHAZADA) {
      throw new SugerenciaException("Sugerencia ya rechazada");
    }
    if (this.estado == Estado.ACEPTADA) {
      this.rollback(guardarropa);
    }
    estado = Estado.RECHAZADA;
  }


  protected abstract void exec(Guardarropa guardarropa);
  protected abstract void rollback(Guardarropa guardarropa);

}
