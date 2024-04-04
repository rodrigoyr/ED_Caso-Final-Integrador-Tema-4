import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AgendaContactos extends JFrame {
    private JTextField campoNombre;
    private JTextField campoEmail;
    private JTextField campoTelefono;
    private DefaultListModel<Contacto> modeloLista;
    private JList<Contacto> listaContactos;

    public AgendaContactos() {
        super("Agenda de Contactos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel labelNombre = new JLabel("Nombre:");
        JLabel labelEmail = new JLabel("Email:");
        JLabel labelTelefono = new JLabel("Teléfono:");

        campoNombre = new JTextField(20);
        campoEmail = new JTextField(20);
        campoTelefono = new JTextField(20);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });

        modeloLista = new DefaultListModel<>();
        listaContactos = new JList<>(modeloLista);
        listaContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(listaContactos);

        JPanel panelCampos = new JPanel(new GridLayout(3, 2));
        panelCampos.add(labelNombre);
        panelCampos.add(campoNombre);
        panelCampos.add(labelEmail);
        panelCampos.add(campoEmail);
        panelCampos.add(labelTelefono);
        panelCampos.add(campoTelefono);

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonAgregar);

        add(panelCampos, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    private void agregarContacto() {
        String nombre = campoNombre.getText();
        String email = campoEmail.getText();
        String telefono = campoTelefono.getText();
        if (!nombre.isEmpty() && !email.isEmpty() && !telefono.isEmpty()) {
            Contacto nuevoContacto = new Contacto(nombre, email, telefono);
            modeloLista.addElement(nuevoContacto);
            campoNombre.setText("");
            campoEmail.setText("");
            campoTelefono.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AgendaContactos().setVisible(true);
            }
        });
    }
}

class Contacto {
    private String nombre;
    private String email;
    private String telefono;

    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String toString() {
        return nombre + " - " + email + " - " + telefono;
    }
}
