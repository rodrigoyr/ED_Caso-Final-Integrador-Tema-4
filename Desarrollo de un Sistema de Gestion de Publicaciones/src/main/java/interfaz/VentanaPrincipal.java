import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        super("Sistema de Gestión de Publicaciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem menuItemNuevo = new JMenuItem("Nuevo Documento");
        JMenuItem menuItemAbrir = new JMenuItem("Abrir Documento");
        JMenuItem menuItemGuardar = new JMenuItem("Guardar Documento");
        JMenuItem menuItemSalir = new JMenuItem("Salir");

        menuItemNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica para crear un nuevo documento
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Funcionalidad aún no implementada: Nuevo Documento");
            }
        });

        menuItemAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica para abrir un documento existente
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Funcionalidad aún no implementada: Abrir Documento");
            }
        });

        menuItemGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica para guardar el documento actual
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Funcionalidad aún no implementada: Guardar Documento");
            }
        });

        menuItemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica para salir de la aplicación
                int respuesta = JOptionPane.showConfirmDialog(VentanaPrincipal.this, "¿Está seguro de que desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        menuArchivo.add(menuItemNuevo);
        menuArchivo.add(menuItemAbrir);
        menuArchivo.add(menuItemGuardar);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemSalir);

        // Aquí se agregan más elementos al menú Herramientas con sus correspondientes ActionListener

        menuBar.add(menuArchivo);
        // Agregar aquí más elementos al menúBar según sea necesario

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}

