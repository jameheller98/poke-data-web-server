package com.ou.pokemondata.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeServiceImpl implements HomeService {

    @Override
    public String getRssPokemon() {
        final String rssPokemonUrl = "https://www.pokemon.com/us/pokemon-news/rss";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(rssPokemonUrl, String.class);
    }
}
