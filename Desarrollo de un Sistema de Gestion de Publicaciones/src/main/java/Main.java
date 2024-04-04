import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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

                // Acciones para el menú de Archivo
                ventanaPrincipal.getItemNuevo().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Abrir una nueva ventana para editar un nuevo documento
                        VentanaDocumentoEditor ventanaNuevoDocumento = new VentanaDocumentoEditor();
                        ventanaNuevoDocumento.setVisible(true);
                    }
                });

                ventanaPrincipal.getItemAbrir().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Abrir un diálogo de selección de archivo para abrir un documento existente
                        JFileChooser fileChooser = new JFileChooser();
                        int seleccion = fileChooser.showOpenDialog(null);
                        if (seleccion == JFileChooser.APPROVE_OPTION) {
                            String nombreArchivo = fileChooser.getSelectedFile().getName();
                            // Lógica para abrir el archivo seleccionado
                            // Por ejemplo:
                            // VentanaDocumento ventanaDocumento = new VentanaDocumento(nombreArchivo);
                            // ventanaDocumento.setVisible(true);
                        }
                    }
                });

                ventanaPrincipal.getItemGuardar().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para guardar el documento actual
                    }
                });

                ventanaPrincipal.getItemSalir().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para salir de la aplicación
                        System.exit(0);
                    }
                });

                // Acciones para el menú de Herramientas
                ventanaPrincipal.getItemComparar().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para comparar documentos
                        // Por ejemplo:
                        // VentanaCompararDocumentos ventanaComparar = new VentanaCompararDocumentos();
                        // ventanaComparar.setVisible(true);
                    }
                });

                ventanaPrincipal.getItemContar().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para contar palabras en un documento
                    }
                });

                ventanaPrincipal.getItemBuscar().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para buscar una palabra en todos los documentos
                    }
                });

                ventanaPrincipal.getItemAgenda().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para acceder a la agenda de contactos
                        // Por ejemplo:
                        // VentanaAgendaContactos ventanaAgenda = new VentanaAgendaContactos();
                        // ventanaAgenda.setVisible(true);
                    }
                });
            }
        });
    }
}
