package socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Esta clase genera un mensaje que puede ser serializado y enviado a través de la red
 */
public class MensajeUsuario implements Serializable {
    private static Logger log = LoggerFactory.getLogger(MensajeUsuario.class);

    private String puerto, mensaje;

    /**
     * Este constructor permite crear una instancia sin especificar algún parámetro
     */
    public MensajeUsuario() {
    }

    /**
     *
     * @param puerto este parámetro debe ser un String
     * @param mensaje este parámetro debe ser un String
     */
    public MensajeUsuario(String puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}