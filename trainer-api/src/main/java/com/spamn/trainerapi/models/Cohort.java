package com.spamn.trainerapi.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cohort {
    @ManyToMany(mappedBy = "cohorts")
    private List<Trainer> trainers;
    @ManyToMany(mappedBy = "cohorts")
    private List<Associate> associates;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Cohort() {
        super();
    }

    public Cohort(List<Trainer> trainers, List<Associate> associates, int id) {
        this.trainers = trainers;
        this.associates = associates;
        this.id = id;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Associate> getAssociates() {
        return associates;
    }

    public void setAssociates(List<Associate> associates) {
        this.associates = associates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
