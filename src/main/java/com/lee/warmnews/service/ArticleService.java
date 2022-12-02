package com.lee.warmnews.service;

import com.lee.warmnews.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();

    void saveArticle(Article article);

    Article getArticleById(Long id);

    void deleteArticleById(Long id);
}
