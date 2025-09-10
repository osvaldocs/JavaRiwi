package dia1;

public class Operadores {
    static int a = 10;
    static int b = 15;

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int resta(int a, int b) {
        return a - b;
    }

    public static int multi(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static int modulo(int a, int b) {
        return a % b;
    }

    public static void main(String[] args) {

        /**
         Crea un programa que:

         Declare dos números enteros (a y b).
         Calcule y muestre:
         Suma
         Resta
         Multiplicación
         División
         Módulo

         */
        System.out.println(sumar(a,b));
        System.out.println(resta(a,b));
        System.out.println(multi(a,b));
        System.out.println(division(a,b));
        System.out.println(modulo(a,b));

    }
}
