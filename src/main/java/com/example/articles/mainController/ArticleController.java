package com.example.articles.mainController;

import com.example.articles.model.Article;
import com.example.articles.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v3")
public class ArticleController {

    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/articles")
    @ResponseBody
    public List<Article> getArticles(){
        return articlesService.getArticles();
    }
}
