package org.educatiom.lesson07_ConversionDeTiposInstanceofExpressionSwitch;


public class ExpresionSwitchExample {

    //Sentencia Switch tradicional
    public String getProductTypeByName(String product) {
        String productType = "";

        switch (product) {
            case "Apple":
                productType = "Fruit";
                break;
            case "Peach":
                productType = "Fruit";
                break;
            case "Raspberry":
                productType = "Berry";
                break;
            case "Cherry":
                productType = "Berry";
                break;
            case "Tomato":
                productType = "Vegetable";
                break;
            default:
                productType = "Other";
                break;
        }

        return productType;
    }

    //Nueva expresion Switch
    public  static String getNewProductTypeByName(String product) {
        return switch (product) {
            case "Apple", "Peach" -> "Fruit";
            case "Raspberry", "Cherry"  -> "Berry";
            case "Tomato" -> "Vegetable";
            default -> "Other";
        };

    }

    /*Si necesitamos no solo devolver un resultado, sino también tener varias líneas de código, entonces nuestro
    interruptor se vería así:
    A partir de Java 13 se cambia el break por yield.
    La principal diferencia entre yield y break es que break devuelve el control de ejecución de una declaración de caso,
    pero yield devuelve el resultado de el cambio, actuando como una declaración de devolución interna.*/
    public static String getProductTypeByName2(String product) {
        var result = switch (product) {
            case "Apple", "Peach" -> {
                System.out.println("This is a Fruit");
                yield "Fruit";
            }
            case "Raspberry", "Cherry" -> {
                System.out.println("This is a Berry");
                yield "Berry";
            }
            case "Tomato" -> {
                System.out.println("This is a Vegetable");
                yield "Vegetable";
            }
            default -> {
                System.out.println("Other");
                yield "other";
            }

        };
        return result;
    }


    public static void main(String[] args) {

        //Sentencia Switch tradicional
        ExpresionSwitchExample switchExample = new ExpresionSwitchExample();
        System.out.println(switchExample.getProductTypeByName("Apple"));


        System.out.println("------------------- Expresion Switch  ---------------------");
        //Expresion Switch
        /*Nueva version de la Sentencia Switch. */
        System.out.println(ExpresionSwitchExample.getNewProductTypeByName("Orange"));
        /*Ahora el código se ve más limpio. La sintaxis de flecha de la programación funcional nos permite devolver
        valores sin la palabra clave break y, en general, el resultado de ejecutar el cambio ahora se puede guardar en
        una variable o devolver a través de la palabra clave return */

        //Devolviendo varias lineas de código.
        String product = ExpresionSwitchExample.getProductTypeByName2("Coffee");
        System.out.println("product = " + product);


    }
}
