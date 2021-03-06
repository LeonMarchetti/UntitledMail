package mail;

import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail implements IMail {

    @Override
    public boolean enviarEmail(Credenciales credenciales, String mailHasta, String asunto, String mensaje) {

        // Propiedades del sistema:
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Obtener el objeto de sesión por defecto:
        Session session = Session.getInstance(propiedades,
                                              new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(credenciales.getUsuario(),
                                                  credenciales.getContrasena());
            }
        });

        try {
            // Crear un objeto MimeMessage por defecto:
            MimeMessage mensajeMime = new MimeMessage(session);

            // Emisor:
            mensajeMime.setFrom(new InternetAddress(credenciales.getUsuario()));

            // Receptor:
            mensajeMime.setRecipients(Message.RecipientType.TO,
                                      InternetAddress.parse(mailHasta));

            // Asunto:
            mensajeMime.setSubject(asunto);

            // Mensaje Mime: Lo envío como un texto HTML:
            // mensajeMime.setText(mensaje, "utf-8", "html");

            // O como texto plano:
            mensajeMime.setText(mensaje, "utf-8", "plain");

            // Enviar mensaje:
            Transport.send(mensajeMime);

            return true;

        } catch (AuthenticationFailedException e) {
            System.out.println("Error de autenticación - Por ahí faltó "
                + "permitir el acceso a aplicaciones menos seguras.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
