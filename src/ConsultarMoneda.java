import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Monedas consultaMoneda (String monedaBase, String monedaTarget, String amount){
        double cantidad = Double.parseDouble(amount);
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/741ddd6ca623bf32d3894f31/pair/"+ monedaBase + "/" + monedaTarget + "/" + cantidad);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), Monedas.class);

        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda consultada");

        }

    }
    public Monedas consultaIndividual (String monedaBase){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/741ddd6ca623bf32d3894f31/latest/"+ monedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), Monedas.class);

        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda consultada");

        }
    }
}
