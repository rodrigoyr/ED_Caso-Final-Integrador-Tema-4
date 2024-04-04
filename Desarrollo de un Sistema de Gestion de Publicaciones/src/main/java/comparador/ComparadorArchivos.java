import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ComparadorArchivos extends JFrame {
    private JTextArea resultadoComparacion;

    public ComparadorArchivos() {
        super("Comparador de Archivos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JLabel labelArchivo1 = new JLabel("Archivo 1:");
        JLabel labelArchivo2 = new JLabel("Archivo 2:");

        JTextField campoArchivo1 = new JTextField(20);
        JTextField campoArchivo2 = new JTextField(20);

        JButton botonComparar = new JButton("Comparar");
        resultadoComparacion = new JTextArea();
        resultadoComparacion.setEditable(false);

        botonComparar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreArchivo1 = campoArchivo1.getText();
                String nombreArchivo2 = campoArchivo2.getText();
                compararArchivos(nombreArchivo1, nombreArchivo2);
            }
        });

        JPanel panelArchivos = new JPanel(new GridLayout(2, 2));
        panelArchivos.add(labelArchivo1);
        panelArchivos.add(campoArchivo1);
        panelArchivos.add(labelArchivo2);
        panelArchivos.add(campoArchivo2);

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonComparar);

        JScrollPane scrollPane = new JScrollPane(resultadoComparacion);

        add(panelArchivos, BorderLayout.NORTH);
        add(panelBoton, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void compararArchivos(String nombreArchivo1, String nombreArchivo2) {
        try (BufferedReader lector1 = new BufferedReader(new FileReader(nombreArchivo1));
             BufferedReader lector2 = new BufferedReader(new FileReader(nombreArchivo2))) {
            String linea1, linea2;
            resultadoComparacion.setText("");
            while ((linea1 = lector1.readLine()) != null && (linea2 = lector2.readLine()) != null) {
                if (!linea1.equals(linea2)) {
                    resultadoComparacion.append("Diferencia encontrada:\n");
                    resultadoComparacion.append("Archivo 1: " + linea1 + "\n");
                    resultadoComparacion.append("Archivo 2: " + linea2 + "\n\n");
                }
            }
            if ((linea1 = lector1.readLine()) != null) {
                resultadoComparacion.append("Archivo 1 tiene más líneas.\n");
            }
            if ((linea2 = lector2.readLine()) != null) {
                resultadoComparacion.append("Archivo 2 tiene más líneas.\n");
            }
        } catch (IOException e) {
            resultadoComparacion.setText("Error al comparar los archivos.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComparadorArchivos().setVisible(true);
            }
        });
    }
}
