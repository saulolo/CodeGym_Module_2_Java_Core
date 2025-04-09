package org.educatiom.lesson16_Serializacion;

import java.util.Arrays;
import java.util.List;

public class XMLExample {

    public static void main(String[] args) {

        System.out.println("--------- XML ----------");
        //XML
        /*XML significa eXtensible Markup Language.
        Es un formato de texto que se usa para almacenar y transportar datos. Fue diseñado para ser legible tanto por humanos
        como por máquinas.
        Un archivo XML tiene una estructura jerárquica, parecida al HTML, pero enfocado en los datos, no en la
        presentación.
        Características clave:
         Autodescriptivo: los nombres de las etiquetas describen el contenido (<nombre>, <edad>...).
         Jerárquico: permite anidar elementos, formando una estructura tipo árbol.
         Extensible: puedes definir tus propias etiquetas.
         Independiente del lenguaje: puedes leerlo desde Java, Python, JavaScript, etc.
         Bien formado: todas las etiquetas deben estar correctamente cerradas y anidadas.
       ¿Dónde se usa XML?
        Configuración de aplicaciones (por ejemplo, pom.xml en Maven).
        Comunicación entre sistemas (APIs tipo SOAP).
        Almacenamiento de datos.
        Definición de interfaces gráficas (Android usa XML para layouts).
       Estructura básica de XML
        Un archivo XML tiene una estructura jerárquica, parecida al HTML, pero enfocado en los datos, no en la presentación.
       Ejemplo:
        */
/*        <persona>
            <nombre>Juan</nombre>
            <edad>30</edad>
            <profesion>Ingeniero</profesion>
        </persona>
        */
        /*esquema XML
    Un esquema XML es una descripción de la estructura de un documento XML. La especificación correspondiente
    (definición de esquema XML o XSD) es una recomendación del W3C.

    XSD fue diseñado para expresar las reglas que debe seguir un documento XML. Pero lo más interesante para nosotros es
    que XSD fue diseñado para ser utilizado en el desarrollo de software que procesa documentos XML. Nos permite
    verificar la corrección de un documento XML mediante programación.*/
    }

    public class Book{

            private String title;
            private String author;
            private Integer pageCount;
            private List<String> chapters;

        public Book(String title, String author, Integer pageCount, List<String> chapters) {
            this.title = title;
            this.author = author;
            this.pageCount = pageCount;
            this.chapters = chapters;
        }
    }
    //Objeto
    Book myBook = new Book("Viaje de la tierra a la luna", "Julio Verne", 300, Arrays.asList("Capitulo 1", "Capitulo 2", "Capitulo 3"));

    //Este es un ejemplo de una representación XML válida de un objeto Java que contiene 4 campos, uno de los cuales es una colección

    /*
    <Book>
        <title>Viaje de la tierra a la luna</title>
        <author>Julio Verne</author>
        <pageCount>300</pageCount>
        <chapters>
            <chapters>Capitulo 1</chapters>
            <chapters>Capitulo 2</chapters>
            <chapters>Capitulo 3</chapters>
        </chapters>
    </Book>
    */

}
