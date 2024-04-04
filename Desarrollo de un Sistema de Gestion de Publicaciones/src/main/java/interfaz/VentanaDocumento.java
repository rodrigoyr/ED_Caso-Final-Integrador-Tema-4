import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VentanaDocumento extends JInternalFrame {
    private JTextArea textArea;
    private File file;

    public VentanaDocumento(String title) {
        super(title, true, true, true, true);
        setSize(400, 300);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem saveMenuItem = new JMenuItem("Guardar");
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarDocumento();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el documento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void cargarDocumento() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        textArea.setText(stringBuilder.toString());
        reader.close();
    }

    public void guardarDocumento() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(textArea.getText());
        writer.close();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
