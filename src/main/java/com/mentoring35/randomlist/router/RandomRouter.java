package com.mentoring35.randomlist.router;

import com.google.common.collect.Lists;
import com.mentoring35.randomlist.collection.Random;
import com.mentoring35.randomlist.model.RequestDTO;
import com.mentoring35.randomlist.model.RequestParamsDTO;
import com.mentoring35.randomlist.repository.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class RandomRouter {

    @Autowired
    private RandomRepository repository;



    @PostMapping
    public Mono<Random> post(@RequestBody RequestDTO requestDTO){
        return Mono.just(new Random()).map(entity -> {
                    entity.setDate(new Date());
                    entity.setOriginalList(requestDTO.getList());
                    return entity;
                }).map(entity -> {
                    var list = Stream.of(requestDTO.getList().split(","))
                            .map(p -> p.trim())
                            .collect(Collectors.toList());
            Collections.shuffle(list);
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setRandomList(randomList);
            return entity;
                }).flatMap(repository::save);
    }

    @PostMapping("/new")
    public Mono<Random> forNumber(@RequestBody RequestParamsDTO request){
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new Date());
            entity.setOriginalList(IntStream.range(request.getValorInicial(), request.getValorMaximo())
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",")));
            return entity;
        }).map(entity -> {
            var list = Stream.of(entity.getOriginalList().split(","))
                    .collect(Collectors.toList());
            Collections.shuffle(list);
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setRandomList(Lists.partition(list, request.getCantidadColumnas()).toString());
            return entity;
        }).flatMap(repository::save);
    }

    @GetMapping("")
    public Flux<Random> get() {
        return repository.findAll();
    }
}
