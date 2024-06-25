public class Item implements Comparable<Item> {
    private String descricao;
    private float preco;

    public Item(String descricao, float preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return this.descricao + " - " + this.preco + "\n";
    }

    @Override
    public int compareTo(Item outraCompra) {
        return Double.valueOf(this.preco).compareTo(Double.valueOf(outraCompra.preco));
    }
}
