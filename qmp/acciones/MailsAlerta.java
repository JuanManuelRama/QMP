package qmp.acciones;

import qmp.Usuario;
import qmp.servicios.comunicacion.MailSender;
import qmp.servicios.meteorologico.alertas.Alertas;
import java.util.List;
import java.util.stream.Collectors;

public class MailsAlerta implements Accion{
  private final MailSender mailSender;

  public MailsAlerta(MailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void notificar(Usuario usuario, List<Alertas> alertas) {
    mailSender.send(usuario.getMail(), alertas.stream().map(Alertas::toString)
        .collect(Collectors.joining(" y ", "Alerta de: ", ".")));
  }
}
