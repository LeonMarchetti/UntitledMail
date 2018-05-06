package mail;

public class Credenciales {
    private final String usuario;
    private final String contrasena;

    public Credenciales(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
	    return this.usuario;
    }

    public String getContrasena() {
	    return this.contrasena;
    }

}
