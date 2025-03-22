package Jonatas.ApiFipe;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class Service {

    private String consultarURL(String apiUrl)
    {
        String dados="";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode(). is2xxSuccessful())
        {
            return dados = responseEntity.getBody();
        }else
        {
            return dados ="falha" + responseEntity.getStatusCode();
        }

    }

    public String consultaMarcas()
    {
        return  consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }

    public String consultaModelos(int id)
    {
        return  consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+id+"/modelos");
    }

    public String consultaAnos(int marca, int modelo)
    {
        return  consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos");
    }

    public String consultarValor(int marca, int modelo, String ano)
    {
        return  consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+marca+"/modelos/"+modelo+"/anos"+ano);
    }
}
