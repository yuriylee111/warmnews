package com.lee.warmnews.service;

import com.lee.warmnews.dao.ArticleDao;
import com.lee.warmnews.entity.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceImplTest {

    private static final Long TEST_ID = 123L;
    private static final String TEST_TITLE = "Test Title";
    private static final String TEST_BRIEF = "Test Brief";
    private static final String TEST_CONTENT = "Test content";

    @Mock
    private ArticleDao articleDao;

    @InjectMocks
    private ArticleServiceImpl articleService;

    @Test
    void getAllArticles(@Mock List<Article> expected) {
        // given
        when(articleDao.getAllArticles()).thenReturn(expected);

        // when
        List<Article> actual = articleService.getAllArticles();

        // then
        assertSame(expected, actual);
    }

    @Test
    void saveArticleNew(@Mock Article article) {
        // given
        when(article.getId()).thenReturn(null);

        // when
        articleService.saveArticle(article);

        // then
        verify(articleDao).saveOrUpdateArticle(article);
        verify(article).setCreated(any(Timestamp.class));
    }

    @Test
    void saveArticleUpdate(@Mock Article article, @Mock Article dbArticle) {
        // given
        when(article.getId()).thenReturn(TEST_ID);
        when(articleDao.getArticleById(TEST_ID)).thenReturn(dbArticle);
        when(article.getTitle()).thenReturn(TEST_TITLE);
        when(article.getBrief()).thenReturn(TEST_BRIEF);
        when(article.getContent()).thenReturn(TEST_CONTENT);

        // when
        articleService.saveArticle(article);

        // then
        verify(articleDao).saveOrUpdateArticle(dbArticle);
        verify(dbArticle, never()).setCreated(any(Timestamp.class));
        verify(dbArticle).setUpdated(any(Timestamp.class));
        verify(dbArticle).setTitle(TEST_TITLE);
        verify(dbArticle).setBrief(TEST_BRIEF);
        verify(dbArticle).setContent(TEST_CONTENT);
    }

    @Test
    void getArticleById(@Mock Article expected) {
        // given
        when(articleDao.getArticleById(TEST_ID)).thenReturn(expected);

        // when
        Article actual = articleService.getArticleById(TEST_ID);

        // then
        assertSame(expected, actual);
    }

    @Test
    void deleteArticleById() {
        // when
        articleService.deleteArticleById(TEST_ID);

        // then
        verify(articleDao).deleteArticleById(TEST_ID);
    }
}