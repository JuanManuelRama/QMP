package QMP.Prenda;

public enum Patron {
  LUNARES("Con lunares"),
  RAYADA("Rayada"),
  ESTAMPADO("Un estampado"),
  CUADROS("A cuadros"),
  LISA("Lisa");
  private final String nombre;
  private Patron(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return nombre;
  }

}
