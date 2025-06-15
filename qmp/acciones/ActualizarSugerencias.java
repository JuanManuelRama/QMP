package qmp.acciones;

import java.util.List;
import qmp.Usuario;
import qmp.servicios.meteorologico.alertas.Alertas;

public class ActualizarSugerencias implements Accion {

  @Override
  public void notificar(Usuario usuario, List<Alertas> alertas) {
    usuario.generarSugerencia();
  }
}
