package app.eureka;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Component
public class EurekaRegistry implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    EurekaRegistryModelo eurekaRegistryModelo;
    @Autowired
    WebApplicationContext webApplicationContext;

    OkHttpClient client = new OkHttpClient();

    public EurekaRegistry() throws IOException {
    }

    public void registra() throws IOException {

        RequestBody body = RequestBody.create(MediaType.parse("application/json"),"" +
                "{\"instance\": {" +
                "   \"hostName\": \""+ eurekaRegistryModelo.getHostName() +"\"," +
                "   \"app\": \""+ eurekaRegistryModelo.getAppName()+"\"," +
                "   \"vipAddress\": \""+ eurekaRegistryModelo.getVipAddress()+"\"," +
                "   \"secureVipAddress\": \""+ eurekaRegistryModelo.getSecureVipAddress()+"\"," +
                "   \"ipAddr\": \""+ achaIP()+"\"," +
                "   \"status\": \""+ eurekaRegistryModelo.getStatus()+"\"," +
                "   \"port\": {\"$\": \""+ getPort() +"\", \"@enabled\": \"true\"}," +
                "   \"healthCheckUrl\": \""+ createHealthUrl()+ "\"," +
                "   \"statusPageUrl\": \""+ createHealthUrl()+ "\"," +
                "   \"homePageUrl\": \""+ createHealthUrl()+ "\"," +
                "   \"dataCenterInfo\": {" +
                "       \"@class\": \""+ eurekaRegistryModelo.getDataCenterInfo()+"\"," +
                "       \"name\": \""+ eurekaRegistryModelo.getDataCenterName()+"\"" +
                " }}}") ;


        Request request2 =
                new
                Request.
                Builder()
                .url("http://localhost:8080/eureka/v2/apps/"+ eurekaRegistryModelo.getAppName()).post(body).build() ;
        client.newCall(request2).execute() ;
    }

    private String createHealthUrl(){
        return "http://"+eurekaRegistryModelo.getIpAddr()+":"+getPort()+"/health";

    }
    private int getPort(){
        return ((AnnotationConfigEmbeddedWebApplicationContext) webApplicationContext).getEmbeddedServletContainer().getPort();
    }

    private String achaIP() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("google.com", 80));
        String ip = String.valueOf(socket.getLocalAddress()).substring(1);
        socket.close();
        return ip;
    }



    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            registra();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}