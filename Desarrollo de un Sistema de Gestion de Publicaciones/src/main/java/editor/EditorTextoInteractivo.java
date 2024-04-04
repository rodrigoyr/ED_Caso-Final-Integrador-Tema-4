import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EditorTextoInteractivo extends JFrame {
    private JTextArea areaTexto;
    private JButton botonGuardar;
    private JButton botonAbrir;

    public EditorTextoInteractivo() {
        super("Editor de Texto Interactivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        botonGuardar = new JButton("Guardar");
        botonAbrir = new JButton("Abrir");

        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarArchivo();
            }
        });

        botonAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirArchivo();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonGuardar);
        panelBotones.add(botonAbrir);

        add(areaTexto, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void guardarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showSaveDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (PrintWriter escritor = new PrintWriter(archivo)) {
                escritor.print(areaTexto.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    areaTexto.append(linea + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EditorTextoInteractivo().setVisible(true);
            }
        });
    }
}
