package socket;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

class InterfazGraficaServidor extends JFrame implements Runnable{

    private JTextArea areatexto;

    public InterfazGraficaServidor() {

        int altura, largo;

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();

        int alturaPantalla = tamano.height;
        int largoPantalla = tamano.width;

        largo = 35 * largoPantalla / 100;
        altura = 40 * alturaPantalla / 60;

        setBounds(8 * largo / 6, altura / 10, largo, altura);
        setResizable(true);
        setTitle("Servidor");

        areatexto = new JTextArea(10, 10);
        add(areatexto);


        setVisible(true);

        Thread t1 = new Thread(this);
        t1.start();
    }

    @Override
    public void run(){
        try {

            ServerSocket servidor = new ServerSocket(50000);
            String ip, mensaje;
            MensajeUsuario mensajeRecibido;

            while (true){
                Socket socket = servidor.accept();
                ObjectInputStream datos  = new ObjectInputStream(socket.getInputStream());
                mensajeRecibido = (MensajeUsuario)datos.readObject();

                ip = mensajeRecibido.getIp();
                mensaje = mensajeRecibido.getMensaje();

                System.out.println(ip);
                areatexto.append("\n De: " + ip + " / " + mensaje);

                socket.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException servidor");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ClassNotFoundException servidor");
        }

    }
}