package app.bancoDados;

import app.modelo.GaleriaJogos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class GaleriaDAO {

    private final ArrayList<Integer> galeriaJogos = new ArrayList<>();

    public GaleriaDAO() {
        GaleriaJogos galeriaJogos1 = new GaleriaJogos(3);
        GaleriaJogos galeriaJogos2 = new GaleriaJogos(2);
        GaleriaJogos galeriaJogos3 = new GaleriaJogos(5);
        GaleriaJogos galeriaJogos4 = new GaleriaJogos(4);
        galeriaJogos.add(galeriaJogos1.getId());
        galeriaJogos.add(galeriaJogos2.getId());
        galeriaJogos.add(galeriaJogos3.getId());
        galeriaJogos.add(galeriaJogos4.getId());
    }

    public ArrayList<Integer> retornaGaleria(){
        return galeriaJogos;
    }
}
