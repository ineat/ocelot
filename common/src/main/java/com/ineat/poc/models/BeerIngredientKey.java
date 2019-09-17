package com.ineat.poc.models;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class BeerIngredientKey implements Serializable {

    @Column(name = "beer_id")
    Long beerId;

    @Column(name = "ingredient_id")
    Long ingredientId;
}
