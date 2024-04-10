import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear una instancia de la ventana principal
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                // Hacer visible la ventana principal
                ventanaPrincipal.setVisible(true);
                import editor.EditorTextoInteractivo;

                // Crear una instancia del Editor de Texto Interactivo
                editor.EditorTextoInteractivo editorTexto = new editor.EditorTextoInteractivo();
                // Agregar el Editor de Texto Interactivo a la ventana principal
                ventanaPrincipal.agregarPanel(editorTexto, "Editor de Texto");

                // Crear una instancia del Comparador y Contador de Contenido
                editor.ComparadorArchivos contadorContenido = new editor.ComparadorArchivos();
                // Agregar el Comparador y Contador de Contenido a la ventana principal
                ventanaPrincipal.agregarPanel(contadorContenido, "Comparador y Contador");

                // Crear una instancia del Búscador de Palabras y Gestión de Contactos
                editor.AgendaContactos buscadorContactos = new editor.AgendaContactos();
                // Agregar el Búscador de Palabras y Gestión de Contactos a la ventana principal
                ventanaPrincipal.agregarPanel(buscadorContactos, "Búsqueda de Palabras y Gestión de Contactos");

                // Crear una instancia de la Interfaz Gráfica Avanzada
                editor.OtrosComponentesInterfaz interfazAvanzada = new editor.OtrosComponentesInterfaz();
                // Agregar la Interfaz Gráfica Avanzada a la ventana principal
                ventanaPrincipal.agregarPanel(interfazAvanzada, "Interfaz Gráfica Avanzada");

                // Crear una instancia del Validador de Email y Diseño Gráfico
                editor.ValidadorEmailDiseno validadorEmailDiseno = new editor.ValidadorEmailDiseno();
                // Agregar el Validador de Email y Diseño Gráfico a la ventana principal
                ventanaPrincipal.agregarPanel(validadorEmailDiseno, "Validación de Email y Diseño Gráfico");
            }
        });
    }
}
