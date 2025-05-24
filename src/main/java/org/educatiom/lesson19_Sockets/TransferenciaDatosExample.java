package org.educatiom.lesson19_Sockets;

public class TransferenciaDatosExample {

    public static void main(String[] args) {

        System.out.println("--------- Transferencia de Datos (Transport) ----------");
        //TCP
        /*TCP es un protocolo fiable y preciso que evita la pérdida de datos. Un mensaje siempre se entregará con la
        máxima precisión, o no se entregará en absoluto. El destinatario no necesita lógica para ordenar los datos, ya
        que los datos entrantes ya estarán ordenados.*/

        //UDP
        /*UDP no es tan confiable, pero es un protocolo de transferencia de datos más rápido. Las partes emisoras y
        receptoras necesitan alguna lógica adicional para poder trabajar con este protocolo. Pero echemos un vistazo a
        cómo funciona usando el ejemplo de un juego de computadora o un juego móvil que se juega a través de la red.
        Es posible que ya no nos importe lo que debería haber llegado hace 5 segundos, y podemos omitir un par de
        paquetes si no llegan a tiempo: el juego puede retrasarse, ¡pero aún puedes jugar!.
        En Java, para trabajar con datagramas transmitidos sobre UDP, usamos objetos de las clases DatagramSocket y DatagramPacket
        */
    }
}
