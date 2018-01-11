package app.service;

import app.bancoDados.JogoDAO;
import app.modelo.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {

    @Autowired
    private JogoDAO jogoDAO;

    public Jogo listaDesenvolvedores(Integer id){
        jogoDAO.criar();
        return jogoDAO.organizaJogos(id);
    }

}
