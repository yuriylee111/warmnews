package com.lee.warmnews.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlackListWordsConstraintValidatorTest {

    private final BlackListWordsConstraintValidator validator = new BlackListWordsConstraintValidator();

    @BeforeEach
    void beforeEach() {
        validator.initialize(null);
    }

    @Test
    void isValid_ShouldReturnTrue_WhenTextDoesntContainWordFromBlackList() {
        boolean actual = validator.isValid("hello", null);
        assertTrue(actual);
    }

    @Test
    void isValid_ShouldReturnFalse_WhenTextContainsWordFromBlackList() {
        boolean actual = validator.isValid("ау", null);
        assertFalse(actual);
    }

    @Test
    void isValid_ShouldReturnFalse_WhenTextContainsWordFromBlackListCaseInsensitive() {
        boolean actual = validator.isValid("АУ", null);
        assertFalse(actual);
    }

    @Test
    void isValid_ShouldReturnFalse_WhenTextContainsSubWordFromBlackList() {
        boolean actual = validator.isValid("аут", null);
        assertFalse(actual);
    }
}