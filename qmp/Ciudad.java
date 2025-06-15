package qmp;

import qmp.servicios.meteorologico.alertas.Alertas;
import qmp.servicios.meteorologico.clima.EstadoClima;
import qmp.servicios.meteorologico.ServicioMeteorologico;
import java.util.ArrayList;
import java.util.List;

public class Ciudad {
  private final String nombre;
  private List<Alertas> alertas = new ArrayList<>();
  private ServicioMeteorologico servicioMeteorologico;

  public Ciudad(String nombre, ServicioMeteorologico servicioMeteorologico) {
    this.nombre = nombre;
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public String getNombre() {
    return nombre;
  }

  public List<Alertas> getAlertas() {
    return new ArrayList<>(alertas);
  }

  public void setAlertas(List<Alertas> alertas) {
    this.alertas = new ArrayList<>(alertas);
  }

  public void setServicioMeteorologico(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public EstadoClima getClima() {
    return servicioMeteorologico.getClima(this);
  }

  public void updateAlertas() {
    this.alertas = servicioMeteorologico.getAlertas(this);
    UsuarioRepo.getInstance().getUsuarios().stream().filter(
        usuario -> usuario.getCiudad().equals(this)
    ).forEach(usuario -> usuario.accionar(this.alertas));
  }
}
