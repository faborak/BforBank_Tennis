package fr.test.bforbank.tennis.model;

import org.springframework.stereotype.Component;

@Component
public record Jeu(Joueur premierJoueur, Joueur deuxiemeJoueur) {

}
