import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inputUsuario = new Scanner(System.in);

        System.out.println("Digite o limite do cartão:");
        float limiteCartao = inputUsuario.nextFloat();

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limiteCartao);

        int sair = 1;
        while (sair != 0){
            System.out.println("Digite a descrição da compra:");
            String descricaoCompra = inputUsuario.next();

            System.out.println("Digite o preço da compra:");
            float precoCompra = inputUsuario.nextFloat();

            Item itemCompra = new Item(descricaoCompra, precoCompra);
            boolean compraRealizada = cartaoDeCredito.verificarCompra(itemCompra);

            if(compraRealizada){
                System.out.println("Compra Realizada!");
            } else {
                System.out.println("Saldo Insuficiente!");
                System.out.println(cartaoDeCredito.getListaCompras());
            }

            System.out.println("Saldo atual: " + cartaoDeCredito.getSaldo());
            System.out.println("Digite 0 para sair ou 1 para continuar");
            sair = inputUsuario.nextInt();
        }

        Collections.sort(cartaoDeCredito.getListaCompras());
        System.out.println("******LISTA DE COMPRAS*******");
        for(Item c : cartaoDeCredito.getListaCompras()){
            System.out.println(c.getDescricao() + " - " + c.getPreco());
        }
        System.out.println("*****************************");

        System.out.println("Seu saldo é de R$" + cartaoDeCredito.getSaldo());




    }
}
