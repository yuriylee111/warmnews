package com.lee.warmnews.dao;

import com.lee.warmnews.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ArticleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveOrUpdateArticle(Article article) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(article);
    }

    @Override
    public List<Article> getAllArticles() {
        Session session = sessionFactory.getCurrentSession();
        List<Article> allArticlesList = session.createQuery("from Article", Article.class).getResultList();
        return allArticlesList;
    }

    @Override
    public Article getArticleById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Article article = session.get(Article.class, id);
        return article;
    }

    @Override
    public void deleteArticleById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Article> query = session.createQuery("delete from Article where id =:artId");
        query.setParameter("artId", id);
        query.executeUpdate();
    }


}
