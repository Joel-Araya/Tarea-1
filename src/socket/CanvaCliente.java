package socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class CanvaCliente extends JPanel implements Runnable {

    private JTextArea areaTextoCliente;
    private JTextField campoEscribir, Contacto;
    private JButton boton;
    int puertoInicial = 50000;

    public CanvaCliente() {

        JLabel texto = new JLabel("Chat --- Introduce tu Ip");   //Muestra un Label que dice que este es la ventana del chat
        add(texto);

        Contacto = new JTextField(7);
        add(Contacto);

        areaTextoCliente = new JTextArea(24, 35);
        add(areaTextoCliente);

        campoEscribir = new JTextField(20);
        add(campoEscribir);

        TextoEnviado evento = new TextoEnviado();

        boton = new JButton("Enviar");
        boton.addActionListener(evento);

        add(boton);

        Thread t2 = new Thread(this);
        t2.start();
    }

    @Override
    public void run(){
        boolean flag = true;
        while (flag) {
            try {
                ServerSocket servidor = new ServerSocket(puertoInicial);
                String puertoEmisor, mensaje;
                MensajeUsuario mensajeRecibido;
                flag = false;
                System.out.println("===============");
                System.out.println(puertoInicial);
                System.out.println("===============");
                while (true) {
                    Socket socket = servidor.accept();
                    ObjectInputStream datos = new ObjectInputStream(socket.getInputStream());
                    mensajeRecibido = (MensajeUsuario) datos.readObject();

                    puertoEmisor = mensajeRecibido.getIp();
                    mensaje = mensajeRecibido.getMensaje();

                    areaTextoCliente.append("De " + puertoEmisor + ": " + mensaje + "\n");

                    socket.close();
                }
            } catch (UnknownHostException unknownHostException) {
                unknownHostException.printStackTrace();
                System.out.println("UnknownHostException cliente");
            } catch (IOException ioException) {
                //ioException.printStackTrace();
                System.out.println("IOException cliente");
                puertoInicial++;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private class TextoEnviado implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int puerto = Integer.parseInt(Contacto.getText());

            try {
                Socket nuevoSocket = new Socket("127.0.0.1", puerto);

                MensajeUsuario datosRecibidos = new MensajeUsuario();
                datosRecibidos.setIp(String.valueOf(puertoInicial));
                datosRecibidos.setMensaje(campoEscribir.getText());

                areaTextoCliente.append("Yo: " + campoEscribir.getText() + "\n");

                ObjectOutputStream informacionDatos = new ObjectOutputStream(nuevoSocket.getOutputStream());
                informacionDatos.writeObject(datosRecibidos);
                nuevoSocket.close();

            } catch (UnknownHostException unknownHostException) {
                unknownHostException.printStackTrace();
                System.out.println("UnknownHostException cliente");
            } catch (IOException ioException) {
                System.out.println("IOException cliente");

            }

        }
    }
}
