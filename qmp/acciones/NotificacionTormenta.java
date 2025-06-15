package qmp.acciones;

import qmp.Usuario;
import qmp.servicios.meteorologico.alertas.Alertas;
import java.util.List;

public class NotificacionTormenta implements Accion {

  @Override
  public void notificar(Usuario usuario, List<Alertas> alertas) {
    if (alertas.contains(Alertas.TORMENTA)) {
      usuario.getNotificaciones().notify("Alerta de tormenta, llevar paraguas");
    }
  }
}
