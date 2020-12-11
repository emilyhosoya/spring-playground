package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Optional<Lesson> getOne(@PathVariable Long id) {
        return this.repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Lesson edit(@PathVariable Long id, @RequestBody Lesson lesson) {
        Lesson changeThis = new Lesson();
        changeThis.setId(id);
        changeThis.setTitle(lesson.getTitle());
        changeThis.setDeliveredOn(lesson.getDeliveredOn());
        return this.repository.save(changeThis);
    }

    @GetMapping("/find/{title}")
    public Lesson findByTitle(@PathVariable String title) {
        return this.repository.findByTitle(title);
    }

    @GetMapping("/between")
    public ArrayList<Lesson> findLessonsBetween(@Param("startDate") String date1, @Param("endDate") String date2) {
        System.out.println(this.repository.findByDateRange(date1, date2));
        return this.repository.findByDateRange(date1, date2);
    };
}