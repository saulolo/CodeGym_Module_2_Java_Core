package org.educatiom.lesson19_Sockets;

public class SocketsExample {

    public static void main(String[] args) {

        System.out.println("--------- Sockets ----------");
        //Sockets
        /*Un socket tiene su propio número único que consta de una dirección IP y un número de puerto.
        * Ah. En otras palabras, un socket es un identificador de alguna ubicación de computadora virtual donde puede
        * residir un programa. Y otro programa envía mensajes a esta ubicación, lo que permite que los dos programas
        * se comuniquen*/

        /*"Los sockets son en realidad la forma más básica y primitiva para que los programas se comuniquen".
        "Java tiene dos clases para trabajar con sockets. Son Socket y ServerSocket ".*/

        System.out.println("--------- ServerSocket ----------");
        /*Es una clase especial cuyos objetos representan el servidor, es decir, me permiten atender las solicitudes que
        llegan a un socket en particular*/

        System.out.println("--------- Socket  ----------");
        /*"La clase Socket es en realidad un socket de cliente. Lo usamos para enviar mensajes a otro socket y recibir
        las respuestas".*/
    }
}
