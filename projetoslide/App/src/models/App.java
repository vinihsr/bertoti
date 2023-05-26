import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Cria uma lista de itens
        List<Item> itens = new ArrayList<>();

        Item item1 = new Item(6,2,15);
        //item1.setId(1);
        //item1.setQuantidade(2);
        //item1.setPrecoUnitario(10.0f);
        itens.add(item1);

        Item item2 = new Item(12, 1, 10);
        //item2.setId(2);
        //item2.setQuantidade(3);
        //item2.setPrecoUnitario(15.0f);
        itens.add(item2);

        Pedido pedido = new Pedido(9, null);
        pedido.setId(1);
        pedido.setData(new Date());
        pedido.setItens(itens);

        float totalPedido = pedido.calcularTotal();
        System.out.println("Total do pedido: " + totalPedido);

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setId(1);
        formaPagamento.setDescricao("Cartão de crédito");

        formaPagamento.efetuarPagamento(totalPedido);
        System.out.println("Pagamento efetuado com sucesso!");

        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Camiseta");
        produto.setPreco(29.9f);

        float precoProduto = produto.obterPreco();
        System.out.println("Preço do produto: " + precoProduto);
    }
}
