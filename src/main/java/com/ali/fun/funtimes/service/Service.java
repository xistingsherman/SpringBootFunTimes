package com.ali.fun.funtimes.service;


import com.ali.fun.funtimes.data.repo.Cat;
import com.ali.fun.funtimes.data.repo.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private CatRepository repo;

    public void save(Cat cat){
        repo.save(cat);
    }

    public void delete(Cat cat){
        repo.delete(cat);
    }

    public Flux<Cat> getAllCats(){

        Flux<Cat> hello = repo.findAll();

        hello.filter(cat -> cat.getNeutered()).map(Cat::getName).toStream().toList();
        return repo.findAll();
    }

    public Mono<Cat> getCat(long catId){
        return repo.findById(catId);
    }
}
