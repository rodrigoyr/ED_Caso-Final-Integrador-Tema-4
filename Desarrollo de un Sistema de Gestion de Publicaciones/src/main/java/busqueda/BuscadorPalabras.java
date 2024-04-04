import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BuscadorPalabras extends JFrame {
    private JTextArea areaTexto;
    private JTextField campoBusqueda;
    private JLabel etiquetaResultado;

    public BuscadorPalabras() {
        super("Buscador de Palabras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JLabel labelBusqueda = new JLabel("Palabra a buscar:");
        campoBusqueda = new JTextField(20);
        campoBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPalabra();
            }
        });

        etiquetaResultado = new JLabel();

        areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.add(labelBusqueda);
        panelBusqueda.add(campoBusqueda);

        JPanel panelResultado = new JPanel();
        panelResultado.add(etiquetaResultado);

        add(panelBusqueda, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelResultado, BorderLayout.SOUTH);
    }

    private void buscarPalabra() {
        String palabraBuscar = campoBusqueda.getText().trim();
        if (!palabraBuscar.isEmpty()) {
            String texto = areaTexto.getText();
            String[] palabras = texto.split("\\s+");
            int contador = 0;
            for (String palabra : palabras) {
                if (palabra.equalsIgnoreCase(palabraBuscar)) {
                    contador++;
                }
            }
            etiquetaResultado.setText("La palabra '" + palabraBuscar + "' se encontró " + contador + " veces.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una palabra para buscar.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BuscadorPalabras().setVisible(true);
            }
        });
    }
}

