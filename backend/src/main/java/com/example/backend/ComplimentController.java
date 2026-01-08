package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
public class ComplimentController {

    @Autowired
    private ComplimentRepository repository;

    @GetMapping("/api/compliment")
    public String getCompliment() {
    List<Compliment> all = repository.findAll();

        if (all.isEmpty()) {
        return "The scrolls are empty! Add a compliment below.";
        }

        return all.get(new Random().nextInt(all.size())).getText();
    }

    @PostMapping("/api/compliment")
    public Compliment addCompliment(@RequestBody String text) {
        String cleanText = text.replaceAll("^\"|\"$", "");
        return repository.save(new Compliment(cleanText));
    }
}