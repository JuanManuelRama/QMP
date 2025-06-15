package qmp.prenda;

public enum Tipo {
  CAMISA("Camisa", Categoria.SUPERIOR),
  PANTALON("Pantalón", Categoria.INFERIOR);

  private final String nombre;
  private final Categoria categoria;

  Tipo(String nombre, Categoria categoria) {
    this.nombre = nombre;
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return nombre;
  }

  public Categoria getCategoria(){
    return categoria;
  }



}
