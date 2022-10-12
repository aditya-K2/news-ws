package com.example.newsws;

import com.example.newsws.ApiClient.APIClient;
import com.example.newsws.ApiClient.ApiResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "welcome", value = "/")
public class WelcomeServlet extends HttpServlet {
    private String message;
    public void init() {
        message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        APIClient a  = new APIClient("39c2366fd16f43a4b9b620f3d5492ea6");
        ApiResponse ab = null;
        String CountryName = request.getParameter("country");
        try {
            if ( CountryName == null || CountryName == "" ) {
                CountryName = "in";
            }
            ab = a.GetTopHeadlines(CountryName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Page z = new Page();
        z.Respond(response, ab);
    }
    public void destroy() {
    }
}