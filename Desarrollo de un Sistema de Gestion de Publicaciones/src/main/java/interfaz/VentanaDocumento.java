import javax.swing.*;
import java.awt.*;
import java.io.*;

public class VentanaDocumento extends JFrame {
    private JTextArea areaTexto;

    public VentanaDocumento(String nombreDocumento) {
        super(nombreDocumento);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        cargarDocumento(nombreDocumento);
    }

    private void cargarDocumento(String nombreDocumento) {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreDocumento))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                areaTexto.append(linea + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaDocumento("documentos/documento.txt").setVisible(true);
            }
        });
    }
}

