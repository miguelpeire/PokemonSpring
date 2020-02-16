package es.salesianos.controller;

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
			if (entrenadorForm.getPokemon().getType().equalsIgnoreCase("active")) {

				Pokemon attack = new Pokemon();
				attack.setName(entrenadorForm.getPokemon().getName());
				attack.setLevel(entrenadorForm.getPokemon().getLevel());
				attack.setType(entrenadorForm.getPokemon().getType());
				attack.setAttackPower((int) (Math.random() * (10 + (entrenadorForm.getPokemon().getLevel()) / 2))
						+ ((entrenadorForm.getPokemon().getLevel()) / 2) + 1);
				attack.setVidaMaxima(entrenadorForm.getPokemon().getLevel() * 4);
				attack.setHP(attack.getVidaMaxima());
				if (entrenador.getPrimary() == null) {
					entrenador.setPrimary(attack);
				} else if (entrenador.getSecondary() == null) {
					entrenador.setSecondary(attack);
				} else {
					entrenador.setPrimary(attack);
				}

//			} else if (entrenadorForm.getPokemon().getType().equalsIgnoreCase("pokemon")) {
//
//				List<Pokemon> items = entrenador.getPrimary().getPokemons();
//				items.add(item);
//				entrenador.getPrimary().setPokemons(items);
//				System.out.println("accesorios:" + items);

			} else if (entrenadorForm.getPokemon().getType().equalsIgnoreCase("pokemon")) {
				item.setName(entrenadorForm.getPokemon().getName());
				item.setLevel(entrenadorForm.getPokemon().getLevel());
				item.setType(entrenadorForm.getPokemon().getType());
				item.setAttackPower((int) (Math.random() * (10 + (entrenadorForm.getPokemon().getLevel()) / 2))
						+ ((entrenadorForm.getPokemon().getLevel()) / 2) + 1);
				item.setVidaMaxima(entrenadorForm.getPokemon().getLevel() * 4);
				item.setHP(item.getVidaMaxima());
				this.entrenador.getTeam().addPokemon(item);
			}
			this.entrenador.setPokemon(item);
		}
	}

	@PostMapping("switchActive")
	public ModelAndView switchActive() {

		Pokemon tmp;
		tmp = this.entrenador.getPrimary();
		this.entrenador.setPrimary(this.entrenador.getSecondary());
		this.entrenador.setSecondary(tmp);
		if (this.entrenador.getPrimary().getName() != null) {
			System.out.println("Active pokemon: " + this.entrenador.getPrimary().getName());
		}
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("entrenador", this.entrenador);
		return modelAndView;
	}

	public void insertEnemy(Entrenador entrenadorForm, Pokemon enemy) {
		enemy.setName("Charizard");
		enemy.setLevel((int) (Math.random() * 10) + 70);
		enemy.setAttackPower((int) (Math.random() * 30) * (enemy.getLevel()) + 10);
		enemy.setVidaMaxima(enemy.getLevel() * 5);
		enemy.setHP(enemy.getVidaMaxima());
		enemy.setStatus("Alive");
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

}
