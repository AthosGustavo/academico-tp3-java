package faculdade.infnet.academico.Service.Escola;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepService {

  public static String buscaCep(String cep){
    String responseJson = "";

    try{
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/")).build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      responseJson = response.body();
    }catch(InterruptedException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }

    return responseJson;
  }
}
