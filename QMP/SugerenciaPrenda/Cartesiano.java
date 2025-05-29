package QMP.SugerenciaPrenda;

import java.util.ArrayList;
import java.util.List;

//No es que esté abstrayendo esto, solo quiero poder llamar al método sin importar nada
public class Cartesiano {
  public static <T> List<List<T>> producto(List<List<T>> lists) {
    List<List<T>> result = new ArrayList<>();
    result.add(new ArrayList<>()); // start with one empty list

    for (List<T> list : lists) {
      List<List<T>> newResult = new ArrayList<>();
      for (List<T> partial : result) {
        for (T element : list) {
          List<T> newPartial = new ArrayList<>(partial);
          newPartial.add(element);
          newResult.add(newPartial);
        }
      }
      result = newResult;
    }

    return result;
  }
}
