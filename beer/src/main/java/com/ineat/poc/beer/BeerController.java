package com.ineat.poc.beer;

import com.ineat.poc.beer.repositories.BeerRepository;
import com.ineat.poc.models.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/beers")
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @GetMapping(path="", produces = "application/json")
    public List<Beer> getBeers()
    {
        return beerRepository.findAll();
    }
}
