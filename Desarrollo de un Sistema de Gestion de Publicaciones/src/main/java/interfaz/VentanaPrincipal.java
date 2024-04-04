import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {
    private JMenuItem menuItemNuevo;
    private JMenuItem menuItemAbrir;
    private JMenuItem menuItemGuardar;
    private JMenuItem menuItemSalir;
    private JDesktopPane desktopPane;

    public VentanaPrincipal() {
        super("Sistema de Gestión de Publicaciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        menuItemNuevo = new JMenuItem("Nuevo Documento");
        menuItemAbrir = new JMenuItem("Abrir Documento");
        menuItemGuardar = new JMenuItem("Guardar Documento");
        menuItemSalir = new JMenuItem("Salir");

        menuItemGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDocumento();
            }
        });

        menuArchivo.add(menuItemNuevo);
        menuArchivo.add(menuItemAbrir);
        menuArchivo.add(menuItemGuardar);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemSalir);

        menuBar.add(menuArchivo);

        setJMenuBar(menuBar);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
    }

    public JMenuItem getMenuItemNuevo() {
        return menuItemNuevo;
    }

    public JMenuItem getMenuItemAbrir() {
        return menuItemAbrir;
    }

    public JMenuItem getMenuItemGuardar() {
        return menuItemGuardar;
    }

    public JMenuItem getMenuItemSalir() {
        return menuItemSalir;
    }

    private void guardarDocumento() {
        JInternalFrame[] frames = desktopPane.getAllFrames();
        for (JInternalFrame frame : frames) {
            if (frame instanceof VentanaDocumento) {
                VentanaDocumento ventanaDocumento = (VentanaDocumento) frame;
                ventanaDocumento.guardarDocumento();
            }
        }
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
