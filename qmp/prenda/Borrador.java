package qmp.prenda;

public class Borrador {
  final private Tipo tipo;
  private Material tela;
  private String colorPrincipal;
  private String colorSecundario;
  private Patron patron;
  private Formalidad formalidad;
  private double tempMaxima;
  private double tempMinima;


  public Borrador(Tipo tipo) {
    this.tipo = tipo;
  }

  public Borrador setTela(Material tela) {
    this.tela = tela;
    return this;
  }

  public Borrador setColorPrincipal(String colorPrincipal) {
    this.colorPrincipal = colorPrincipal;
    return this;
  }

  public Borrador setColorSecundario(String colorSecundario) {
    this.colorSecundario = colorSecundario;
    return this;
  }

  public Borrador setPatron(Patron patron) {
    this.patron = patron;
    return this;
  }

  public Borrador setFormalidad(Formalidad formalidad) {
    this.formalidad = formalidad;
    return this;
  }

  public Borrador setTempMaxima(double tempMaxima) {
    this.tempMaxima = tempMaxima;
    return this;
  }

  public Borrador setTempMinima(double tempMinima) {
    this.tempMinima = tempMinima;
    return this;
  }

  public Prenda generarPrenda() {
    return new Prenda(tipo, colorPrincipal, colorSecundario, tela, patron, formalidad,
        tempMaxima, tempMinima);
  }

}
