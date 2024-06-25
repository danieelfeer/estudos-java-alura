package Principal;

import br.com.alura.screenmach.excecao.ErroDeConversaoDeAnoExeception;
import br.com.alura.screenmach.modelos.Titulo;
import br.com.alura.screenmach.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainComBuscas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome de um filme:");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=cb4171a0";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            //Gson gson = new Gson();
            //Titulo meuTitulo = gson.fromJson(json, Titulo.class);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

            System.out.println(meuTituloOmdb);


            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro:");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Aconteceu um erro nos argumentos, verigique a escrita");
        } catch (ErroDeConversaoDeAnoExeception e){
            System.out.println(e.getMessage());
        }

        System.out.println("programa finalizou perfeitamente");
    }
}
