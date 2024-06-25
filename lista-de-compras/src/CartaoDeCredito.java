import java.util.ArrayList;

public class CartaoDeCredito {

    private float limite;
    private float saldo;
    private ArrayList<Item> listaCompras;

    public CartaoDeCredito(float limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaCompras = new ArrayList<>();
    }

    public float getSaldo() {
        return saldo;
    }

    public float getLimite() {
        return limite;
    }

    public ArrayList<Item> getListaCompras() {
        return listaCompras;
    }

    public boolean verificarCompra(Item compra){
        if(compra.getPreco() < this.saldo){
            this.saldo -= compra.getPreco();
            this.listaCompras.add(compra);
            return true;
        }

        return false;
    }
}