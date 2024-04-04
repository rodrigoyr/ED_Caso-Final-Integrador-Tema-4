import javax.swing.*;
import java.awt.*;

public class OtrosComponentesInterfaz extends JFrame {
    public OtrosComponentesInterfaz() {
        super("Otros Componentes de Interfaz");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel label1 = new JLabel("Etiqueta 1:");
        JTextField textField1 = new JTextField();

        JLabel label2 = new JLabel("Etiqueta 2:");
        JTextField textField2 = new JTextField();

        JButton boton = new JButton("Botón");

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(boton);

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OtrosComponentesInterfaz().setVisible(true);
            }
        });
    }
}
