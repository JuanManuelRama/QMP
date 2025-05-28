package QMP.Prenda;

public enum Categoria {
  INFERIOR("Parte Inferior"),
  SUPERIOR("Parte superior"),
  CALZADO("Calzado"),
  ACCESORIO("Accesorio");

  Categoria(String nombre) {
    this.nombre = nombre;
  }
  private final String nombre;

  @Override
  public String toString() {
    return nombre;
  }
}
