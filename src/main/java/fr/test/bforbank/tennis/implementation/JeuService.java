package fr.test.bforbank.tennis.implementation;

import fr.test.bforbank.tennis.configuration.JeuConfiguration.JoueurAyantMarque;
import fr.test.bforbank.tennis.configuration.JeuConfiguration.Score;
import fr.test.bforbank.tennis.exception.CustomException;
import fr.test.bforbank.tennis.model.Jeu;
import fr.test.bforbank.tennis.model.Joueur;

public class JeuService {

	public void executionDuScore(String sequence) throws CustomException {

		var jeu = new Jeu(new Joueur(), new Joueur());

		for (char casUnitaire : sequence.toCharArray()) {
			if (this.partieEnCours(jeu)) {
				this.traiterCasUnitaire(casUnitaire, jeu);
			}
		}
	}

	private void traiterCasUnitaire(char casUnitaire, Jeu jeu) throws CustomException {
		this.gererScore(casUnitaire, jeu);
		this.annoncerScore(jeu);
		this.annoncerVictoire(jeu);
	}

	private void gererScore(char casUnitaire, Jeu jeu) throws CustomException {
		switch (JoueurAyantMarque.get(casUnitaire)) {
		case A -> jeu.premierJoueur().incrementScore(jeu.deuxiemeJoueur());
		case B -> jeu.deuxiemeJoueur().incrementScore(jeu.premierJoueur());
		default -> {
			System.out.println("Erreur de type de caractère : " + casUnitaire);
			throw new CustomException("Erreur de type de caractère : " + casUnitaire);
		}
		}
		;
	}

	private boolean partieEnCours(Jeu jeu) {
		return !Score.GAGNE.equals(jeu.premierJoueur().getScore())
				&& !Score.PERDU.equals(jeu.premierJoueur().getScore())
				&& !Score.GAGNE.equals(jeu.deuxiemeJoueur().getScore())
				&& !Score.PERDU.equals(jeu.deuxiemeJoueur().getScore());
	}

	private void annoncerScore(Jeu jeu) {
		System.out.println("Player A : " + //
				jeu.premierJoueur().getScore().getCode() //
				+ " / Player B : " //
				+ jeu.deuxiemeJoueur().getScore().getCode());
	}

	private void annoncerVictoire(Jeu jeu) {
		if (Score.GAGNE.equals(jeu.premierJoueur().getScore())) {
			System.out.println("Player A wins the game");
		}
		if (Score.GAGNE.equals(jeu.deuxiemeJoueur().getScore())) {
			System.out.println("Player B wins the game");
		}
	}

}
