package socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class CanvaCliente extends JPanel {

    private JTextArea areaTextoCliente;
    private JTextField campoEscribir, ip;
    private JButton boton;

    public CanvaCliente() {

        JLabel texto = new JLabel("Chat --- Introduce tu Ip");   //Muestra un Label que dice que este es la ventana del chat
        add(texto);

        ip = new JTextField(7);
        add(ip);

        areaTextoCliente = new JTextArea(24, 35);
        add(areaTextoCliente);

        campoEscribir = new JTextField(20);
        add(campoEscribir);

        TextoEnviado evento = new TextoEnviado();

        boton = new JButton("Enviar");
        boton.addActionListener(evento);

        add(boton);
    }

    private class TextoEnviado implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int puerto = 50000;

            try {
                System.out.println(ip.getText() + ":  " + campoEscribir.getText());

                Socket nuevoSocket = new Socket("127.0.0.1", 50000);


                MensajeUsuario datosRecibidos = new MensajeUsuario();
                datosRecibidos.setIp(ip.getText());
                datosRecibidos.setMensaje(campoEscribir.getText());


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
