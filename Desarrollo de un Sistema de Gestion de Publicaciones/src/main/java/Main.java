import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            ventanaPrincipal.setVisible(true);

            // Agregar ActionListener para Nuevo Documento
            ventanaPrincipal.getMenuItemNuevo().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirVentanaDocumentoNuevo(ventanaPrincipal.getDesktopPane());
                }
            });

            // Agregar ActionListener para Abrir Documento
            ventanaPrincipal.getMenuItemAbrir().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mostrarDocumentosGuardados(ventanaPrincipal);
                }
            });

            // Agregar ActionListener para Salir
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

    private static void mostrarDocumentosGuardados(VentanaPrincipal ventanaPrincipal) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setDialogTitle("Abrir Documento");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(ventanaPrincipal);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                abrirDocumento(ventanaPrincipal.getDesktopPane(), selectedFile);
            }
        }
    }

    private static void abrirDocumento(JDesktopPane desktopPane, File file) {
        VentanaDocumento ventana = new VentanaDocumento(file.getName());
        try {
            ventana.cargarDocumento(file);
            ventana.setVisible(true);
            desktopPane.add(ventana);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el documento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
