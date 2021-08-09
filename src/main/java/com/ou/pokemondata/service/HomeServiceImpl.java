package com.ou.pokemondata.service;

import com.ou.pokemondata.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    public String getRssPokemon() {
        final String rssPokemonUrl = "https://www.pokemon.com/us/pokemon-news/rss";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(rssPokemonUrl, String.class);
    }
}
