package qmp;

import qmp.guardarropa.Guardarropa;
import qmp.prenda.Prenda;
import qmp.servicios.meteorologico.alertas.Alertas;
import qmp.prenda.sugerencia.MotorSugerencia;
import qmp.prenda.sugerencia.SugerenciaPrenda;
import qmp.servicios.comunicacion.NotificationService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import qmp.acciones.Accion;

public class Usuario {
  private final List<Guardarropa> guardarropas = new ArrayList<>();
  private String mail;
  private MotorSugerencia motorsugerencia;
  private int edad;
  private Ciudad ciudad;
  private List<SugerenciaPrenda> sugerencia;
  private NotificationService notificaciones;
  private final List<Accion> acciones = new ArrayList<>();


  public Usuario(String mail, int edad, NotificationService notificaciones,
                 MotorSugerencia motorsugerencia, Ciudad ciudad) {
    this.mail = mail;
    this.edad = edad;
    this.notificaciones = notificaciones;
    this.motorsugerencia = motorsugerencia;
    this.ciudad = ciudad;
  }

  public int getEdad() {
    return edad;
  }

  public Ciudad getCiudad() {
    return ciudad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setCiudad(Ciudad ciudad) {
    this.ciudad = ciudad;
  }

  public void addGuardarropa (Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

  public void addAccion(Accion accion) {
    this.acciones.add(accion);
  }

  public void removeAccion(Accion accion) {
    this.acciones.remove(accion);
  }

  public List<Prenda> getPrendas() {
    return guardarropas.stream().map(Guardarropa::getPrendas).flatMap(List::stream)
        .collect(Collectors.toList());
  }

  public boolean esAdultoMayor() {
    return this.edad > 50;
  }

  public List<SugerenciaPrenda> getSugerencia() {
    return new ArrayList<>(sugerencia);
  }

  public void setMotorsugerencia(MotorSugerencia motorsugerencia) {
    this.motorsugerencia = motorsugerencia;
  }

  public void generarSugerencia() {
    this.sugerencia = motorsugerencia.generarSugerencias(this);
  }

  public NotificationService getNotificaciones() {
    return notificaciones;
  }

  public void setNotificaciones(NotificationService notificaciones) {
    this.notificaciones = notificaciones;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public void accionar(List<Alertas> alertas) {
    acciones.forEach(accion -> accion.notificar(this, alertas));
  }
}
