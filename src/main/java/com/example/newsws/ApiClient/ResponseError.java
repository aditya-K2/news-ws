package com.example.newsws.ApiClient;

public class ResponseError extends Exception{
    public ResponseError() {
        super("Didn't Receive Response Please check Your Query");
    }
}
