package qmp.servicios.meteorologico.clima;

public enum Humedad {
  ALTA("Alta"),
  BAJA("Baja");
  private final String nombre;

  Humedad(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return nombre;
  }

  public static Humedad getHumedad(double humedad) {
    return humedad > 0.8 ? Humedad.ALTA : Humedad.BAJA;
  }
}
