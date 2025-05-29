package QMP.SugerenciaPrenda;

import QMP.Clima.ServicioMeteorologico;
import QMP.Prenda.Categoria;
import QMP.Prenda.Prenda;
import QMP.Usuario;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class MotorSugerencia {

  public MotorSugerencia() {
  }


  public List<List<Prenda>> generarSugerencias(Usuario usuario, List<Prenda> prendas) {
    prendas = prendas.stream().filter(this.filtro(usuario)).toList();
    return Cartesiano.producto(
        List.of(
            this.filtrarSuperior(prendas),
            this.filtrarInferior(prendas),
            this.filtrarCalzado(prendas)
        )
    );
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
