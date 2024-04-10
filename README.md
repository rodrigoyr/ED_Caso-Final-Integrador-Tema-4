# ED_Caso-Final-Integrador-Tema-4

El sistema de gestión de publicaciones es una aplicación desarrollada para escritores y periodistas, diseñada para permitirles crear, editar, almacenar y compartir sus trabajos de manera eficiente y segura. Este documento proporciona una descripción detallada de cada módulo de la aplicación, así como los diagramas de las interfaces de usuario y explicaciones sobre cómo se manejan los datos y eventos en la aplicación. Esta es la estrcutura que he seguido en mi proyecto: src/
├── main/
│   ├── java/
│   │   ├── editor/
│   │   │   ├── EditorTextoInteractivo.java
│   │   │   └── NavegacionListado.java
│   │   ├── comparador/
│   │   │   ├── ComparadorArchivos.java
│   │   │   └── ContadorContenido.java
│   │   ├── busqueda/
│   │   │   ├── BuscadorPalabras.java
│   │   │   └── AgendaContactos.java
│   │   ├── interfaz/
│   │   │   ├── VentanaPrincipal.java
│   │   │   ├── VentanaDocumento.java
│   │   │   ├── BarraDesplazamiento.java
│   │   │   └── OtrosComponentesInterfaz.java
│   │   └── validacion/
│   │       └── ValidadorEmail.java
│   └── Main.java
└── test/
    └── MainTest.java


## Descripción de los Módulos
*2.1. Editor de Texto Interactivo*
Descripción: Este módulo permite a los usuarios escribir y editar textos en una interfaz gráfica, ademas ofrece la opción de guardar los textos en archivos.
Manejo de Datos y Eventos: Cuando un usuario escribe o edita texto, los datos se almacenan en un objeto String o StringBuilder. Cuando el usuario guarda el texto, se escribe en un archivo utilizando clases de entrada y salida de Java.
*2.2. Comparador y Contador de Contenido*
Descripción: Este módulo proporciona herramientas para comparar dos archivos y encontrar diferencias, así como para contar el número de palabras en un documento.
Manejo de Datos y Eventos: Los datos de los archivos se leen utilizando clases de entrada y salida de Java. Se utilizan algoritmos de comparación de archivos para encontrar diferencias entre ellos, he agregado la de diferencia de palabras. Para el contador de palabras, se cuenta el número de espacios en blanco y caracteres en el texto. Los eventos del botón de comparación y contador de palabras se manejan utilizando clases de escucha de eventos.
*2.3. Búsqueda de Palabras y Gestión de Contactos*
Descripción: Este módulo permite buscar palabras en un documento y gestionar contactos ya gregados.
Manejo de Datos y Eventos: La búsqueda de palabras se realiza utilizando algoritmos de búsqueda de cadenas en el texto. Los contactos se almacenan en una lista de objetos Contacto, que contiene el nombre, correo y numero.
*2.4. Interfaz Gráfica Avanzada*
Descripción: Este módulo mejora la experiencia con características como múltiples ventanas, seguimiento del ratón y barras de desplazamiento interactivas.
Manejo de Datos y Eventos: Las múltiples ventanas se gestionan utilizando clases de contenedores de Swing como JFrame y JPanel. El seguimiento del ratón se implementa utilizando clases de escucha de eventos de ratón. Las barras de desplazamiento interactivas utilizan clases de barras de desplazamiento de Swing y se actualizan mediante eventos de desplazamiento.
*2.5. Validación de E-mail y Diseño Gráfico*
Descripción: Este módulo ofrece una función de validación para los correos introducidos, así como una función de dibujo.
Manejo de Datos y Eventos: La validación del correo electrónico se realiza mediante expresiones regulares para verificar el formato correcto del correo electrónico introducido por el usuario. El dibujo se implementa utilizando clases de componentes de dibujo de Swing. Los eventos de teclado y ratón se utilizan para capturar las acciones del usuario al dibujar.

## Problemas y soluciones
Este proyecto lo he estructurado y emepzado con bastante margen de tiempo, por lo que los errores principales que he tenido en otros trabajos han desapaecido, como digo, los errores han sido mínimos en los módulos y en sus clases y código, como puede observar, a la hora de ejecutar vada clase, aparece la interfaz interactiva de cada funcionalidad, por lo que lo último que quedaba era crear el main y su test. En el momento de crear el main, he tratado de instanciar todas las clases en la ventana principal, y agregarsimplemente la ventana principal al main para que así el usuario pueda hacer uso de todas las funciones, las cuales las que he creado sin mayor problema como ya he comentado en cada módulo. También he tratado de importar todas las clases en el main, lo que me ha parecido algo más sencillo, pero me he enconyrado con el problema de que necesitaba instanciar los modulos dentro de la ventana principal (interfaz interactiva), por lo que esto no me solucionaba ningún problema. Finalmente mi única opción, sería crear una interfaz interactiva entera con todas las funcionalidades en el main, pero vienfo el enunciado y pensando que es lo que más se valoraría, he llegado a la conclusion de dejar el main con el código ejecutable, pero en el que no se puede hacer uso de las funciones directamente, se puede observar que he desarrollao todas las funcionalidades del ejercicio como pide el enunciado en cda módulo, mi problema ha sido a la hora de instanciar los módulos en le interfaz interactiva principal que es la quue hace uso el usuario, incluso con la ayuda de Github Copilot, y ChatGPT no he sido capaz, me quedo con la duda de como podria haber instanciado correctamente todo, aunque supongo que será un problema de este código, y no de los códigos de cada m´coulo, ya que estos han sido ejecutables por separado sin problema. A continuación, ofrezo el código con el cual no he sido capaz de instanciar los módulos. Muchas gracias.
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear una instancia de la ventana principal
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                
                // Instanciar los otros módulos y agregarlos a la ventana principal
                
                // Editor de Texto Interactivo
                EditorTexto editorTexto = new EditorTexto();
                ventanaPrincipal.add(editorTexto);
                
                // Comparador y Contador de Contenido
                ComparadorArchivos comparadorArchivos = new ComparadorArchivos();
                ventanaPrincipal.add(comparadorArchivos);
                
                // Búsqueda de Palabras y Gestión de Contactos
                BuscadorPalabras buscadorPalabras = new BuscadorPalabras();
                ventanaPrincipal.add(buscadorPalabras);
                
                AgendaContactos agendaContactos = new AgendaContactos();
                ventanaPrincipal.add(agendaContactos);
                
                // Interfaz Gráfica Avanzada
                BarraDesplazamiento barraDesplazamiento = new BarraDesplazamiento();
                ventanaPrincipal.add(barraDesplazamiento);
                
                // Validación de E-mail
                ValidadorEmail validadorEmail = new ValidadorEmail();
                ventanaPrincipal.add(validadorEmail);
                
                // Mostrar la ventana principal
                ventanaPrincipal.setVisible(true);
            }
        });
    }
}
