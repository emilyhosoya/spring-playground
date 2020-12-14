package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import org.json.simple.JSONValue;
import java.io.StringWriter;

@RestController
@RequestMapping("/words")
public class WordCounterController {
    @Autowired
    private MyConfig config;
    private Map<String, Integer> map;

    public WordCounterController(Map map, MyConfig config) {
        this.map = map;
        this.config = config;
    }

    @PostMapping("/count")
    public String countWords(@RequestBody String words) throws IOException {
        WordCounter wordCounter = new WordCounter(config);
        Map<String, Integer> map = wordCounter.count(words);
        StringWriter out = new StringWriter();
        JSONValue.writeJSONString(map, out);
        return out.toString();
    }
}
