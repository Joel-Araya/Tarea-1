package socket;
import javax.swing.*;
import java.awt.*;

class InterfazGraficaServidor extends JFrame {

    private	JTextArea areatexto;

    public InterfazGraficaServidor(){

        int altura, largo;

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();

        int alturaPantalla = tamano.height;
        int largoPantalla = tamano.width;

        largo = 35*largoPantalla/100;
        altura = 40*alturaPantalla/60;

        setBounds(8*largo/6,altura/10,largo,altura);
        setResizable(true);
        setTitle("Servidor");

        areatexto = new JTextArea(10,10);
        add(areatexto);


        setVisible(true);
    }
}