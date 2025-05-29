package QMP.Prenda;


import QMP.Clima.EstadoClima;

public record Prenda(Tipo tipo, String colorPrincipal, String colorSecundario, Material material,
                     Patron patron, Formalidad formalidad, double tempMaxima, double tempMinima) {

  public Prenda {
   this.assertNotNull(tipo, "Tipo");
    this.assertNotNull(colorPrincipal, "Color principal");
    this.assertNotNull(material, "Material");
    patron = patron == null ? Patron.LISA : patron;
    this.assertNotNull(formalidad, "Formalidad");
    this.assertNotNull(tempMaxima, "Temperatura maxima");
    this.assertNotNull(tempMinima, "Temperatura mínima");
  }

  public Categoria categoria() {
    return this.tipo.getCategoria();
  }

  public boolean sirveEnClima(EstadoClima clima) {
    return this.sirveEnTemperatura(clima.temperatura());
  }

  public boolean sirveEnTemperatura(double temperatura){
    return temperatura >= tempMinima && temperatura <= tempMaxima;
  }

  private void assertNotNull(Object valor, String campo){
    if(valor == null){
      throw new MissingItem(campo+"no puede ser null");
    }
  }

}
