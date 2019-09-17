package com.ineat.poc.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BeerIngredient {

   @EmbeddedId
    BeerIngredientKey id;

    @ManyToOne
    @MapsId("beer_id")
    @JoinColumn(name = "beer_id")
    Beer beer;

    @ManyToOne
    @MapsId("ingredient_id")
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

}
