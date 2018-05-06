package mail;

public interface IMail {
    public boolean enviarEmail(Credenciales credenciales, String mailHasta, String asunto, String mensaje);
}
