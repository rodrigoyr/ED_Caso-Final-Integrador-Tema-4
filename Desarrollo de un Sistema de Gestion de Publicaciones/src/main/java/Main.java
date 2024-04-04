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
            }
        });
    }
}
