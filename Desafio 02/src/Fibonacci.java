
//2) Verificação se um número pertence à sequência de Fibonacci:
//Aqui está um exemplo em Java para verificar se um número pertence à sequência de Fibonacci.
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int num = sc.nextInt();

        if (isFibonacci(num)) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }

        sc.close();
    }

    public static boolean isFibonacci(int num) {
        int fib1 = 0, fib2 = 1;
        while (fib1 <= num) {
            if (fib1 == num) {
                return true;
            }
            int nextFib = fib1 + fib2;
            fib1 = fib2;
            fib2 = nextFib;
        }
        return false;
    }
}
