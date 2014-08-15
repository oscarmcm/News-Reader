package service;

import service.Database;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Request {
    public void Processing() throws IOException, ParseException, Exception {
        String url = "http://api.ihackernews.com/page";
        Database db = new Database();
        int i=0;

        HttpClient httpClient = new DefaultHttpClient();
        JSONParser parser = new JSONParser();

        try {

            HttpGet httpGetRequest = new HttpGet(url);
            httpGetRequest.addHeader("Accept", "application/json");
            HttpResponse httpResponse = httpClient.execute(httpGetRequest);

            System.out.println("----------------------------------------");
            System.out.println("Estado de la peticion: " + httpResponse.getStatusLine());
            System.out.println("----------------------------------------");
            
            HttpEntity entity = httpResponse.getEntity();
            String newsJson = IOUtils.toString(new URL(url));
            System.out.println("Servidor RMI Listo Y Corriendo - Esperando Clientes");
        } catch (Exception e) {
            System.out.println("[System] no se puede hacer la peticion " + e);
        }

        while (i < 5) {
            String newsJson = IOUtils.toString(new URL(url));
            JSONObject newsJsonObject = (JSONObject) JSONValue.parseWithException(newsJson);
            JSONArray title = (JSONArray) newsJsonObject.get("items");
        
        JSONObject noticia = (JSONObject) title.get(i++);

        int id = 0;
        String titulo = (String) noticia.get("title");
        String urln = (String) noticia.get("url");
        String autor = (String) noticia.get("postedBy");
        db.Insert(id, titulo, urln, autor);
        }
    }
}
