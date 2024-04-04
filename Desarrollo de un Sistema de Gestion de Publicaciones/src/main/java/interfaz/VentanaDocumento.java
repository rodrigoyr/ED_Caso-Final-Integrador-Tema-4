import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VentanaDocumento extends JFrame {
    private JTextArea areaTexto;
    private String nombreDocumento;

    public VentanaDocumento(String nombreDocumento) {
        super(nombreDocumento);
        this.nombreDocumento = nombreDocumento;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        cargarDocumento();
    }

    private void cargarDocumento() {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreDocumento))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                areaTexto.append(linea + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el documento", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaDocumento("documento.txt").setVisible(true);
            }
        });
    }
}
