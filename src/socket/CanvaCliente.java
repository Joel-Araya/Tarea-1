package socket;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanvaCliente extends JPanel {

    private	JTextArea areaTextoCliente;
    private JTextField campoEscribir;
    private JButton boton;

    public CanvaCliente() {

        JLabel texto = new JLabel("Cliente");   //Muestra un Label que dice que este es el cliente
        add(texto);

        areaTextoCliente = new JTextArea(24,35);
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
            System.out.println(campoEscribir.getText());


        }
    }
}