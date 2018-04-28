import java.sql.Timestamp;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

    private static String desde = "...@gmail.com";
    private static String para = "...@...";
    private static String asunto = "Prueba ";
    private static String mensaje = "Hola mundo! ";

    private static String usuario = desde;
    private static String contrasena = "...";

    public static void main(String [] args) {

       Timestamp ts = new Timestamp(System.currentTimeMillis());
       System.out.println("ts: \"" + ts + "\"");

       Properties properties = new Properties();
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.port", "587");
       properties.put("mail.smtp.starttls.enable", "true");

       properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

       Session session = Session.getInstance(properties,
                                             new Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(usuario, contrasena);
           }
       });
       session.setDebug(true);

       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(desde));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
           message.setSubject(asunto + ts);
           message.setText(mensaje + ts);
           Transport.send(message);
       } catch (MessagingException e) {
           e.printStackTrace();
       }

   }
}