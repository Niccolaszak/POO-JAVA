package exercicioaula13.exercicio01;

/**
 * Enum que representa os possíveis status de um Pedido.
 * Cada status tem uma descrição associada para facilitar a exibição.
 */
public enum StatusPedido {
    NOVO("Novo Pedido"),
    PROCESSANDO("Em Processamento"),
    ENVIADO("Enviado para o Cliente"),
    ENTREGUE("Entregue com Sucesso"),
    CANCELADO("Pedido Cancelado");

    private final String descricao;

    // Construtor para associar uma descrição a cada status
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    // Método para obter a descrição do status
    public String getDescricao() {
        return descricao;
    }
}
