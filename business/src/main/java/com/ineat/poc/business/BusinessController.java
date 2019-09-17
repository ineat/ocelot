package com.ineat.poc.business;

import com.ineat.poc.models.Beer;
import com.ineat.poc.models.Ingredient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/")
public class BusinessController {

    @Value("${beers.url}")
    private String beersUrl;

    @Value("${ingredients.url}")
    private String ingredientsUrl;

    @GetMapping(path="beers/random", produces = "application/json")
    public Beer getRandomBeer()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Beer>> response = restTemplate.exchange(beersUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>(){});
        List<Beer> beers = response.getBody();
        Random rand = new Random();
        return beers.get(rand.nextInt(beers.size()));
    }

    @GetMapping(path="ingredients", produces = "application/json")
    public List<Ingredient> getAllIngredient()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Ingredient>> response = restTemplate.exchange(ingredientsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>(){});
        List<Ingredient> ingredients = response.getBody();
        return ingredients;
    }

    @CrossOrigin(origins = "*", allowCredentials = "true")
    @PostMapping(path="beers/{id}/evaluate", produces = "application/json")
    public Boolean getIngredients(@PathVariable(value = "id") Long id, @RequestBody SubmittedRecipe submittedRecipe) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Ingredient>> response = restTemplate.exchange(ingredientsUrl + id, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>(){});
        List<Ingredient> ingredients = response.getBody();

        int diff = ingredients.stream()
                .filter(ingredient -> !submittedRecipe.getIngredientsIds().isEmpty())
                .map(ingredient -> String.valueOf(ingredient.getId()))
                .filter(ingredientId -> submittedRecipe.getIngredientsIds().contains(ingredientId))
                .collect(Collectors.toList()).size();
        return diff == ingredients.size();
    }
}
