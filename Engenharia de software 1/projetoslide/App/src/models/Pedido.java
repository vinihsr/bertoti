import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date data;
    private List<Item> itens;

    public Pedido(int id, Date data){
        this.id = id;
        this.data = data;
        itens = new ArrayList<Item>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public float calcularTotal() {
        float total = 0;
        for (Item item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }

    public void imprimir(){
        System.out.println("Id: " + getId());
        System.out.println("Data: " + getData());
        System.out.println("Lista de pedidos: " + getItens());
    }
}

