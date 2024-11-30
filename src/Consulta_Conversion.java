import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta_Conversion
{
    public Conversor conversion(int cantidad, String entrada, String salida)
    {
        String clave = "a2330d0c69200e43f0cb8ca9";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + clave + "/pair/" + entrada + "/" + salida + "/" + cantidad);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest consulta = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
            try {
            HttpResponse<String> respuesta = cliente
                        .send(consulta, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(respuesta.body(), Conversor.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Ha ocurrido un problema: " + e.getMessage());
            }
    }
}
