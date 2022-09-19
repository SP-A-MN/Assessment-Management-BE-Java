package com.spamn.trainerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spamn.trainerapi.models.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

}
