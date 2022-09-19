package com.spamn.trainerapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spamn.trainerapi.models.Trainer;
import com.spamn.trainerapi.repository.TrainerRepository;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private TrainerRepository trainerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer createTrainer(@RequestBody Trainer newTrainer) {
        return trainerRepository.save(newTrainer);
    }

    @GetMapping
    public List<Trainer> getTrainers() {
        return trainerRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Trainer getTrainer(@PathVariable String id) {
        int trainer_id = Integer.parseInt(id);
        Optional<Trainer> trainerFromDb = trainerRepository.findById(trainer_id);
        if (trainerFromDb.isPresent()) {
            return trainerFromDb.get();
        } else {
            return new Trainer(0, "trainerDoesntexist@nonExistent.com", "Fred");
        }
    }
}
