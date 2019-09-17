package com.ineat.poc.ingredient;

import com.ineat.poc.ingredient.repositories.IngredientRepository;
import com.ineat.poc.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping(path="", produces = "application/json")
    public List<Ingredient> getIngredients()
    {
        return ingredientRepository.findAll();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public List<Ingredient> getIngredient(@PathVariable Long id)
    {
        return ingredientRepository.findByBeers_BeerId(id);
    }

    /*@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addBeer(@RequestBody Beer beer)
    {
        Integer id = beerDao.getAllEmployees().getEmployeeList().size() + 1;
        beer.setId(id);

        beerDao.addEmployee(beer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }*/
}
