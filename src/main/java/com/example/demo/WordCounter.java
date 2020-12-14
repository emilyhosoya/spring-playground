package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Service
public class WordCounter {
    private MyConfig config;

    public WordCounter(MyConfig config) {
        this.config = config;
    }

    private String words;

    @Bean
    public String getWords() {
        return new String();
    }

    @Bean
    @Primary
    public Map<String, Integer> count(String words) {
        this.words = words;
        String[] array = words.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : array) {
            if (!config.getCaseSensitive()) {
                word = word.toLowerCase();
            }
            // not sure why this isn't working!
            for (String skips : config.getWords().getSkip()) {
                if (!word.equals(skips)) {
                    if (map.containsKey(word)) {
                        int count = map.get(word);
                        map.put(word, count + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
        }
        return map;
    }
}
