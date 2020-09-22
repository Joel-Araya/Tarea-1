package socket;
import javax.swing.*;

public class MainClient {
    public static void main(String[] args){

        InterfazGraficaCliente ventana = new InterfazGraficaCliente();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InterfazGraficaServidor server = new InterfazGraficaServidor();
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
