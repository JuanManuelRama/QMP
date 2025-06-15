package qmp.acciones;

import qmp.Usuario;
import qmp.servicios.meteorologico.alertas.Alertas;
import java.util.List;

public interface Accion {
  void notificar(Usuario usuario, List<Alertas> alertas);
}
