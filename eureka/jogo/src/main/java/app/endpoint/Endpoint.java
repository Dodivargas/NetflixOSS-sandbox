package app.endpoint;

import app.modelo.Jogo;
import app.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogos")
public class Endpoint {

    @Autowired
     private JogoService jogoService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Jogo listar(@PathVariable(value = "id") Integer id){
    return jogoService.listaDesenvolvedores(id);
    }
}
