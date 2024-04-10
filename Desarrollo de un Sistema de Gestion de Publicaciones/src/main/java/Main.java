import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear una instancia de la ventana principal
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                // Hacer visible la ventana principal
                ventanaPrincipal.setVisible(true);

                // Crear una instancia del editor de texto interactivo
                EditorTextoInteractivo editorTexto = new EditorTextoInteractivo();
                // Agregar el editor de texto a la ventana principal
                ventanaPrincipal.agregarPanel(editorTexto, "Editor de Texto");

                // Crear una instancia de la ventana de documentos
                VentanaDocumento documento = new VentanaDocumento("documentos/documento.txt");
                // Agregar la ventana de documentos a la ventana principal
                ventanaPrincipal.agregarPanel(documento, "Documento");

                // Crear una instancia del contador de contenido
                ContadorContenido contadorContenido = new ContadorContenido();
                // Agregar el contador de contenido a la ventana principal
                ventanaPrincipal.agregarPanel(contadorContenido, "Contador de Contenido");

                // Crear una instancia de los otros componentes de interfaz
                OtrosComponentesInterfaz otrosComponentes = new OtrosComponentesInterfaz();
                // Agregar los otros componentes de interfaz a la ventana principal
                ventanaPrincipal.agregarPanel(otrosComponentes, "Otros Componentes de Interfaz");

                // Crear una instancia del comparador y contador de contenido
                ComparadorContadorContenido comparadorContador = new ComparadorContadorContenido();
                // Agregar el comparador y contador de contenido a la ventana principal
                ventanaPrincipal.agregarPanel(comparadorContador, "Comparador y Contador");

                // Crear una instancia del buscador de palabras y gestión de contactos
                BuscadorPalabrasAgendaContactos buscadorAgenda = new BuscadorPalabrasAgendaContactos();
                // Agregar el buscador de palabras y gestión de contactos a la ventana principal
                ventanaPrincipal.agregarPanel(buscadorAgenda, "Búsqueda de Palabras y Agenda de Contactos");

                // Crear una instancia de la interfaz gráfica avanzada
                InterfazGraficaAvanzada interfazAvanzada = new InterfazGraficaAvanzada();
                // Agregar la interfaz gráfica avanzada a la ventana principal
                ventanaPrincipal.agregarPanel(interfazAvanzada, "Interfaz Gráfica Avanzada");

                // Crear una instancia del validador de email y diseño gráfico
                ValidadorEmailDisenoGrafico validadorEmailDiseno = new ValidadorEmailDisenoGrafico();
                // Agregar el validador de email y diseño gráfico a la ventana principal
                ventanaPrincipal.agregarPanel(validadorEmailDiseno, "Validación de Email y Diseño Gráfico");
            }
        });
    }
}

