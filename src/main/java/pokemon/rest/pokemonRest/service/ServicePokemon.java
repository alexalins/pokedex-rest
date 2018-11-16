package pokemon.rest.pokemonRest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokemon.rest.pokemonRest.dao.DaoPokemon;
import pokemon.rest.pokemonRest.models.Pokemon;

import java.util.List;

@Service
public class ServicePokemon {

    @Autowired
    private DaoPokemon daoPokemon;

    public Pokemon save(Pokemon pokemon){
        return this.daoPokemon.save(pokemon);
    }

    public List<Pokemon> listAll(){
        return this.daoPokemon.findAll();
    }

    public void delete(Long id){
        this.daoPokemon.deleteById(id);
    }

    public Pokemon getById(Long id){
        return this.daoPokemon.getOne(id);
    }
}
