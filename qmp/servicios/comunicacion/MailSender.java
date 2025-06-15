package qmp.servicios.comunicacion;

public interface MailSender {
  void send(String address, String message);
}
