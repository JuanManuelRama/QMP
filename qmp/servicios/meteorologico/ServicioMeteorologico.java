package qmp.servicios.meteorologico;

import qmp.Ciudad;
import qmp.servicios.meteorologico.alertas.Alertas;
import qmp.servicios.meteorologico.clima.EstadoClima;
import java.util.List;

public interface ServicioMeteorologico {
  EstadoClima getClima(Ciudad ciudad);

  List<Alertas> getAlertas(Ciudad ciudad);
}
