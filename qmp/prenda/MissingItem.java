package qmp.prenda;

public class MissingItem extends RuntimeException {
  public MissingItem(String message) {
    super(message);
  }
}
