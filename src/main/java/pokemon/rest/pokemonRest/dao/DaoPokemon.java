package pokemon.rest.pokemonRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pokemon.rest.pokemonRest.models.Pokemon;

@Repository
public interface DaoPokemon extends JpaRepository<Pokemon, Long> {
}
