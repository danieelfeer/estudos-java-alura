package modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep{

    public CepAPI buscarCep(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            return new Gson().fromJson(response.body(), CepAPI.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o CEP informado");
        }

    }

}
