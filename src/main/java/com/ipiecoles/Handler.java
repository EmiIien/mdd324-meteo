package com.ipiecoles;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Handler implements RequestHandler<GatewayRequest, GatewayResponse> {
    @Override
    public GatewayResponse handleRequest(GatewayRequest o, Context context) {
        WeatherRequest weatherRequest = new Gson().fromJson(o.getBody(), WeatherRequest.class);
        System.out.println("Ville : " + weatherRequest.getCity());
        WeatherService weatherService = new WeatherService();
        Weather weather = null;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Allow-Origin", "https://pjvilloud.github.io");
        if (weatherRequest == null || weatherRequest.getCity() == null || weatherRequest.getCity().isEmpty()) {
            return new GatewayResponse("{\"error\":\"Pas de ville\"}", headers, 400);
        }
        try {
            weather = weatherService.getWeatherOfTheCity(weatherRequest.getCity());
        } catch (Exception exception) {
            // Gestion d'erreur
            System.out.println(exception.getMessage());
            if (exception.getMessage() == "Mauvaise clé API") {
                return new GatewayResponse("{\"error\":\"Mauvaise clé API\"}", headers, 401);
            }
            return new GatewayResponse("{\"error\":\"Problème lors de la récupération de la météo\"}", headers, 500);
        }
        String body = new Gson().toJson(weather);
        return new GatewayResponse(body, headers, 200);
    }
}
