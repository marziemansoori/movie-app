package org.example.moviecatalogservice.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Movie {

    private String id;

    private String name;

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
