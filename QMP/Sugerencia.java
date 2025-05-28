package QMP;

import QMP.Prenda.Categoria;
import QMP.Prenda.Prenda;

public class Sugerencia {
  private final Prenda parteSuperior;
  private final Prenda parteInferior;
  private final Prenda calzado;

  public Sugerencia(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteSuperior = this.isValid(parteSuperior, Categoria.SUPERIOR);
    this.parteInferior = this.isValid(parteSuperior, Categoria.INFERIOR);
    this.calzado = this.isValid(calzado, Categoria.CALZADO);
  }

  private Prenda isValid(Prenda prenda, Categoria categoria) {
    if (prenda.getCategoria().equals(categoria)) {
      throw new WrongPrenda("Esperaba: " + categoria + "recibí:" + prenda.getColorPrincipal());
    }
    return prenda;
  }

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

}
