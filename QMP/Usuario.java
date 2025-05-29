package QMP;


import QMP.Guardarropa.Guardarropa;
import QMP.Prenda.Prenda;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
  private final List<Guardarropa> guardarropas = new ArrayList<>();
  private int edad;
  private String Ciudad;

  public Usuario(int edad) {
    this.edad = edad;
  }

  public int getEdad() {
    return edad;
  }

  public String getCiudad() {
    return Ciudad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setCiudad(String Ciudad) {
    this.Ciudad = Ciudad;
  }


  public void addGuardarropa (Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

  public List<Prenda> getPrendas() {
    return guardarropas.stream().map(Guardarropa::getPrendas).flatMap(List::stream)
        .collect(Collectors.toList());
  }

}
