package exercicioaula14.exercicio02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GerenciadorCidades {

    public static void main(String[] args) {
        Map<String, List<String>> mapaEstadosCidades = new HashMap<>();


        mapaEstadosCidades.put("SP", new ArrayList<>(Arrays.asList("São Paulo", "Campinas", "Santos")));
        mapaEstadosCidades.put("RJ", new ArrayList<>(Arrays.asList("Rio de Janeiro", "Niterói", "Búzios")));
        mapaEstadosCidades.put("MG", new ArrayList<>(Arrays.asList("Belo Horizonte", "Uberlândia", "Ouro Preto")));
        mapaEstadosCidades.put("BA", new ArrayList<>(Arrays.asList("Salvador", "Feira de Santana")));

        System.out.println("Mapa inicializado com sucesso.");
        System.out.println("----------------------------------------");

        System.out.println("A) Adicionando Cidades:");
        adicionarCidade(mapaEstadosCidades, "SP", "Guarulhos"); 
        adicionarCidade(mapaEstadosCidades, "PR", "Curitiba");   
        adicionarCidade(mapaEstadosCidades, "PR", "Londrina");   
        System.out.println("Cidades de SP após adição: " + cidadesDoEstado(mapaEstadosCidades, "SP"));
        System.out.println("Cidades de PR após adição: " + cidadesDoEstado(mapaEstadosCidades, "PR"));
        System.out.println("----------------------------------------");

        System.out.println("B) Buscando Cidades do Estado (RJ):");
        List<String> cidadesRJ = cidadesDoEstado(mapaEstadosCidades, "RJ");
        System.out.println("Cidades do RJ: " + cidadesRJ);
        
        System.out.println("\nB) Buscando Estado Inexistente (DF):");
        List<String> cidadesDF = cidadesDoEstado(mapaEstadosCidades, "DF");
        System.out.println("Cidades do DF: " + cidadesDF);
        System.out.println("----------------------------------------");

        System.out.println("C) Imprimindo Todas as Cidades de Cada Estado:");
        imprimirTodasCidades(mapaEstadosCidades);
    }

   
    public static void adicionarCidade(Map<String, List<String>> mapa, String estado, String cidade) {
        List<String> cidades = mapa.computeIfAbsent(estado, k -> new ArrayList<>());

        if (!cidades.contains(cidade)) {
            cidades.add(cidade);
        } else {
        }
    }

    public static List<String> cidadesDoEstado(Map<String, List<String>> mapa, String estado) {
        return mapa.getOrDefault(estado, new ArrayList<>());
    }

    
    public static void imprimirTodasCidades(Map<String, List<String>> mapa) {
        if (mapa.isEmpty()) {
            System.out.println("O mapa de estados e cidades está vazio.");
            return;
        }

        for (Map.Entry<String, List<String>> entrada : mapa.entrySet()) {
            String estado = entrada.getKey();
            List<String> cidades = entrada.getValue();

            System.out.println("Estado (" + estado + "):");
            System.out.println("  Cidades: " + String.join(", ", cidades) + " (" + cidades.size() + " cidades)");
        }
    }
}