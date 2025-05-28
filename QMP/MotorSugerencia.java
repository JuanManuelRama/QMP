package QMP;

import QMP.Clima.ServicioMeteorologico;
import QMP.Prenda.Categoria;
import QMP.Prenda.Prenda;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class MotorSugerencia {
  private ServicioMeteorologico servicioMeteorologico;

  public MotorSugerencia(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }


  public List<List<Prenda>> generarSugerencias(Usuario usuario) {
    List<Prenda> prendas = usuario.getPrendas().stream().filter(this.filtro(usuario)).toList();
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
    return prendas.stream().filter(prenda -> prenda.getCategoria().equals(categoria)).
        collect(Collectors.toList());
  }

  private Predicate<Prenda> filtro(Usuario usuario){
    return this.filtroPropio(usuario).and(prenda ->
        prenda.sirveEnTemperatura(servicioMeteorologico.getEstadoClima(usuario.getCiudad())
                .temperatura()));
  }
  protected abstract Predicate<Prenda> filtroPropio(Usuario usuario);

  public void setServicioMeteorologico(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }
}
