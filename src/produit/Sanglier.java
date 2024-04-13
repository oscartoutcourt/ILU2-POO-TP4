package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private String nom="sanglier";
	private int poids;
	private Gaulois chasseur;
	public Sanglier(int poids, Gaulois chasseur) {
		this.poids=poids;
		this.chasseur=chasseur;
	}
	public String getNom() {
		return nom;
	}
	public String description() {
		return "sanglier de "+poids+" kg chass� par "+chasseur.getNom();
	}
}
