
//3) Faturamento diário de uma distribuidora:
//Aqui está uma solução em Java para calcular o menor, o maior valor de faturamento e o número de dias com faturamento acima da média mensal.

import java.util.ArrayList;

public class Faturamento {
    public static void main(String[] args) {
        double[] faturamentos = {1000, 1500, 0, 2000, 0, 1800, 1300};
        ArrayList<Double> faturamentoValido = new ArrayList<>();

        // Filtra os dias sem faturamento
        for (double faturamento : faturamentos) {
            if (faturamento > 0) {
                faturamentoValido.add(faturamento);
            }
        }

        // Calcula o menor e maior valor de faturamento
        double menorFaturamento = faturamentoValido.get(0);
        double maiorFaturamento = faturamentoValido.get(0);
        double soma = 0;

        for (double faturamento : faturamentoValido) {
            if (faturamento < menorFaturamento) menorFaturamento = faturamento;
            if (faturamento > maiorFaturamento) maiorFaturamento = faturamento;
            soma += faturamento;
        }

        // Calcula a média
        double media = soma / faturamentoValido.size();

        // Conta os dias acima da média
        int diasAcimaMedia = 0;
        for (double faturamento : faturamentoValido) {
            if (faturamento > media) {
                diasAcimaMedia++;
            }
        }

        System.out.println("Menor faturamento: " + menorFaturamento);
        System.out.println("Maior faturamento: " + maiorFaturamento);
        System.out.println("Dias acima da média: " + diasAcimaMedia);
    }
}
