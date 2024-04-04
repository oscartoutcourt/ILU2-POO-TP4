package produit;

import personnages.Gaulois;

public class Sanglier implements Produit {
	private String nom="sanglier";
	private int poids;
	private Gaulois chasseur;
	public String getNom() {
		return nom;
	}
	public void description() {
		System.out.println("sanglier de "+poids+" kg chassé par "+chasseur.getNom());
	}
}
