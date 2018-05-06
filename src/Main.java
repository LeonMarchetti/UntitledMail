import java.sql.Timestamp;

import mail.Credenciales;
import mail.Mail;

public class Main {

    private static String desde = "...@gmail.com";
    private static String contrasena = "...";
    private static String hasta = "...@...";
    private static String asunto = "Prueba ";
    private static String mensaje = "Hola mundo! ";

    public static void main(String [] args) {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println("ts: \"" + ts + "\"");

        if ((new Mail()).enviarEmail(new Credenciales(desde, contrasena),
                                     hasta,
                                     asunto + ts,
                                     mensaje + ts)) {

            System.out.printf("Enviado\n");
        } else {
            System.out.printf("No enviado\n");
        }
   }
}