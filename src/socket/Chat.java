package socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Esta clase permite relacionar un número de contacto (puerto) a una conversación
 */
public class Chat {
    private static Logger log = LoggerFactory.getLogger(Chat.class);

    int contacto;
    String conve = "";

    public Chat() {
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getConve() {
        return conve;
    }

    public void setConve(String conve) {
        this.conve = conve;
    }
}