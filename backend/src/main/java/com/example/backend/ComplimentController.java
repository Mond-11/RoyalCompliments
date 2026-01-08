package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*")
public class ComplimentController {

    @Autowired
    private ComplimentRepository repository;

    @GetMapping("/api/compliment")
    public Compliment getCompliment() {
        List<Compliment> all = repository.findAll();

        if (all.isEmpty()) {
            return new Compliment("The archives are empty!", "System");
        }

        return all.get(new Random().nextInt(all.size()));
    }

    @PostMapping("/api/compliment")
    public Compliment addCompliment(@RequestBody Compliment newQuote) {
        if (newQuote.getAuthor() == null || newQuote.getAuthor().trim().isEmpty()) {
            newQuote.setAuthor("Anonymous");
        }
        return repository.save(newQuote);
    }

    @DeleteMapping("/api/compliment/{id}")
    public void deleteCompliment(@PathVariable String id) {
        repository.deleteById(id);
    }

    @GetMapping("/api/admin/export")
    public ResponseEntity<List<Compliment>> exportQuotes() {

        List<Compliment> allQuotes = repository.findAll();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"backup.json\"")
                .body(allQuotes);
    }
}