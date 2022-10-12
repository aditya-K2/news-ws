package com.example.newsws.ApiClient;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.*;

public class APIClient {
    private String API_KEY;
    private static String URL = "https://newsapi.org/v2/";
    static Gson g = new Gson();

    public APIClient(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    private ApiResponse GetApiResponse(String URIString) throws IOException, InterruptedException, ResponseError {
        try {
            var client = HttpClient.newBuilder().build();
            var request = HttpRequest.newBuilder().uri(URI.create(URIString)).GET().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return g.fromJson(response.body(), ApiResponse.class);
        } catch (IOException e) {
            throw new ResponseError();
        } catch (InterruptedException e) {
            throw new ResponseError();
        }
    }

    public ApiResponse SearchForKeyWordInArticle(String query) throws IOException, InterruptedException, ResponseError {
        query = query.replace(' ', '+');
        try {
            return GetApiResponse(URL + "everything?q=" + query +  "&apiKey=" + API_KEY);
        } catch (ResponseError responseError) {
            responseError.printStackTrace();
            return null;
        }
    }

    public ApiResponse GetTopHeadlines(String Country) throws IOException, InterruptedException {
        try {
            return GetApiResponse(URL + "top-headlines?country=" + Country + "&apiKey=" + API_KEY);
        } catch (ResponseError responseError) {
            responseError.printStackTrace();
            return null;
        }
    }

}

