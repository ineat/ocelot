package com.ineat.poc.gui;

import com.ineat.poc.models.Beer;
import com.ineat.poc.models.Ingredient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class GuiService {

    @Value("${business.url}")
    private String businessUrl;

    @Value("${beers.random.path}")
    private String beersRandomPath;

    @Value("${ingredients.all.path}")
    private String ingredientsAllPath;

    public Beer getRandomBeer() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Beer> response = restTemplate.exchange(businessUrl + beersRandomPath, HttpMethod.GET, null, new ParameterizedTypeReference<Beer>(){});
        return response.getBody();
    }

    public List<Ingredient> geAllIngredients() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Ingredient>> response = restTemplate.exchange(businessUrl + ingredientsAllPath, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>(){});
        return response.getBody();
    }
}
