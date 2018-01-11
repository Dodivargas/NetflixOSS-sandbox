package app.bancoDados;

import app.modelo.Jogo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class JogoDAO {

    private final ArrayList<Jogo> jogos = new ArrayList<>();


    public void criar() {

        Jogo jogo1 = new Jogo("PUBG", 1);
        Jogo jogo2 = new Jogo("Counter Strike", 2);
        Jogo jogo3 = new Jogo("Lolzinho", 3);
        Jogo jogo4 = new Jogo("Golf it", 4);
        Jogo jogo5 = new Jogo("Mario bross", 5);
        jogos.add(jogo1);
        jogos.add(jogo2);
        jogos.add(jogo3);
        jogos.add(jogo4);
        jogos.add(jogo5);
    }

    public Jogo organizaJogos(Integer id) {
        Jogo jogo = new Jogo("Não tem musica com esse id", 0);

        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(i).getId().equals(id))
            jogo = jogos.get(i);
        }
        return jogo;
    }
}