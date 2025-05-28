package QMP.Prenda;

public enum Material {
  ALGODON("Algodón"),
  LYCRA("Lycra");

  private final String nombre;

  Material(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return nombre;
  }
}
