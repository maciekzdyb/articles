package com.example.articles.service;

import com.example.articles.model.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArticlesService {

    private static Logger logger = LoggerFactory.getLogger(ArticlesService.class);

    public List<Article> getArticles(){


        List<Article> articles = new ArrayList<>();
        try {
            articles = readJsonFromUrl("https://api.spaceflightnewsapi.net/v3/articles");

        } catch (IOException e){
            logger.warn("IOException error");
            logger.warn(e.getMessage());
        } catch (JSONException e){
            logger.warn("JSONException error");
            logger.warn(e.getMessage());
        }

        return articles;
    }

    private List<Article> readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            Article[] article = new ObjectMapper().readValue(jsonText, Article[].class);
            return Arrays.asList(article);
        } finally {
            is.close();
        }
    }
    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
