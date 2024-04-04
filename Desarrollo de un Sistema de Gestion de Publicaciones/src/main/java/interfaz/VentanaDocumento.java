import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VentanaDocumento extends JInternalFrame {
    private JTextArea areaTexto;
    private String nombreDocumento;

    public VentanaDocumento(String nombreDocumento) {
        super(nombreDocumento, true, true, true, true);
        this.nombreDocumento = nombreDocumento;
        setSize(400, 300);

        areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

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

    public void guardarDocumento() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreDocumento))) {
            escritor.write(areaTexto.getText());
            JOptionPane.showMessageDialog(this, "Documento guardado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el documento", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaDocumento ventana = new VentanaDocumento("documento.txt");
                ventana.setVisible(true);
            }
        });
    }
}
