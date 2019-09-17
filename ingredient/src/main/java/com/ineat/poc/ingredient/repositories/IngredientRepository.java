package com.ineat.poc.ingredient.repositories;

import com.ineat.poc.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByBeers_BeerId(Long id);

}
