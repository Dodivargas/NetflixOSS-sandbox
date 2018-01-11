package app.endpoint;

import app.modelo.Jogo;
import app.service.GaleriaService;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/galeria")
public class Endpoint {

    @Autowired
    private GaleriaService galeriaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Jogo> listaGaleria() throws IOException, JSONException {
        return galeriaService.mostraGaleria();
    }

}