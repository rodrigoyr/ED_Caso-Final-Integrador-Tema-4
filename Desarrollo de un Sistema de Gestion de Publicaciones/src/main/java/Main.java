import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);

                ventanaPrincipal.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        // Realizar acciones de limpieza o guardado al cerrar la ventana principal
                    }
                });

                JMenuItem menuItemNuevo = ventanaPrincipal.getMenuItemNuevo();
                JMenuItem menuItemAbrir = ventanaPrincipal.getMenuItemAbrir();
                JMenuItem menuItemGuardar = ventanaPrincipal.getMenuItemGuardar();
                JMenuItem menuItemSalir = ventanaPrincipal.getMenuItemSalir();

                menuItemNuevo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        abrirVentanaDocumentoNuevo();
                    }
                });

                menuItemAbrir.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        abrirVentanaDocumento();
                    }
                });

                menuItemGuardar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        guardarDocumento();
                    }
                });

                menuItemSalir.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int respuesta = JOptionPane.showConfirmDialog(ventanaPrincipal, "¿Está seguro de que desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
                        if (respuesta == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                    }
                });
            }
        });
    }

    private static void abrirVentanaDocumentoNuevo() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaDocumento ventana = new VentanaDocumento("Nuevo Documento");
                ventana.setVisible(true);
            }
        });
    }

    private static void abrirVentanaDocumento() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String nombreArchivo = archivo.getName();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    VentanaDocumento ventana = new VentanaDocumento(nombreArchivo);
                    ventana.setVisible(true);
                }
            });
        }
    }

    private static void guardarDocumento() {
        // Lógica para guardar el documento actual
    }
}
