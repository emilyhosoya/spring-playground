package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WordCounter {
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
        for (String element : array) {
            String word = element.toLowerCase();
            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}
