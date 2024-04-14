package produit;

public abstract class Produit implements IProduit {
	private String unite;
	private String nom;
	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public String description() {
		return "";	
	}
	public abstract double calculerPrix(double prix);
}
