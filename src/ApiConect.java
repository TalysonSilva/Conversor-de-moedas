import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConect {
    public Coin searchAddress(String chosenCurrency) {
        URI address = URI.create("https://v6.exchangerate-api.com/v6/" +
                "04f0ec3a2388cb3474af1c2b/latest/" + chosenCurrency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(address)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Coin.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possivel concluir a operação");
        }
    }
}
