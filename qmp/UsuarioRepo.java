package qmp;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo {
  private static final UsuarioRepo instance = new UsuarioRepo();
  private final List<Usuario> usuarios = new ArrayList<>();

  private UsuarioRepo() {
  }

  public static UsuarioRepo getInstance() {
    return instance;
  }

  public List<Usuario> getUsuarios() {
    return new ArrayList<>(usuarios);
  }

  public void addUsuario(Usuario usuario) {
    usuarios.add(usuario);
  }

  public void removeUsuario(Usuario usuario) {
    usuarios.remove(usuario);
  }

  public void sugerenciasDiarias() {
    usuarios.forEach(Usuario::generarSugerencia);
  }
}
