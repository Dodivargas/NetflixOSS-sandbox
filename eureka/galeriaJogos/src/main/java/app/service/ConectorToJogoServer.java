package app.service;


import app.modelo.Jogo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ConectorToJogoServer {

    OkHttpClient client = new OkHttpClient();

    Object run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String jsonString = response.body().string();

            Gson gson = new GsonBuilder().create();


            return gson.fromJson(jsonString,Jogo.class);
        }

    }

}