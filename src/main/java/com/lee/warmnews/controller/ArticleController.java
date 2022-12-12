package com.lee.warmnews.controller;

import com.lee.warmnews.entity.Article;
import com.lee.warmnews.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleController {

    private static final String ARTICLE = "article";
    private static final String ALL_ARTICLES = "allArticles";

    private static final String ALL_ARTICLES_FORM = "all-articles";
    private static final String NEW_FORM = "new-form";
    private static final String UPDATE_FORM = "update-form";
    private static final String REDIRECT_SLASH_FORM = "redirect:/";

    private static final String SLASH_TEMPLATE = "/";
    private static final String SLASH_ADD_ARTICLE_TEMPLATE = "/addArticle";
    private static final String SLASH_SAVE_ARTICLE_TEMPLATE = "/saveArticle";
    private static final String SLASH_GET_ARTICLE_TEMPLATE = "/getArticle";
    private static final String SLASH_DELETE_ARTICLE_TEMPLATE = "/deleteArticle";

    private final static String ART_ID_TEMPLATE = "artId";

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(SLASH_TEMPLATE)
    public String viewAllArticles(Model model) {
        List<Article> allArticles = articleService.getAllArticles(); //TODO test
        model.addAttribute(ALL_ARTICLES, allArticles); //TODO MockMVC
        return ALL_ARTICLES_FORM;
    }

    @RequestMapping(SLASH_ADD_ARTICLE_TEMPLATE)
    public String addNewArticle(Model model) {
        Article article = new Article();
        model.addAttribute(ARTICLE, article);
        return NEW_FORM;
    }

    @RequestMapping(SLASH_SAVE_ARTICLE_TEMPLATE)
    public String saveArticle(@ModelAttribute(ARTICLE) @Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return UPDATE_FORM;
        }
        articleService.saveArticle(article);
        return REDIRECT_SLASH_FORM;
    }

    @RequestMapping(SLASH_GET_ARTICLE_TEMPLATE)
    public String getArticleById(@RequestParam(ART_ID_TEMPLATE) Long id, Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute(ARTICLE, article);
        return UPDATE_FORM;
    }

    @RequestMapping(SLASH_DELETE_ARTICLE_TEMPLATE)
    public String deleteArticleById(@RequestParam(ART_ID_TEMPLATE) Long id) {
        articleService.deleteArticleById(id);
        return REDIRECT_SLASH_FORM;
    }
}
