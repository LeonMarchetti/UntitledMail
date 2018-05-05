import java.sql.Timestamp;

import mail.IMail;
import mail.Mail;

public class Main {

    private static String desde = "...@gmail.com";
    private static String hasta = "...@...";
    private static String asunto = "Prueba ";
    private static String mensaje = "Hola mundo! ";
    private static String contrasena = "...";

    public static void main(String [] args) {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println("ts: \"" + ts + "\"");

        IMail mail = new Mail();
        if (mail.enviarEmail(desde, hasta, asunto + ts, mensaje + ts, contrasena)) {
            System.out.printf("Enviado\n");
        } else {
            System.out.printf("No enviado\n");
        }
   }
}