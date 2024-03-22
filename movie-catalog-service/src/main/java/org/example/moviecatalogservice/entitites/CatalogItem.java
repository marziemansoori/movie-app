package org.example.moviecatalogservice.entitites;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogItem {
    private String name;

    private String description;

    private int rating;

}
