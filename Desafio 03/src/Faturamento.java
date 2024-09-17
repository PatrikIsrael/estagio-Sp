
//3) Faturamento diário de uma distribuidora:
//Aqui está uma solução em Java para calcular o menor, o maior valor de faturamento e o número de dias com faturamento acima da média mensal.


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Faturamento {
    public static void main(String[] args) {
        // Caminho para o arquivo JSON
        String caminhoArquivo = "C:\\Users\\Patrik\\Documents\\dados.json";

        // Criar um ObjectMapper para ler o arquivo JSON
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Ler o arquivo JSON e mapear para uma lista de mapas
            List<Map<String, Object>> dados = objectMapper.readValue(new File(caminhoArquivo), new TypeReference<>() {});

            // Filtrar apenas os dias com faturamento (ignorar zeros)
            List<Double> valores = dados.stream()
                    .map(entry -> (Double) entry.get("valor"))
                    .filter(valor -> valor > 0)
                    .collect(Collectors.toList());

            if (valores.isEmpty()) {
                System.out.println("Nenhum faturamento disponível para análise.");
                return;
            }

            // Encontrar o menor e o maior valor de faturamento
            double menorFaturamento = valores.stream().min(Double::compare).orElse(0.0);
            double maiorFaturamento = valores.stream().max(Double::compare).orElse(0.0);

            // Calcular a média mensal
            double soma = valores.stream().mapToDouble(Double::doubleValue).sum();
            double media = soma / valores.size();

            // Contar o número de dias com faturamento acima da média
            long diasAcimaMedia = valores.stream().filter(valor -> valor > media).count();

            // Exibir os resultados
            System.out.printf("Menor faturamento: %.2f%n", menorFaturamento);
            System.out.printf("Maior faturamento: %.2f%n", maiorFaturamento);
            System.out.printf("Número de dias acima da média: %d%n", diasAcimaMedia);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }

}
