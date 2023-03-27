package com.guilherme;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ApiConsumer {
    private String url;
    private JsonParser jsonParser;

    public ApiConsumer(String url, JsonParser jsonParser) {
        this.url = url;
        this.jsonParser = jsonParser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String getResponse() throws IOException, InterruptedException {
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public List<Map<String, String>> getResponseAsList() throws IOException, InterruptedException {
        return jsonParser.parse(getResponse());
    }
}
