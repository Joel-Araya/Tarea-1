package socket;

import java.io.Serializable;

public class MensajeUsuario implements Serializable {

    private String ip, mensaje;

    public MensajeUsuario() {
    }

    public MensajeUsuario(String ip, String mensaje) {
        this.ip = ip;
        this.mensaje = mensaje;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}