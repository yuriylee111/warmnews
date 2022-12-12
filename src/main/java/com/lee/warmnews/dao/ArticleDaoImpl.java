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

    private final static String FROM_ARTICLE_ORDER_BY_CREATED = "FROM Article a ORDER BY a.created DESC";
    private final static String DELETE_FROM_ARTICLE_BY_ID = "DELETE FROM Article WHERE id =:artId";
    private final static String ART_ID_TEMPLATE = "artId";

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
        return session.createQuery(FROM_ARTICLE_ORDER_BY_CREATED, Article.class).getResultList();
    }

    @Override
    public Article getArticleById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Article.class, id);
    }

    @Override
    public void deleteArticleById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Article> query = session.createQuery(DELETE_FROM_ARTICLE_BY_ID, Article.class);
        query.setParameter(ART_ID_TEMPLATE, id);
        query.executeUpdate();
    }

}
