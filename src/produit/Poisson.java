package produit;

public class Poisson extends Produit{
	private String date;
	private String nom="poisson";
	public Poisson(String date) {
		this.date=date;
	}
	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public String description() {
		return "poisson p�ch�s:"+date;
	}
	@Override
	public double calculerPrix(double prix) {
		return prix; 
	}
}
