package com.ineat.poc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "beer")
public class Beer {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

   @OneToMany(mappedBy = "beer")
   @JsonIgnore
   Set<BeerIngredient> ingredients;
}
