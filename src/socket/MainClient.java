package socket;
import javax.swing.*;

public class MainClient {
    public static void main(String[] args){
        InterfazGraficaServidor server = new InterfazGraficaServidor();
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InterfazGraficaCliente ventana = new InterfazGraficaCliente();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
