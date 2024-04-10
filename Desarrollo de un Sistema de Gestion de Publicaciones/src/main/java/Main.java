import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear una instancia de la ventana principal
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                // Hacer visible la ventana principal
                ventanaPrincipal.setVisible(true);
            }
        });
    }
}
