package pokemon.rest.pokemonRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemon.rest.pokemonRest.models.Pokemon;
import pokemon.rest.pokemonRest.service.ServicePokemon;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class ControllerPokemon {

    @Autowired
    ServicePokemon servicePokemon;

    @PostMapping
    public ResponseEntity savePokemon(@RequestBody Pokemon pokemon){
        if (pokemon == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(this.servicePokemon.save(pokemon));
    }

    @GetMapping
    public  ResponseEntity listAll(){
        List<Pokemon> pokemons = this.servicePokemon.listAll();

        if (pokemons == null || pokemons.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable Long id){

        if (id <= 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Pokemon pokemon = this.servicePokemon.getById(id);

        if (pokemon == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity deletePokemon(@PathVariable Long id){

        if (id <= 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        servicePokemon.delete(id);

        return ResponseEntity.ok(null);
    }

    @PutMapping("{id}")
    public ResponseEntity updatePokemon(@RequestBody Pokemon pokemon, @PathVariable Long id){
        if (id <= 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Pokemon pokemonById = this.servicePokemon.getById(id);
        if (pokemonById == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        pokemonById.setId(pokemon.getId());
        pokemonById.setNome(pokemon.getNome());
        pokemonById.setTipo(pokemon.getTipo());
        pokemonById.setAtaque(pokemon.getAtaque());
        pokemonById.setDefesa(pokemon.getDefesa());

        return ResponseEntity.ok(this.servicePokemon.save(pokemonById));
    }

}
