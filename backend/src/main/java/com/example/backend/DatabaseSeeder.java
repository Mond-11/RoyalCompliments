package com.example.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final ComplimentRepository repository;

    public DatabaseSeeder(ComplimentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            System.out.println("The archives are empty! Seeding ancient wisdom...");

            List<Compliment> initialCompliments = List.of(
                new Compliment("Verily, thou art more pleasant than a warm hearth in winter."),
                new Compliment("Thy wit is sharper than a fresh-forged sword!"),
                new Compliment("I would gladly share my last wheel of cheese with thee."),
                new Compliment("Thou lookest dashing enough to marry into royalty immediately."),
                new Compliment("Hark! Thy presence is more welcome than ale after the harvest."),
                new Compliment("Thy charm could convince a dragon to give up its hoard."),
                new Compliment("Thou hast a spirit wilder than a boar in the forest."),
                new Compliment("Even the court jesters take notes when thou speakest."),
                new Compliment("Thou art the finest creature to ever walk upon cobblestone."),
                new Compliment("Forsooth, thou shinest brighter than a polished shield.")
            );

            repository.saveAll(initialCompliments);

            System.out.println("Seeding complete! 10 Scrolls added.");
        } else {
            System.out.println("Royal library already contains " + repository.count() + " scrolls.");
        }
    }
}