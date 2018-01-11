package app.service;

import app.bancoDados.GaleriaDAO;
import app.eureka.EurekaDiscovery;
import app.eureka.EurekaDiscoveryModelo;
import app.modelo.Jogo;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GaleriaService {

    @Autowired
    private GaleriaDAO galeriaDAO;
    ConectorToJogoServer conectorToJogoServer = new ConectorToJogoServer();
    private EurekaDiscovery eurekaDiscovery = new EurekaDiscovery();

    public List<Jogo> mostraGaleria() throws IOException, JSONException {

        List<Integer> galeria = galeriaDAO.retornaGaleria();
        List<Jogo> jogos = new ArrayList<>();

        List<EurekaDiscoveryModelo>  eurekaDiscoveryModelo = eurekaDiscovery.montaLista();

        String url = eurekaDiscoveryModelo.get(0).getIpAddr()+":"+eurekaDiscoveryModelo.get(0).getPort();

        for (int i = 0; i < galeria.size() ; i++) {
            jogos.add(i, (Jogo) conectorToJogoServer.run("http://"+url+"/jogos/"+galeria.get(i)));
        }
        return jogos;
    }





}
