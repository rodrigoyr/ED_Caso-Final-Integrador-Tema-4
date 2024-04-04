import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear ventana principal
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            ventanaPrincipal.setVisible(true);

            // Agregar ActionListener para el menú Nuevo Documento
            ventanaPrincipal.getMenuItemNuevo().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirVentanaDocumentoNuevo(ventanaPrincipal.getDesktopPane());
                }
            });

            // Agregar ActionListener para el menú Abrir Documento
            ventanaPrincipal.getMenuItemAbrir().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirDocumento(ventanaPrincipal.getDesktopPane());
                }
            });

            // Agregar ActionListener para el menú Guardar Documento
            ventanaPrincipal.getMenuItemGuardar().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    guardarDocumento(ventanaPrincipal.getDesktopPane());
                }
            });

            // Agregar ActionListener para el menú Salir
            ventanaPrincipal.getMenuItemSalir().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        });
    }

    private static void abrirVentanaDocumentoNuevo(JDesktopPane desktopPane) {
        VentanaDocumento ventana = new VentanaDocumento("Nuevo Documento");
        ventana.setVisible(true);
        desktopPane.add(ventana);
    }

    private static void abrirDocumento(JDesktopPane desktopPane) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                VentanaDocumento ventana = new VentanaDocumento(selectedFile.getName());
                ventana.setFile(selectedFile);
                try {
                    ventana.cargarDocumento(); // Llamada sin argumentos
                    ventana.setVisible(true);
                    desktopPane.add(ventana);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al abrir el documento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private static void guardarDocumento(JDesktopPane desktopPane) {
        JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            if (frame instanceof VentanaDocumento) {
                VentanaDocumento ventana = (VentanaDocumento) frame;
                try {
                    ventana.guardarDocumento();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el documento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
