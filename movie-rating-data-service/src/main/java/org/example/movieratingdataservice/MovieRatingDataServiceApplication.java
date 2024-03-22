package org.example.movieratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieRatingDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRatingDataServiceApplication.class, args);
    }

}
