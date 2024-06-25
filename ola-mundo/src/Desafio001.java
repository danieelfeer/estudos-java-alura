import java.util.Scanner;

public class Desafio001 {
    public static void main(String[] args) {
        String nome = "Bruce Wayne";
        String tipoConta = "Corrente";
        double saldo = 2000.0;

        String menu = "Digite sua opção *************" +
                "1 - Consultar saldo" +
                "2 - Transferir valor" +
                "3 - Receber valor" +
                "4 - Sair" +
                "***************************";

        int opcao = 0;
        Scanner leitura = new Scanner(System.in);
        while (opcao != 4){
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Seu saldo é de R$"+ saldo);
                    break;
                case 2:
                    leitura.close();
                    System.out.println("Valor que deseja transferir");
                    double valorTransferencia = leitura.nextDouble();
                    if(valorTransferencia > saldo){
                        System.out.println("Saldo insuficiente");
                        break;
                    }else {
                        saldo -= valorTransferencia;
                        break;
                    }
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }
}
