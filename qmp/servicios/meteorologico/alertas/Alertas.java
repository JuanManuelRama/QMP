package qmp.servicios.meteorologico.alertas;

public enum Alertas {
  TORMENTA("Tormenta"),
  GRANIZO("Granizo");

  private final String nombre;

  Alertas(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return nombre;
  }
}
