package QMP.Guardarropa;

import QMP.Prenda.Prenda;
import QMP.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Guardarropa {
  private final List<Prenda> prendas;
  private final List<Usuario> colaboradores;

  public Guardarropa(List<Usuario> colaboradores, List<Prenda> prendas) {
    this.colaboradores = colaboradores == null ? new ArrayList<>() : colaboradores;
    this.prendas = prendas == null ? new ArrayList<>() : prendas;
  }

  public void addPrenda(Prenda prenda) {
    prendas.add(prenda);
  }

  public void eliminarPrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

  public void addColaborador(Usuario colaborador) {
    colaboradores.add(colaborador);
  }


  public List<Prenda> getPrendas() {
    return new ArrayList<>(prendas);
  }

}
