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

                ventanaPrincipal.addMenuListener(new MenuListener() {
                    public void actionPerformed(ActionEvent e) {
                        JMenuItem item = (JMenuItem) e.getSource();
                        String opcion = item.getText();

                        if (opcion.equals("Nuevo Documento")) {
                            abrirNuevoDocumento();
                        } else if (opcion.equals("Abrir Documento")) {
                            abrirDocumentoExistente();
                        } else if (opcion.equals("Guardar Documento")) {
                            guardarDocumento();
                        } else if (opcion.equals("Comparar Documentos")) {
                            compararDocumentos();
                        } else if (opcion.equals("Contar Palabras")) {
                            contarPalabras();
                        } else if (opcion.equals("Buscar Palabra")) {
                            buscarPalabra();
                        } else if (opcion.equals("Agenda de Contactos")) {
                            mostrarAgendaContactos();
                        }
                    }

                    public void menuSelected(MenuEvent e) {
                    }

                    public void menuDeselected(MenuEvent e) {
                    }

                    public void menuCanceled(MenuEvent e) {
                    }
                });
            }
        });
    }

    private static void abrirNuevoDocumento() {
        VentanaDocumento ventanaDocumento = new VentanaDocumento("Nuevo Documento");
        ventanaDocumento.setVisible(true);
    }

    private static void abrirDocumentoExistente() {
        // Lógica para abrir un documento existente
        // Aquí puedes usar un JFileChooser para que el usuario seleccione un archivo
    }

    private static void guardarDocumento() {
        // Lógica para guardar un documento
        // Puedes guardar el contenido del JTextArea en un archivo de texto
    }

    private static void compararDocumentos() {
        // Lógica para comparar documentos
        // Puedes permitir al usuario seleccionar dos documentos y luego mostrar una ventana de comparación
    }

    private static void contarPalabras() {
        // Lógica para contar palabras
        // Puedes abrir un documento existente y utilizar la funcionalidad de contar palabras implementada previamente
    }

    private static void buscarPalabra() {
        // Lógica para buscar una palabra
        // Puedes abrir un documento existente y utilizar la funcionalidad de buscar palabras implementada previamente
    }

    private static void mostrarAgendaContactos() {
        // Lógica para mostrar la agenda de contactos
        // Puedes abrir una ventana que muestre los contactos guardados
    }
}

