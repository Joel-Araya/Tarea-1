package socket;
import javax.swing.*;
import java.awt.*;

public class InterfazGraficaCliente extends JFrame {

    public InterfazGraficaCliente(){

        int altura, largo;

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();

        int alturaPantalla = tamano.height;
        int largoPantalla = tamano.width;

        largo = 32*largoPantalla/100;
        altura = 40*alturaPantalla/60;

        setBounds(largo/6,altura/10,largo,altura);
        setResizable(false);
        setTitle("Cliente");

        CanvaCliente miCanva = new CanvaCliente();
        add(miCanva);

        setVisible(true);

    }
}
