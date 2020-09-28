package socket;
import javax.swing.*;
import java.awt.*;

public class InterfazGraficaCliente extends JFrame {

    public InterfazGraficaCliente(){

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();

        int altura, largo;
        int alturaPantalla = tamano.height;
        int largoPantalla = tamano.width;

        largo = 32*largoPantalla/100;
        altura = 40*alturaPantalla/60;

        setBounds(largo/6,altura/10,largo,altura);
        setResizable(false);
        setTitle("Chat");

        CanvaCliente miCanva = new CanvaCliente();
        add(miCanva);

        setVisible(true);

    }
}
