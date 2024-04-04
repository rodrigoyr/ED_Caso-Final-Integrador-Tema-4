import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class ValidadorEmail extends JFrame {
    private JTextField campoEmail;
    private JLabel etiquetaValidacion;

    public ValidadorEmail() {
        super("Validador de Email");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        campoEmail = new JTextField(20);
        campoEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarEmail();
            }
        });

        etiquetaValidacion = new JLabel();

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese su email: "));
        panel.add(campoEmail);
        panel.add(etiquetaValidacion);

        add(panel, BorderLayout.CENTER);
    }

    private void validarEmail() {
        String email = campoEmail.getText();
        if (esEmailValido(email)) {
            etiquetaValidacion.setText("Email válido");
            etiquetaValidacion.setForeground(Color.GREEN);
        } else {
            etiquetaValidacion.setText("Email inválido");
            etiquetaValidacion.setForeground(Color.RED);
        }
    }

    private boolean esEmailValido(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ValidadorEmail().setVisible(true);
            }
        });
    }
}
