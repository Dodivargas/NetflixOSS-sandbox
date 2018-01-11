package app.eureka;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EurekaDiscovery {

    OkHttpClient client = new OkHttpClient();

    public List<EurekaDiscoveryModelo> montaLista() throws IOException, JSONException {
        Request request = new Request.Builder()
                .url("http://localhost:8080/eureka/v2/apps/JOGO")
                .addHeader("Accept","application/json")
                .build();
        Response responses = null;

        try {
            responses = client.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }
        return converteLista(responses.body().string());
    }
    private List<EurekaDiscoveryModelo> converteLista(String jsonString) throws JSONException {

        EurekaDiscoveryModelo eurekaDiscoveryModelo = new EurekaDiscoveryModelo();

        JSONObject jsonResult1 = new JSONObject(jsonString);
        jsonString = jsonResult1.getString("application");

        JSONObject jsonResult2 = new JSONObject(jsonString);
        jsonString = jsonResult2.getString("instance");

        JSONArray jsonResult3 = new JSONArray(jsonString);
        jsonString = jsonResult3.getString(0);

        JSONObject jsonResult4 = new JSONObject(jsonString);
        jsonString = jsonResult4.getString("port");

        JSONObject jsonResult5 = new JSONObject(jsonString);

        eurekaDiscoveryModelo.setIpAddr(jsonResult4.getString("ipAddr"));
        eurekaDiscoveryModelo.setPort(jsonResult5.getString("$"));

        ArrayList<EurekaDiscoveryModelo> eurekaModelDiscoverys = new ArrayList<>();

        eurekaModelDiscoverys.add(eurekaDiscoveryModelo);
        return eurekaModelDiscoverys;
    }
}
