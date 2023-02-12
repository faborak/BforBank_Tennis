package fr.test.bforbank.tennis;

import fr.test.bforbank.tennis.exception.CustomException;
import fr.test.bforbank.tennis.implementation.JeuService;

public class Tennis {
	
    public static void main(String[] args) {
    	
    	JeuService jeuService = new JeuService();
    	try {
			jeuService.executionDuScore(String.join("", args));
		} catch (CustomException e) {
			System.out.println("Arrêt du jeu - une exception s'est produite sur la séquence "+args);
		}
    }
}