import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                JMenuItem itemNuevo = new JMenuItem("Nuevo Documento");
                itemNuevo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JTextArea areaTexto = new JTextArea(20, 40);
                        JScrollPane scrollPane = new JScrollPane(areaTexto);
                        JOptionPane.showMessageDialog(null, scrollPane, "Nuevo Documento", JOptionPane.PLAIN_MESSAGE);
                    }
                });

                JMenuItem itemAbrir = new JMenuItem("Abrir Documento");
                itemAbrir.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String[] documentos = {"documento1.txt", "documento2.txt", "documento3.txt"}; // Ejemplo de documentos existentes
                        String nombreArchivo = (String) JOptionPane.showInputDialog(null, "Seleccione un documento para abrir:", "Abrir Documento", JOptionPane.QUESTION_MESSAGE, null, documentos, documentos[0]);
                        if (nombreArchivo != null) {
                            JOptionPane.showMessageDialog(null, "Abriendo documento: " + nombreArchivo, "Documento Abierto", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });

                JMenuItem itemGuardar = new JMenuItem("Guardar Documento");
                itemGuardar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Documento guardado correctamente", "Guardar Documento", JOptionPane.INFORMATION_MESSAGE);
                    }
                });

                JMenuItem itemSalir = new JMenuItem("Salir");
                itemSalir.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                // Acciones para el menú de Herramientas
                JMenuItem itemComparar = new JMenuItem("Comparar Documentos");
                itemComparar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String[] documentos = {"documento1.txt", "documento2.txt", "documento3.txt"}; // Ejemplo de documentos existentes
                        Object[] seleccionados = JOptionPane.showInputDialog(null, "Seleccione dos documentos para comparar:", "Comparar Documentos", JOptionPane.QUESTION_MESSAGE, null, documentos, documentos[0]);
                        if (seleccionados != null && seleccionados.length == 2) {
                            JOptionPane.showMessageDialog(null, "Comparando documentos: " + seleccionados[0] + " y " + seleccionados[1], "Comparación Completada", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });

                JMenuItem itemContar = new JMenuItem("Contar Palabras");
                itemContar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String[] documentos = {"documento1.txt", "documento2.txt", "documento3.txt"}; // Ejemplo de documentos existentes
                        String nombreArchivo = (String) JOptionPane.showInputDialog(null, "Seleccione un documento para contar palabras:", "Contar Palabras", JOptionPane.QUESTION_MESSAGE, null, documentos, documentos[0]);
                        if (nombreArchivo != null) {
                            // Lógica para contar palabras en el documento seleccionado
                            int palabras = 0; // Supongamos que aquí se cuenta el número de palabras
                            JOptionPane.showMessageDialog(null, "El documento " + nombreArchivo + " tiene " + palabras + " palabras.", "Conteo de Palabras", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });

                JMenuItem itemBuscar = new JMenuItem("Buscar Palabra");
                itemBuscar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String palabra = JOptionPane.showInputDialog(null, "Ingrese la palabra a buscar:", "Buscar Palabra", JOptionPane.QUESTION_MESSAGE);
                        if (palabra != null && !palabra.isEmpty()) {
                            String[] documentos = {"documento1.txt", "documento2.txt", "documento3.txt"}; // Ejemplo de documentos existentes
                            String nombreArchivo = (String) JOptionPane.showInputDialog(null, "Seleccione un documento para buscar la palabra:", "Buscar Palabra", JOptionPane.QUESTION_MESSAGE, null, documentos, documentos[0]);
                            if (nombreArchivo != null) {
                                // Lógica para buscar la palabra en el documento seleccionado y resaltarla
                                JOptionPane.showMessageDialog(null, "Palabra \"" + palabra + "\" encontrada en el documento " + nombreArchivo, "Resultado de la Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                });

                JMenuItem itemAgenda = new JMenuItem("Agenda de Contactos");
                itemAgenda.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para acceder a la agenda de contactos
                        // Por ejemplo:
                        // VentanaAgendaContactos ventanaAgenda = new VentanaAgendaContactos();
                        // ventanaAgenda.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Funcionalidad de la Agenda de Contactos no implementada", "Agenda de Contactos", JOptionPane.WARNING_MESSAGE);
                    }
                });

                ventanaPrincipal.getMenuArchivo().add(itemNuevo);
                ventanaPrincipal.getMenuArchivo().add(itemAbrir);
                ventanaPrincipal.getMenuArchivo().add(itemGuardar);
                ventanaPrincipal.getMenuArchivo().addSeparator();
                ventanaPrincipal.getMenuArchivo().add(itemSalir);

                ventanaPrincipal.getMenuHerramientas().add(itemComparar);
                ventanaPrincipal.getMenuHerramientas().add(itemContar);
                ventanaPrincipal.getMenuHerramientas().add(itemBuscar);
                ventanaPrincipal.getMenuHerramientas().add(itemAgenda);
            }
        });
    }
}
