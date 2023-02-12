package fr.test.bforbank.tennis.implementation;

import org.springframework.stereotype.Service;

import fr.test.bforbank.tennis.configuration.JeuConfiguration.JoueurAyantMarque;
import fr.test.bforbank.tennis.model.Jeu;
import fr.test.bforbank.tennis.model.Joueur;
import lombok.extern.slf4j.Slf4j;

@Service
public class JeuService {

	public void executionDuScore(String args[]) {

		Jeu jeu = new Jeu(new Joueur(), new Joueur());

		for (int i = 0; i < args.length; i++) {
			this.traiterCasUnitaire(args[i], jeu);
		}

	}

	private void traiterCasUnitaire(String point, Jeu jeu) {
		switch (JoueurAyantMarque.get(point)) {
		case A:
			jeu.premierJoueur().incrementScore(jeu.deuxiemeJoueur());
			break;
		case B:
			jeu.deuxiemeJoueur().incrementScore(jeu.premierJoueur());
			break;
		default:
//			log
		}
		;
		System.out.println("Player A : "+jeu.premierJoueur().score.toString()+"Player B : / " //
		+jeu.deuxiemeJoueur().getScore().getCode());
	}

}
