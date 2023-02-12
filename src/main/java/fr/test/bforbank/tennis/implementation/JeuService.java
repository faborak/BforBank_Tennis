package fr.test.bforbank.tennis.implementation;

import org.springframework.stereotype.Service;

import fr.test.bforbank.tennis.configuration.JeuConfiguration.JoueurAyantMarque;
import fr.test.bforbank.tennis.exception.CustomException;
import fr.test.bforbank.tennis.model.Jeu;
import fr.test.bforbank.tennis.model.Joueur;

@Service
public class JeuService {

	public void executionDuScore(String sequence) throws CustomException {

		Jeu jeu = new Jeu(new Joueur(), new Joueur());

		for (char casUnitaire : sequence.toCharArray()) {
			this.traiterCasUnitaire(casUnitaire, jeu);
		}
	}

	private void traiterCasUnitaire(char casUnitaire, Jeu jeu) throws CustomException {

		switch (JoueurAyantMarque.get(casUnitaire)) {
		case A:
			jeu.premierJoueur().incrementScore(jeu.deuxiemeJoueur());
			break;
		case B:
			jeu.deuxiemeJoueur().incrementScore(jeu.premierJoueur());
			break;
		default:
			System.out.println("Erreur de type de caractère : " + casUnitaire);
			throw new CustomException("Erreur de type de caractère : " + casUnitaire);
		}
		;
		System.out.println("Player A : " + jeu.premierJoueur().getScore().code.toString() + "Player B : / " //
				+ jeu.deuxiemeJoueur().getScore().code);
	}

}
