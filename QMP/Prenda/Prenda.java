package QMP.Prenda;


public class Prenda {
  private final Tipo tipo;
  private final String colorPrincipal;
  private final String colorSecundario;
  private final Material material;
  private final Patron patron;
  private final Formalidad formalidad;
  private final int tempMaxima;
  private final int tempMinima;

  Prenda(Tipo tipo, String colorPrincipal, String colorSecundario, Material material, Patron patron,
         Formalidad formalidad, int tempMaxima, int tempMinima) {
    this.tipo = isNotNull(tipo, "Tipo");
    this.colorPrincipal = isNotNull(colorPrincipal, "Color principal");
    this.colorSecundario = colorSecundario;
    this.material = isNotNull(material, "Material");
    this.patron = patron == null ? Patron.LISA : patron;
    this.formalidad = isNotNull(formalidad, "Formalidad");
    this.tempMaxima = tempMaxima;
    this.tempMinima = tempMinima;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public Categoria getCategoria(){
    return tipo.getCategoria();
  }

  public Material getMaterial(){
    return material;
  }

  public Patron getPatron(){
    return patron;
  }

  public String getColorPrincipal(){
    return colorPrincipal;
  }

  public String getColorSecundario(){
    return colorSecundario;
  }

  public Formalidad getFormalidad(){
    return formalidad;
  }

  public int getTempMaxima(){
    return tempMaxima;
  }

  public int getTempMinima(){
    return tempMinima;
  }

  public boolean sirveEnTemperatura(int temperatura){
    return temperatura >= tempMinima && temperatura <= tempMaxima;
  }

  private <T> T isNotNull(T valor, String campo){
    if(valor == null){
      throw new MissingItem(campo+"no puede ser null");
    }
    return valor;
  }

}
