package com.example.MainMarcet.models;

import com.example.MainMarcet.controlers.BlogController;
import com.example.MainMarcet.repo.PostRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



public class Parser {


    public String urlCoinGeco(String currency, int strPage, int page) {
        String urlAdrees = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=" + currency + "&order=market_cap_desc&per_page=" + strPage + "&page=" + page + "&sparkline=false";
        return urlAdrees;
    }

    public String getUrlContent(String urlAdress) {
        StringBuffer conect = new StringBuffer();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                conect.append(line + "\n");
            }
        } catch (Exception e) {

        }
        return conect.toString();
    }


}
