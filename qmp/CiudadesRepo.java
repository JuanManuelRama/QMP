package qmp;

import java.util.List;
import java.util.stream.Collectors;

public class CiudadesRepo {
  public List<Ciudad> getCiudades() {
    return UsuarioRepo.getInstance().getUsuarios().stream().map(Usuario::getCiudad)
        .distinct().collect(Collectors.toList());
  }

  public void updateAlertas() {
    getCiudades().forEach(Ciudad::updateAlertas);
  }
}
