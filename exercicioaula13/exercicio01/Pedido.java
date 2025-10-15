package exercicioaula13.exercicio01;

/**
 * Representa um pedido em um sistema de e-commerce.
 * A classe gerencia seu próprio ciclo de vida através do StatusPedido.
 */
public class Pedido {

    private final long id;
    private final String produto;
    private double valor;
    private StatusPedido status;

    public Pedido(long id, String produto, double valor) {
        this.id = id;
        this.produto = produto;
        this.valor = valor;
        this.status = StatusPedido.NOVO; // Todo pedido começa como NOVO
    }

    // Métodos para transição de status
    
    public void processar() {
        if (this.status == StatusPedido.NOVO) {
            this.status = StatusPedido.PROCESSANDO;
            System.out.println("Transição: Pedido #" + id + " está em processamento.");
        } else {
            System.out.println("ERRO: Não é possível processar um pedido com status '" + this.status.getDescricao() + "'.");
        }
    }

    public void enviar() {
        if (this.status == StatusPedido.PROCESSANDO) {
            this.status = StatusPedido.ENVIADO;
            System.out.println("Transição: Pedido #" + id + " foi enviado.");
        } else {
            System.out.println("ERRO: O pedido só pode ser enviado se estiver em processamento. Status atual: '" + this.status.getDescricao() + "'.");
        }
    }

    public void entregar() {
        if (this.status == StatusPedido.ENVIADO) {
            this.status = StatusPedido.ENTREGUE;
            System.out.println("Transição: Pedido #" + id + " foi entregue.");
        } else {
            System.out.println("ERRO: O pedido só pode ser marcado como entregue se já tiver sido enviado. Status atual: '" + this.status.getDescricao() + "'.");
        }
    }

    public void cancelar() {
        // Regra de negócio: um pedido só pode ser cancelado se não foi enviado ainda.
        if (this.status == StatusPedido.NOVO || this.status == StatusPedido.PROCESSANDO) {
            this.status = StatusPedido.CANCELADO;
            System.out.println("Transição: Pedido #" + id + " foi cancelado.");
        } else {
            System.out.println("ERRO: Não é possível cancelar um pedido que já foi '" + this.status.getDescricao() + "'.");
        }
    }

    // Getter para o status
    public StatusPedido getStatus() {
        return status;
    }
    
    @Override
    public String toString() {
        return "Pedido {" +
               "id=" + id +
               ", produto='" + produto + '\'' +
               ", valor=" + valor +
               ", status=" + status.getDescricao() + // Usando a descrição amigável
               '}';
    }
}
