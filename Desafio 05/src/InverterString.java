
// 5) Inverter uma string sem usar funções prontas

import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String input = sc.nextLine();

        String invertida = inverterString(input);
        System.out.println("String invertida: " + invertida);

        sc.close();
    }

    public static String inverterString(String str) {
        String invertida = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            invertida += str.charAt(i);
        }
        return invertida;
    }
}
