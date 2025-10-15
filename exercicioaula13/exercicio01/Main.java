package exercicioaula13.exercicio01;

/**
 * Classe principal para demonstrar o uso do Enum StatusPedido na classe Pedido.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Simulação de um Pedido Bem-Sucedido ---");
        Pedido pedido1 = new Pedido(101, "Smartphone XPTO", 2500.00);
        System.out.println("Estado inicial: " + pedido1);

        pedido1.processar();
        System.out.println("Estado atual: " + pedido1);

        pedido1.enviar();
        System.out.println("Estado atual: " + pedido1);

        pedido1.entregar();
        System.out.println("Estado final: " + pedido1);

        System.out.println("\n--- Tentativa de Transição Inválida ---");
        // Tentando enviar o pedido novamente
        pedido1.enviar(); 
        
        System.out.println("\n--- Simulação de um Pedido Cancelado ---");
        Pedido pedido2 = new Pedido(102, "Fone de Ouvido ABC", 350.00);
        System.out.println("Estado inicial: " + pedido2);

        pedido2.processar();
        System.out.println("Estado atual: " + pedido2);

        pedido2.cancelar();
        System.out.println("Estado final: " + pedido2);
        
        // Tentando enviar um pedido cancelado
        pedido2.enviar();
    }
}
