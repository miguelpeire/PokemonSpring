package es.salesianos.controller;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Entrenador;
import es.salesianos.model.Pokemon;

@Controller
public class IndexController {
	
	private static Logger log = LogManager.getLogger(IndexController.class);
	
	@Autowired
	private Entrenador entrenador;

	private double multiplier;
	private double multiplier2;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}

	
	@PostMapping("insert")
	public ModelAndView entrenadorInsert(Entrenador entrenadorForm) {
		log.debug("entrenadorInsert:" + this.entrenador.toString());
		ModelAndView modelAndView = new ModelAndView("index");
		addPageData(entrenadorForm);
		modelAndView.addObject("entrenador", entrenador);
		return modelAndView;
	}
	
	private void addPageData(Entrenador entrenadorForm) {

		if (!StringUtils.isEmpty(entrenadorForm.getName())) {
			entrenador.setName(entrenadorForm.getName());
		}

		if (!StringUtils.isEmpty(entrenadorForm.getPokemon())) {
			Pokemon item = new Pokemon();
			String races[] = { "Fire", "Water", "Grass"};
			if (entrenadorForm.getPokemon().getType().equalsIgnoreCase("active")) {

				Pokemon attack = new Pokemon();
				attack.setName(entrenadorForm.getPokemon().getName());
				attack.setLevel(entrenadorForm.getPokemon().getLevel());
				attack.setType(entrenadorForm.getPokemon().getType());
				attack.setAttackPower((int) (Math.random() * 5) * (item.getLevel()) + 10);
				attack.setVidaMaxima(entrenadorForm.getPokemon().getLevel() * 5);
				attack.setHP(attack.getVidaMaxima());
				attack.setRace(races[(int) (Math.random() * races.length)]);
				if (entrenador.getPrimary() == null) {
					entrenador.setPrimary(attack);
				} else if (entrenador.getSecondary() == null) {
					entrenador.setSecondary(attack);
				} else {
					entrenador.setPrimary(attack);
				}
			} else if (entrenadorForm.getPokemon().getType().equalsIgnoreCase("pokemon")) {
				item.setName(entrenadorForm.getPokemon().getName());
				item.setLevel(entrenadorForm.getPokemon().getLevel());
				item.setType(entrenadorForm.getPokemon().getType());
				item.setAttackPower((int) (Math.random() * 5) * (item.getLevel()) + 10);
				item.setVidaMaxima(entrenadorForm.getPokemon().getLevel() * 5);
				item.setHP(item.getVidaMaxima());
				item.setRace(races[(int) (Math.random() * races.length)]);
				if(entrenador.getTeam().isFull() != true) {
				this.entrenador.getTeam().addPokemon(item);
				}else {
					System.out.println("Team is full");
				}
					
			}
			this.entrenador.setPokemon(item);
		}
	}

	@PostMapping("switchActive")
	public ModelAndView switchActive(Entrenador entrenadorForm) {

		Pokemon tmp;
		tmp = this.entrenador.getPrimary();
		if (this.entrenador.getTeam().setActivePokemon(entrenadorForm.getAux()).getStatus() == "Alive") {
			this.entrenador.setPrimary(this.entrenador.getTeam().setActivePokemon(entrenadorForm.getAux()));
		} else
			System.out.println("This Pokemon is out of combat");

		this.entrenador.setSecondary(tmp);
		if (this.entrenador.getPrimary().getName() != null) {
			System.out.println("Active pokemon: " + this.entrenador.getPrimary().getName());
		}
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}

	public void insertEnemy(Entrenador entrenadorForm, Pokemon enemy) {
		String enemyPokemons[] = { "Charizard", "Mewto", "Gorka" };
		String races[] = { "Fire", "Water", "Grass"};

		enemy.setName(enemyPokemons[(int) (Math.random() * enemyPokemons.length)]);
		if (enemy.getName() == "Gorka") {
			enemy.setLevel(99);
			enemy.setAttackPower(10000);
			enemy.setVidaMaxima(enemy.getLevel() * 5);
			enemy.setHP(enemy.getVidaMaxima());
			enemy.setStatus("Alive");
			enemy.setType("HARD CODE NOOO");
			enemy.setRace(races[(int) (Math.random() * races.length)]);
		} else {
			enemy.setLevel((int) (Math.random() * 10) + 70);
			enemy.setAttackPower((int) (Math.random() * 5) * (enemy.getLevel()) + 10);
			enemy.setVidaMaxima(enemy.getLevel() * 5);
			enemy.setHP(enemy.getVidaMaxima());
			enemy.setStatus("Alive");
			enemy.setType("pokemon");
			enemy.setRace(races[(int) (Math.random() * races.length)]);
		}
	}
	
	public void insertEnemyForm(Entrenador entrenadorForm, Pokemon enemy) {
			String races[] = { "Fire", "Water", "Grass"};
			enemy.setName(entrenadorForm.getPokemon().getName());
			enemy.setLevel((int) (Math.random() * 10) + 70);
			enemy.setAttackPower(entrenadorForm.getPokemon().getAttackPower());
			enemy.setVidaMaxima(entrenadorForm.getPokemon().getVidaMaxima());
			enemy.setHP(enemy.getVidaMaxima());
			enemy.setStatus("Alive");
			enemy.setType("pokemon");
			enemy.setRace(races[(int) (Math.random() * races.length)]);
	}

	@PostMapping("createEnemy")
	public ModelAndView createEnemy(Entrenador entrenadorForm) {
		Pokemon enemyPokemon = new Pokemon();
		entrenador.setWild(enemyPokemon);
		insertEnemy(entrenadorForm, enemyPokemon);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}
	
	@PostMapping("createEnemyForm")
	public ModelAndView createEnemyForm(Entrenador entrenadorForm) {
		Pokemon enemyPokemon = new Pokemon();
		entrenador.setWild(enemyPokemon);
		insertEnemyForm(entrenadorForm, enemyPokemon);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}

	@PostMapping("deletePokemon")
	public ModelAndView deletePokemon(Entrenador entrenadorForm) {

		this.entrenador.getTeam().removeById(entrenadorForm.getAux2());
		this.entrenador.setPrimary(null);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}

	@PostMapping("combat")
	public ModelAndView combat(Entrenador entrenadorForm) {
//		getCombatRaces();
		multiplier2 = Math.random() * 1;
		System.out.println(multiplier2);
		if (entrenador.getPrimary().getStatus() == "Alive") {
//			entrenador.getWild().setHP((entrenador.getWild().getHP()) - (int) ( entrenador.getPrimary().getAttackPower() * multiplier));
//			entrenador.getPrimary().setHP((entrenador.getPrimary().getHP()) - (int) ( entrenador.getWild().getAttackPower() * (1 / multiplier)));
			entrenador.getWild().setHP((entrenador.getWild().getHP()) - (int) (entrenador.getPrimary().getAttackPower() * multiplier2));
			entrenador.getPrimary().setHP((entrenador.getPrimary().getHP()) - (int) (entrenador.getWild().getAttackPower() * multiplier2));
		} else {
			System.out.println(entrenador.getPrimary().getName() + " out of combat");
		}

		if (entrenador.getPrimary().getHP() <= 0) {
			entrenador.getPrimary().setHP(0);
			entrenador.getPrimary().setStatus("Dead");
		}

		if (entrenador.getWild().getHP() <= 0) {
			entrenador.getWild().setHP(0);
			entrenador.getWild().setStatus("Dead");
			System.out.println("You win");
			createEnemy(entrenadorForm);
		}

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}

	@PostMapping("capture")
	public ModelAndView capture(Entrenador entrenadorForm) {
		Random percentageCapture = new Random();
		float percentage;
		int chance = percentageCapture.nextInt(99)+1;
		percentage = ((entrenador.getWild().getHP() * 100) / entrenador.getWild().getVidaMaxima());
		if(percentage < 25) {
		if(chance <= this.entrenador.getPokeballs().getCapture()) {	
			entrenador.getTeam().addPokemonCaptured(entrenador.getWild());
			System.out.println(percentage);
			System.out.println(chance);
			System.out.println("Pokemon captured!");
		}else {
			System.out.println(percentage);
			System.out.println(chance);
			System.out.println("Capture failed!");
		}
		}else {
			System.out.println(percentage);
			System.out.println("Capture failed, the enemy pokemon has to be below 25% of his health!");
		}

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}
	
	@PostMapping("heal")
	public ModelAndView heal(Entrenador entrenadorForm) {
		if (entrenador.getPrimary().getStatus() == "Alive") {
			if (entrenador.getPrimary().getHP() < entrenador.getPrimary().getVidaMaxima()) {
				if (entrenador.getPrimary().getHP() + 20 > entrenador.getPrimary().getVidaMaxima()) {
					entrenador.getPrimary().setHP(entrenador.getPrimary().getVidaMaxima());
				} else {
					entrenador.getPrimary().setHP(entrenador.getPrimary().getHP() + 20);
				}
			} else {
				System.out.println(entrenador.getPrimary().getName() + "Full health");
			}
		} else
			System.out.println(entrenador.getPrimary().getName() + " Impossible to heal, is dead");

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}
	
	public void getCombatRaces() {
		multiplier = 1;
		if (this.entrenador.getPrimary().getRace() == "Grass") {
			if(this.entrenador.getWild().getRace() == "Water") {
					multiplier = 2;
			}else {
					multiplier = 1;
			}
		}

		if (this.entrenador.getPrimary().getRace() == "Fire") {
		if(this.entrenador.getWild().getRace() == "Grass") {
				multiplier = 2;
		}else {
				multiplier = 1;
		}
		}

		if (this.entrenador.getPrimary().getRace() == "Water") {
		if(this.entrenador.getWild().getRace() == "Fire") {
				multiplier = 2;
		}else {
				multiplier = 1;
		}
		}
	}

}
