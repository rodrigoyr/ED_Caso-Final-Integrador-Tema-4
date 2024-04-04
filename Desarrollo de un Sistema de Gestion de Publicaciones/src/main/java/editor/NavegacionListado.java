import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class NavegacionListado extends JFrame {
    private JList<String> listaDocumentos;
    private DefaultListModel<String> modeloLista;

    public NavegacionListado() {
        super("Listado de Documentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        modeloLista = new DefaultListModel<>();
        listaDocumentos = new JList<>(modeloLista);

        cargarDocumentosGuardados();

        listaDocumentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaDocumentos.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String nombreDocumento = listaDocumentos.getSelectedValue();
                    if (nombreDocumento != null) {
                        abrirDocumento(nombreDocumento);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(listaDocumentos);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void cargarDocumentosGuardados() {
        File carpetaDocumentos = new File("documentos");
        if (!carpetaDocumentos.exists()) {
            carpetaDocumentos.mkdir();
            return;
        }

        File[] archivos = carpetaDocumentos.listFiles();
        for (File archivo : archivos) {
            if (archivo.isFile()) {
                modeloLista.addElement(archivo.getName());
            }
        }
    }

    private void abrirDocumento(String nombreDocumento) {
        try (BufferedReader lector = new BufferedReader(new FileReader("documentos/" + nombreDocumento))) {
            JTextArea areaTexto = new JTextArea();
            String linea;
            while ((linea = lector.readLine()) != null) {
                areaTexto.append(linea + "\n");
            }

            JFrame ventanaDocumento = new JFrame(nombreDocumento);
            ventanaDocumento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaDocumento.setSize(400, 400);
            ventanaDocumento.setLocationRelativeTo(this);
            ventanaDocumento.add(new JScrollPane(areaTexto));
            ventanaDocumento.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NavegacionListado().setVisible(true);
            }
        });
    }
}
