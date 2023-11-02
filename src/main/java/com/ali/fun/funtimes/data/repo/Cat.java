package com.ali.fun.funtimes.data.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cats")
public class Cat {
    @Id
    private Long id;
    private String name;
    private Float weight;
    private Integer age;
    private Boolean isNeutered;
    private Boolean isAdoptable;

    public Cat() {
    }

    public Cat(Long id, String name, Float weight, Integer age, Boolean isNeutered, Boolean isAdoptable) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.isNeutered = isNeutered;
        this.isAdoptable = isAdoptable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getNeutered() {
        return isNeutered;
    }

    public void setNeutered(Boolean neutered) {
        isNeutered = neutered;
    }

    public Boolean getAdoptable() {
        return isAdoptable;
    }

    public void setAdoptable(Boolean adoptable) {
        isAdoptable = adoptable;
    }
}
