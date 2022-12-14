package com.lee.warmnews.dao;

import com.lee.warmnews.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleDaoImplTest {

    private static final String FROM_ARTICLE_ORDER_BY_CREATED = "FROM Article a ORDER BY a.created DESC";
    private static final String DELETE_FROM_ARTICLE_BY_ID = "DELETE FROM Article WHERE id =:artId";
    private static final String ART_ID_TEMPLATE = "artId";
    private static final Long TEST_ID = 123L;

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @InjectMocks
    private ArticleDaoImpl articleDao;

    @Test
    void saveOrUpdateArticle(@Mock Article article) {
        // given
        doReturn(session).when(sessionFactory).getCurrentSession();

        // when
        articleDao.saveOrUpdateArticle(article);

        // then
        verify(session).saveOrUpdate(article);
    }

    @Test
    void getAllArticles(@Mock List<Article> expected, @Mock Query query) {
        // given
        doReturn(session).when(sessionFactory).getCurrentSession();
        when(session.createQuery(FROM_ARTICLE_ORDER_BY_CREATED, Article.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(expected);

        // when
        List<Article> actual = articleDao.getAllArticles();

        // then
        assertEquals(expected, actual);
    }

    @Test
    void getArticleById(@Mock Article expected) {
        // given
        doReturn(session).when(sessionFactory).getCurrentSession();
        when(session.get(Article.class, TEST_ID)).thenReturn(expected);

        // when
        Article actual = articleDao.getArticleById(TEST_ID);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void deleteArticleById(@Mock Query query) {
        // given
        doReturn(session).when(sessionFactory).getCurrentSession();
        when(session.createQuery(DELETE_FROM_ARTICLE_BY_ID, Article.class)).thenReturn(query);

        // when
        articleDao.deleteArticleById(TEST_ID);

        // then
        verify(query).setParameter(ART_ID_TEMPLATE, TEST_ID);
        verify(query).executeUpdate();
    }
}