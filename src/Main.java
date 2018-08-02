import java.io.StringWriter;
import java.io.Writer;
import java.sql.Timestamp;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import mail.Credenciales;
import mail.Mail;

public class Main {

    // Tutorial plantillas: http://www.java2s.com/Code/Java/Velocity/UseVelocitytogenerateHTMLbasedemail.htm

    /* Datos incompletos */
    private static String desde = "...@gmail.com";
    private static String contrasena = "...";
    private static String hasta = "...@...";
    private static String asunto = "Prueba ";
    private static String mensaje = "Hola mundo! ";
    //*/

    public static void main(String [] args) {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println("ts: \"" + ts + "\"");

        String asuntoSalida = asunto + ts;

        // Inicialización de un motor de plantillas:
        VelocityEngine vMotor = new VelocityEngine();
        vMotor.init();

        // Iniciar un contexto e insertarle los datos:
        VelocityContext vContexto = new VelocityContext();
        vContexto.put("desde", desde);
        vContexto.put("hasta", hasta);
        vContexto.put("asunto", asuntoSalida);
        vContexto.put("mensaje", mensaje + ts);

        // Iniciar un escritor de Strings:
        Writer stringWriter = new StringWriter();

        // Obtengo la plantilla HTML de un archivo:
        Template plantilla = vMotor.getTemplate("src/templates/Template1.html");
        plantilla.merge(vContexto, stringWriter);

        // Obtengo el mensaje renderizado:
        String mensajeSalida = stringWriter.toString();

        if ((new Mail()).enviarEmail(new Credenciales(desde, contrasena),
                                     hasta,
                                     asuntoSalida,
                                     mensajeSalida)) {

            System.out.println("Enviado");

        } else {
            System.out.println("No enviado");
        }
   }
}