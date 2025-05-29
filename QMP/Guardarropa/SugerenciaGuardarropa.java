package QMP.Guardarropa;

import QMP.Prenda.Prenda;
import QMP.Usuario;

public abstract class SugerenciaGuardarropa {
  private final Usuario sugeridor;
  private final Prenda prenda;
  private final Guardarropa guardarropa;
  protected EstadoSugerencia estado = EstadoSugerencia.PENDENTE;

  public SugerenciaGuardarropa(Usuario sugeridor, Prenda prenda, Guardarropa guardarropa) {
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
    if(this.estado != EstadoSugerencia.PENDENTE) {
      throw new SugerenciaException("Sugerencia ya tratada");
    }
    estado = EstadoSugerencia.ACEPTADA;
    this.exec(guardarropa);
  }

  public void rechazar() {
    if(this.estado == EstadoSugerencia.RECHAZADA) {
      throw new SugerenciaException("Sugerencia ya rechazada");
    }
    if (this.estado == EstadoSugerencia.ACEPTADA) {
      this.rollback(guardarropa);
    }
    estado = EstadoSugerencia.RECHAZADA;
  }


  protected abstract void exec(Guardarropa guardarropa);
  protected abstract void rollback(Guardarropa guardarropa);

}
