
//1) Cálculo da variável SOMA:
//O código dado executa uma soma incremental até que a variável K atinja o valor de INDICE.

public class SomaIndice {
            public static void main(String[] args) {
                int INDICE = 13, SOMA = 0, K = 0;

                while (K < INDICE) {
                    K = K + 1;
                    SOMA = SOMA + K;
                }

                System.out.println("Valor da SOMA: " + SOMA); // O valor será 91
            }
}