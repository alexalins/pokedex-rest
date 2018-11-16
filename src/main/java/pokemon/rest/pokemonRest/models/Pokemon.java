package pokemon.rest.pokemonRest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pokemon implements Serializable {

    @Id
    private Long id;
    @Column(length = 20)
    private String nome;
    @Column(length = 20)
    private String tipo;
    private int ataque;
    private int defesa;

    public Pokemon() {
    }

    public Pokemon(Long id, String nome, String tipo, int ataque, int defesa) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id &&
                ataque == pokemon.ataque &&
                defesa == pokemon.defesa &&
                Objects.equals(nome, pokemon.nome) &&
                Objects.equals(tipo, pokemon.tipo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, tipo, ataque, defesa);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", ataque=" + ataque +
                ", defesa=" + defesa +
                '}';
    }
}
