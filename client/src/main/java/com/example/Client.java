package com.example;

import okhttp3.*;

public class Client {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, "{\"id\":1, \"obj\":\"example\"}");
        String url = "http://localhost:8888/application/echo";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println("Response from server: " + response.body().string());
    }
}
