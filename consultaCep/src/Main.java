import modelos.BuscaCep;
import modelos.CepAPI;
import modelos.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Buscar CEP");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o CEP que deseja buscar: ");
                    String cep = scanner.nextLine();

                    BuscaCep buscaCep = new BuscaCep();
                    CepAPI cepAPI = buscaCep.buscarCep(cep);
                    System.out.println(cepAPI);

                    GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
                    geradorDeArquivo.salvarArquivoEmJson(cepAPI);

                    System.out.println("Você digitou o CEP: " + cep);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (escolha != 0);

        scanner.close();
    }
}