package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("word-count")
public class MyConfig {
    private boolean caseSensitive;
    private Words words;

    public static class Words {
        private List<String> skip;

        public List<String> getSkip() {
            return skip;
        }

        public void setSkip(List<String> skip) {
            this.skip = skip;
        }
    }

    public Boolean getCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public Words getWords() {
        return words;
    }

    public void setWords(Words words) {
        this.words = words;
    }

}