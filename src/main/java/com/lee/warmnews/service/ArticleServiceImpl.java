package com.lee.warmnews.service;

import com.lee.warmnews.dao.ArticleDao;
import com.lee.warmnews.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    @Transactional
    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    @Override
    @Transactional
    public void saveArticle(Article article) {
        if (article.getId() == null) {
            article.setCreated(new Timestamp(System.currentTimeMillis()));
            articleDao.saveArticle(article);
        } else {
            Article dbArticle = articleDao.getArticleById(article.getId());
            dbArticle.setTitle(article.getTitle());
            dbArticle.setBrief(article.getBrief());
            dbArticle.setContent(article.getContent());
            dbArticle.setUpdated(new Timestamp(System.currentTimeMillis()));
            articleDao.saveArticle(dbArticle);
        }
    }

    @Override
    @Transactional
    public Article getArticleById(Long id) {
        return articleDao.getArticleById(id);
    }

    @Override
    @Transactional
    public void deleteArticleById(Long id) {
        articleDao.deleteArticleById(id);
    }
}
