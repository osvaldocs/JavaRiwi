package dia3;
import java.util.Scanner;
import java.util.ArrayList;


public class Bucles {

    public static void main(String[] args) {

        /**
         For
         Patrón en pirámide Usa dos bucles for para imprimir:

            *
           ***
          *****
         *******

         */
        for (int i = 1; i <= 4; i++) {
            for (int j = 1;j<= 4-i; j++) {
                System.out.print(" ");
            }
            for (int k=1;k<=(2*i-1);k++){
                System.out.print("*");
            }
            System.out.println();
        }

        /**
         🔹 while
         Inverso de un número Pide un número entero y usando while obtén el número invertido (ejemplo: 12345 → 54321). Luego, indica si es capicúa.
         */
        System.out.println("Ingresa un numero:");
        Scanner scanner = new Scanner(System.in);


        int numero = scanner.nextInt();
        ArrayList<Integer> numInvertido = new ArrayList<>();
        boolean isCapicua = true;

        while (numero > 0) {
            int ultNum = numero % 10;
            numInvertido.add(ultNum);
            numero = numero / 10;

        }
        for (int i = 0; i < numInvertido.size(); i++) {
            System.out.print(numInvertido.get(i));
        }
        System.out.println("");
        for (int i = 0; i < numInvertido.size() /2; i++) {
                int j = numInvertido.size() -1 -i;

                if (!numInvertido.get(i).equals(numInvertido.get(j))) {
                    isCapicua = false;

                }

                if (isCapicua) {
                System.out.println("Is capicua");
                }
        }

        /**
         Usa do-while para repetir hasta que elija 0.

         Número adivinanza con pistas Genera un número aleatorio entre 1 y 100. Usa do-while para que el usuario intente adivinar. Si el número está a ±5 del secreto, muestra "¡Muy cerca!".
         */

        int randomNum = (int) (Math.random() * 100 + 1);
        System.out.println("Ingrese un numero entre 1 y 100:");
        int choosenNum = scanner.nextInt();

        

    }
}
