package qmp.acciones;

import qmp.Usuario;
import qmp.servicios.meteorologico.alertas.Alertas;
import java.util.List;

public class NotificacionGranizo implements Accion {

  @Override
  public void notificar(Usuario usuario, List<Alertas> alertas) {
    if (alertas.contains(Alertas.GRANIZO)) {
      usuario.getNotificaciones().notify("Alerta de granizo, evitar salir con auto");
    }
  }
}
