import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ContadorContenido extends JFrame {
    private JTextArea areaTexto;
    private JLabel etiquetaConteo;

    public ContadorContenido() {
        super("Contador de Contenido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        etiquetaConteo = new JLabel("Número de palabras: 0");

        areaTexto.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                contarPalabras();
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(etiquetaConteo, BorderLayout.SOUTH);
    }

    private void contarPalabras() {
        String texto = areaTexto.getText();
        int numeroPalabras = texto.isEmpty() ? 0 : texto.split("\\s+").length;
        etiquetaConteo.setText("Número de palabras: " + numeroPalabras);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ContadorContenido().setVisible(true);
            }
        });
    }
}

