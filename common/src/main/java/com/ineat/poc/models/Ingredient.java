package com.ineat.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    Set<BeerIngredient> beers;
}
