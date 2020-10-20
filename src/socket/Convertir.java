package socket;

import javax.swing.*;
import java.security.InvalidParameterException;

public class Convertir {

    public static String conversionTexto(JTextField Contacto) {
        if (!Contacto.getText().equals("") || !Contacto.getText().matches(".*[^a-z].*")) {
            return Contacto.getText();
        } else {
            throw new IllegalArgumentException("No sepuede dejar el puerto vacío o introducir letras");
        }

    }

    public static String getMessage(JTextField mensaje) {
        if (!mensaje.getText().equals("")) {
            return mensaje.getText();
        } else {
            throw new InvalidParameterException("No se puede enviar un mensaje en blanco");
        }
    }
}