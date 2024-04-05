import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);

                ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ventanaPrincipal.setSize(500, 300);
                ventanaPrincipal.setLocationRelativeTo(null);

                ventanaPrincipal.agregarListenerNuevoDocumento(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        VentanaDocumento ventanaDocumento = new VentanaDocumento();
                        ventanaDocumento.setVisible(true);
                    }
                });

                ventanaPrincipal.agregarListenerGuardarDocumento(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para guardar el documento
                        // Por simplicidad, aquí solo mostramos un mensaje
                        JOptionPane.showMessageDialog(ventanaPrincipal, "Documento guardado correctamente");
                    }
                });

                ventanaPrincipal.agregarListenerAbrirDocumento(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para abrir el documento
                        // Por simplicidad, aquí solo mostramos un mensaje
                        JOptionPane.showMessageDialog(ventanaPrincipal, "Documento abierto correctamente");
                    }
                });

                ventanaPrincipal.agregarListenerCompararDocumentos(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para comparar documentos
                        // Por simplicidad, aquí solo mostramos un mensaje
                        JOptionPane.showMessageDialog(ventanaPrincipal, "Documentos comparados correctamente");
                    }
                });

                ventanaPrincipal.agregarListenerContarPalabras(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para contar palabras
                        // Por simplicidad, aquí solo mostramos un mensaje
                        JOptionPane.showMessageDialog(ventanaPrincipal, "Palabras contadas correctamente");
                    }
                });

                ventanaPrincipal.agregarListenerAbrirAgenda(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para abrir la agenda de contactos
                        // Por simplicidad, aquí solo mostramos un mensaje
                        JOptionPane.showMessageDialog(ventanaPrincipal, "Agenda de contactos abierta correctamente");
                    }
                });
            }
        });
    }
}
