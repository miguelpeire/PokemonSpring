package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Entrenador {
	private String name;
	private Pokemon primary;
	private Pokemon secondary;
	private String peso;
//	private Pokemon pokemones;
	private String type;
	private Pokemon pokemon;
	private Pokemon wild;
	private int aux;
	private int aux2;

	@Autowired
	private Team team;

	@Autowired
	private Pokeballs pokeballs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

//	public Pokemon getPokemones() {
//		return pokemones;
//	}
//
//	public void setPokemones(Pokemon pokemones) {
//		this.pokemones = pokemones;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Pokemon getPrimary() {
		return primary;
	}

	public void setPrimary(Pokemon primary) {
		this.primary = primary;
	}

	public Pokemon getSecondary() {
		return secondary;
	}

	public void setSecondary(Pokemon secondary) {
		this.secondary = secondary;
	}

	public Pokemon getWild() {
		return wild;
	}

	public void setWild(Pokemon wild) {
		this.wild = wild;
	}

	public int getAux() {
		return aux;
	}

	public void setAux(int aux) {
		this.aux = aux;
	}

	public int getAux2() {
		return aux2;
	}

	public void setAux2(int aux2) {
		this.aux2 = aux2;
	}

	public Pokeballs getPokeballs() {
		return pokeballs;
	}

	public void setPokeballs(Pokeballs pokeballs) {
		this.pokeballs = pokeballs;
	}

}
