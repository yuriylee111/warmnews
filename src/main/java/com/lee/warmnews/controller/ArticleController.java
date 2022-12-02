package com.lee.warmnews.controller;

import com.lee.warmnews.entity.Article;
import com.lee.warmnews.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/")
    public String viewAllArticles(Model model) {
        List<Article> allArticles = articleService.getAllArticles();
        model.addAttribute("allArticles", allArticles);
        return "all-articles";
    }

    @RequestMapping("/addArticle")
    public String addNewArticle(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        return "new-form";
    }

    @RequestMapping("/saveArticle")
    public String saveArticle(@ModelAttribute("article") Article article) {
        articleService.saveArticle(article);
        return "redirect:/";
    }

    @RequestMapping("/getArticle")
    public String getArticleById(@RequestParam("artId") Long id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "update-form";
    }

    @RequestMapping("/deleteArticle")
    public String deleteArticleById(@RequestParam("artId") Long id) {
        articleService.deleteArticleById(id);
        return "redirect:/";
    }
}
