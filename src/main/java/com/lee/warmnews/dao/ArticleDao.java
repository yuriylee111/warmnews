package com.lee.warmnews.dao;

import com.lee.warmnews.entity.Article;

import java.util.List;

public interface ArticleDao {

    List<Article> getAllArticles();

    void saveOrUpdateArticle(Article article);

    Article getArticleById(Long id);

    void deleteArticleById(Long id);

}
