package qmp.prenda.sugerencia;

import qmp.prenda.Categoria;
import qmp.prenda.Prenda;
import qmp.Usuario;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class MotorSugerencia {

  public MotorSugerencia() {
  }


  public List<SugerenciaPrenda> generarSugerencias(Usuario usuario) {
    List<Prenda >prendas = usuario.getPrendas().stream().filter(this.filtro(usuario)).toList();
    return Cartesiano.producto(
        List.of(
            this.filtrarSuperior(prendas),
            this.filtrarInferior(prendas),
            this.filtrarCalzado(prendas)
        )).stream().map(sugerencia
        -> new SugerenciaPrenda(sugerencia.get(0), sugerencia.get(1), sugerencia.get(2))).toList();
  }

  private List<Prenda> filtrarSuperior(List<Prenda> prendas){
    return this.filtrarCategoria(prendas, Categoria.SUPERIOR);
  }

  private List<Prenda> filtrarInferior(List<Prenda> prendas){
    return this.filtrarCategoria(prendas, Categoria.INFERIOR);
  }

  private List<Prenda> filtrarCalzado(List<Prenda> prendas){
    return this.filtrarCategoria(prendas, Categoria.CALZADO);
  }

  private List<Prenda> filtrarCategoria(List<Prenda> prendas, Categoria categoria){
    return prendas.stream().filter(prenda -> prenda.categoria().equals(categoria)).
        collect(Collectors.toList());
  }

  private Predicate<Prenda> filtro(Usuario usuario){
    return this.filtroPropio(usuario);
  }

  protected abstract Predicate<Prenda> filtroPropio(Usuario usuario);

}
