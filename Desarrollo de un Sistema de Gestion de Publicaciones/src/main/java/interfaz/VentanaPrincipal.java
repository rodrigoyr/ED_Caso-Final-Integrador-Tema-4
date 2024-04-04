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

        menuArchivo.add(menuItemNuevo);
        menuArchivo.add(menuItemAbrir);
        menuArchivo.add(menuItemGuardar);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemSalir);

        JMenu menuHerramientas = new JMenu("Herramientas");
        JMenuItem menuItemComparar = new JMenuItem("Comparar Documentos");
        JMenuItem menuItemContar = new JMenuItem("Contar Palabras");
        JMenuItem menuItemBuscar = new JMenuItem("Buscar Palabra");
        JMenuItem menuItemAgenda = new JMenuItem("Agenda de Contactos");

        menuHerramientas.add(menuItemComparar);
        menuHerramientas.add(menuItemContar);
        menuHerramientas.add(menuItemBuscar);
        menuHerramientas.add(menuItemAgenda);

        menuBar.add(menuArchivo);
        menuBar.add(menuHerramientas);

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
