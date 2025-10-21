package exercicioaula14.exercicio01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listaCuringa {
    /**
     * Imprime todos os elementos de uma lista de tipo desconhecido.
     * O curinga '?' significa que a lista pode conter elementos de *qualquer* tipo.
     *
     * @param lista A lista a ser impressa.
     */
    public static void imprimirLista(List<?> lista) {
        System.out.println("--- Imprimindo Lista ---");
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia.");
            return;
        }

        // Você pode iterar sobre os elementos, pois o tipo é Object,
        // mas não pode *adicionar* novos elementos (com exceção de 'null').
        for (Object elemento : lista) {
            // Imprime o elemento e sua classe (tipo)
            System.out.println("Elemento: " + elemento + " (Tipo: " + elemento.getClass().getSimpleName() + ")");
        }

        System.out.println("Total de elementos: " + lista.size());
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        // 1. Teste com uma lista de Inteiros
        List<Integer> numeros = Arrays.asList(10, 25, 30, 45);
        System.out.println("Teste 1: Lista de Inteiros (List<Integer>)");
        imprimirLista(numeros);
        System.out.println("\n");

        // 2. Teste com uma lista de Strings
        List<String> frutas = new ArrayList<>();
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Pera");
        System.out.println("Teste 2: Lista de Strings (List<String>)");
        imprimirLista(frutas);
        System.out.println("\n");

        // 3. Teste com uma lista de Doubles
        List<Double> precos = Arrays.asList(9.99, 15.50, 4.25);
        System.out.println("Teste 3: Lista de Doubles (List<Double>)");
        imprimirLista(precos);
        System.out.println("\n");

        // 4. Teste com uma lista Mista (de Objetos, se for declarada assim)
        // Isso é menos comum, mas demonstra que o '?' lida com qualquer coisa.
        List<Object> mista = new ArrayList<>();
        mista.add("Olá");
        mista.add(2024);
        mista.add(true);
        System.out.println("Teste 4: Lista Mista (List<Object>)");
        imprimirLista(mista);
        System.out.println("\n");
        
        // 5. Teste com uma lista vazia
        List<String> vazia = new ArrayList<>();
        System.out.println("Teste 5: Lista Vazia (List<String>)");
        imprimirLista(vazia);
    }
}
