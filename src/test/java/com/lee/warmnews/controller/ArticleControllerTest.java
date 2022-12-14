package com.lee.warmnews.controller;

import com.lee.warmnews.entity.Article;
import com.lee.warmnews.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleControllerTest {

    private static final Long TEST_ID = 123L;

    @Mock
    private ArticleService articleService;

    private ArticleController articleController;

    @BeforeEach
    void beforeEach() {
        articleController = new ArticleController(articleService);
    }

    @Test
    void viewAllArticles(@Mock Model model, @Mock List<Article> articles) {
        // given
        when(articleService.getAllArticles()).thenReturn(articles);

        // when
        String actual = articleController.viewAllArticles(model);

        // then
        assertEquals("all-articles", actual);
        verify(model).addAttribute("allArticles", articles);
    }

    @Test
    void addNewArticle(@Mock Model model) {
        // when
        String actual = articleController.addNewArticle(model);

        // then
        assertEquals("new-form", actual);
        verify(model).addAttribute("article", new Article());
    }

    @Test
    void saveArticleSuccess(@Mock Article article, @Mock BindingResult bindingResult) {
        // when
        String actual = articleController.saveArticle(article, bindingResult);

        //then
        assertEquals("redirect:/", actual);
        verify(articleService).saveArticle(article);
    }

    @Test
    void saveArticleFailed(@Mock Article article, @Mock BindingResult bindingResult) {
        // given
        when(bindingResult.hasErrors()).thenReturn(true);

        // when
        String actual = articleController.saveArticle(article, bindingResult);

        //then
        assertEquals("update-form", actual);
        verify(articleService, never()).saveArticle(any(Article.class));
        verifyNoInteractions(articleService);
    }

    @Test
    void getArticleById(@Mock Model model, @Mock Article article) {
        // given
        when(articleService.getArticleById(TEST_ID)).thenReturn(article);

        // when
        String actual = articleController.getArticleById(TEST_ID, model);

        // then
        assertEquals("update-form", actual);
        verify(model).addAttribute("article", article);
    }

    @Test
    void deleteArticleById() {
        // when
        String actual = articleController.deleteArticleById(TEST_ID);

        // then
        assertEquals("redirect:/", actual);
        verify(articleService).deleteArticleById(TEST_ID);
    }
}