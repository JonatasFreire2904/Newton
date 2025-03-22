package Jonatas.ApiFipe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerFipe {

    Service _service = new Service();

    @GetMapping("/marcas")
    public String consultarMarcas()
    {
        return _service.consultaMarcas();
    }

    @GetMapping("/modelos/{marca}")
    public String consultarModelos(@PathVariable int marca)
    {
        return _service.consultaModelos(marca);
    }

    @GetMapping("/anos/{marca}/{modelo}")
    public String consultarAnos(@PathVariable int marca, @PathVariable int modelo)
    {
        return _service.consultaAnos(marca, modelo);
    }

    @GetMapping("valor/{marca}/{modelo}/{ano}")
    public String consultarValor(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano)
    {
        return _service.consultarValor(marca, modelo, ano);
    }
}
