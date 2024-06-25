import java.util.Random;
import java.util.Scanner;

public class Adivinha {

    public static void main(String[] args) {
        int numeroSorteado = new Random().nextInt(10);
        Scanner respostaUsuario = new Scanner(System.in);
        int quantidadeTentativas = 5;

        int contadorTentativas = 1;

        System.out.println("Adivinhe o Número de 1 a 100\n" +
                "Você têm " + quantidadeTentativas + "tentativas");

        while(contadorTentativas <= quantidadeTentativas){
            int tentativa = respostaUsuario.nextInt();

            if(tentativa == numeroSorteado){
                respostaUsuario.close();

                System.out.println("Você acertou o número Sorteado " + numeroSorteado + "com " + contadorTentativas +" tentativas!");

                break;
            }else {
                if(tentativa > numeroSorteado){
                    System.out.println("O número é menor");
                } else {
                    System.out.println("O número é maior");
                }
                contadorTentativas++;
            }

        }
        if(contadorTentativas >= 5){
            System.out.println("Acabou suas tentativas :(\n" +
                    "O número Sorteado era " + numeroSorteado);
        }
    }

}
