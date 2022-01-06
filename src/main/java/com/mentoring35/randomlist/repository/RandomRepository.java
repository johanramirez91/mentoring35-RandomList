package com.mentoring35.randomlist.repository;


import com.mentoring35.randomlist.collection.Random;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RandomRepository extends ReactiveCrudRepository<Random, String> {

}
