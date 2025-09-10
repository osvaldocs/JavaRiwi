package dia1;

import java.util.Scanner;

public class Condicionales {

    public static void clasificador(int a) {
        if (a > 0) {
            System.out.println("Es positivo.");
        } else if (a < 0) {
            System.out.println("Es negativo.");
        } else {
            System.out.println("Es cero.");
        }
    }

    public static void esMayor(int edad) {
        if (edad >= 18) {
            System.out.println("Adulto");
        } else if (edad >= 12 && edad <= 17) {
            System.out.println("Adolescente");
        } else if (edad < 12) {
            System.out.println("Niño");
        }
    }

    public static void opcion(int numero) {

        switch (numero) {
            case 1:
                System.out.println("Lunes");
                break;

            case 2:
                System.out.println("Martes");
                break;

            case 3:
                System.out.println("Miercoles");
                break;

            case 4:
                System.out.println("Jueves");
                break;

            case 5:
                System.out.println("Viernes");
                break;

            case 6:
                System.out.println("Sabao");
                break;

            case 7:
                System.out.println("Domingo");
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    public static void main(String[] args) {
        /**
         Actividad 5 – If - Else
         Haz un programa que reciba un número entero e imprima:

         "Es positivo" si el número es mayor que 0.
         "Es negativo" si es menor que 0.
         "Es cero" si es exactamente 0.


         Actividad 6 – If - Else If
         Pide al usuario su edad y muestra:

         "Niño" si tiene menos de 12.
         "Adolescente" si tiene entre 12 y 17.
         "Adulto" si tiene 18 o más.

         Actividad 7 – Switch
         Crea un programa que pida un número del 1 al 7 y muestre el día de la semana:

         1 → Lunes
         2 → Martes
         3 → Miércoles
         …
         7 → Domingo
         */

        clasificador(45);
        clasificador(0);
        clasificador(-4);

        System.out.println("Ingrese su edad:");
        Scanner scanner = new Scanner(System.in);
        String edadStr = scanner.nextLine();
        int edad = Integer.parseInt(edadStr);

        esMayor(edad);

        System.out.println("Ingrese un número del 1 al 7");
        int numero = Integer.parseInt(scanner.nextLine());

        opcion(numero);

    }
}
