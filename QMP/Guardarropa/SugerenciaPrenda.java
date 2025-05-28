package QMP.Guardarropa;

import QMP.EstadoSugerencia;
import QMP.Prenda.Prenda;
import QMP.Usuario;

public abstract class SugerenciaPrenda {
  private final Usuario sugeridor;
  private final Prenda prenda;
  private final Guardarropa guardarropa;
  protected EstadoSugerencia estado = EstadoSugerencia.PENDENTE;

  public SugerenciaPrenda(Usuario sugeridor, Prenda prenda, Guardarropa guardarropa) {
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
      throw new RuntimeException("Sugerencia ya tratada");
    }
    estado = EstadoSugerencia.ACEPTADA;
    this.exec(guardarropa);
  }

  public void rechazar() {
    if(this.estado == EstadoSugerencia.RECHAZADA) {
      throw new RuntimeException("Sugerencia ya rechazada");
    }
    if (this.estado == EstadoSugerencia.ACEPTADA) {
      this.rollback(guardarropa);
    }
    estado = EstadoSugerencia.RECHAZADA;
  }


  protected abstract void exec(Guardarropa guardarropa);
  protected abstract void rollback(Guardarropa guardarropa);

}
