import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class BarraDesplazamiento extends JFrame {
    private JTextArea areaTexto;
    private JScrollBar barraDesplazamiento;

    public BarraDesplazamiento() {
        super("Barra de Desplazamiento Interactiva");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        areaTexto.setLineWrap(true);

        barraDesplazamiento = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 101);
        barraDesplazamiento.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                areaTexto.setCaretPosition((int)(areaTexto.getDocument().getLength() * e.getValue() / 100.0));
            }
        });

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setVerticalScrollBar(barraDesplazamiento);

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BarraDesplazamiento().setVisible(true);
            }
        });
    }
}
