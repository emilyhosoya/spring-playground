package com.example.demo;

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

    private Map<String, Integer> map;

    public WordCounterController(Map map) {
        this.map = map;
    }

    @PostMapping("/count")
    public String countWords(@RequestBody String words) throws IOException {
        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> map = wordCounter.count(words);
        StringWriter out = new StringWriter();
        JSONValue.writeJSONString(map, out);
        return out.toString();
    }
}
