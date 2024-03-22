package org.example.moviecatalogservice.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserRating {

    private List<Rating> userRating;

}
