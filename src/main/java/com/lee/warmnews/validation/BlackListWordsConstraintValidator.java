package com.lee.warmnews.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class BlackListWordsConstraintValidator implements ConstraintValidator<BlackListWords, String> {

    private List<String> blackListWords;

    @Override
    public void initialize(BlackListWords constraintAnnotation) {
        ClassLoader classLoader = BlackListWordsConstraintValidator.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("blackList.txt")) {
            if (is == null) {
                throw new IllegalStateException("classpath blackList.txt resource not found!");
            }
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader reader = new BufferedReader(isr)) {
                blackListWords = reader.lines().map(String::toLowerCase).collect(Collectors.toList());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String textLowerCase = s.toLowerCase();
        for (String blackListWord : blackListWords) {
            if (textLowerCase.contains(blackListWord)) {
                return false;
            }
        }
        return true;
    }
}
