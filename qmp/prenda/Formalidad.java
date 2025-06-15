package qmp.prenda;

public enum Formalidad {
  FORMAL("Formal"),
  INFORMAL("Informal"),
  NEUTRA("Neutra");

  private final String nombre;

  private Formalidad(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return nombre;
  }
}
