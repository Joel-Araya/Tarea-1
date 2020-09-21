package socket;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Canva extends JPanel {

    private JTextField campo1;
    private JButton boton;

    public String getCampo1Text() {
        return campo1.getText();
    }

    public Canva() {

        JLabel texto = new JLabel("Cliente");   //Muestra un Label que dice que este es el cliente
        add(texto);

        campo1 = new JTextField(20);
        add(campo1);

        TextoEnviado evento = new TextoEnviado();

        boton = new JButton("Enviar");

        boton.addActionListener(evento);

        add(boton);
    }

    private class TextoEnviado implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println(campo1.getText());


        }
    }
}