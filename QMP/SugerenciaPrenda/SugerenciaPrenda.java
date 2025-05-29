package QMP.SugerenciaPrenda;

import QMP.Prenda.Categoria;
import QMP.Prenda.Prenda;

public record SugerenciaPrenda(Prenda parteSuperior, Prenda parteInferior, Prenda calzado){

    public SugerenciaPrenda {
    this. isValid(parteSuperior, Categoria.SUPERIOR);
    this.isValid(parteSuperior, Categoria.INFERIOR);
    this.isValid(calzado, Categoria.CALZADO);
  }

  private void isValid(Prenda prenda, Categoria categoria) {
    if (prenda.categoria().equals(categoria)) {
      throw new WrongPrenda("Esperaba: " + categoria + "recibí:" + prenda.colorPrincipal());
    }
  }

}
