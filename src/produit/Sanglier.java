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
	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public String description() {
		return "sanglier de "+poids+" kg chass� par "+chasseur.getNom();
	}
	@Override
	public double calculerPrix(double prix) {
		return poids/1000.0 * prix; 
	}
}
