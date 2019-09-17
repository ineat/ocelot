package com.ineat.poc.gui;

import com.ineat.poc.models.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class GuiController {

    @Autowired
    private GuiService guiService;

    @Value("${beers.evaluation.path}")
    private String evaluationPath;

    private final String apiUrl = "http://localhost:8080";

    @GetMapping("/")
    public String showBeerForm(Model model) {
        Beer randomBeer = guiService.getRandomBeer();
        model.addAttribute("beer", randomBeer);
        model.addAttribute("evaluationUrl",  apiUrl + evaluationPath.replace("{id}", String.valueOf(randomBeer.getId())));
        model.addAttribute("ingredientsListing", guiService.geAllIngredients());
        return "beer-form";
    }
}
