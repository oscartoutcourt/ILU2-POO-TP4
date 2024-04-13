package produit;

public class Poisson extends Produit{
	private String date;
	private String nom="poisson";
	public Poisson(String date) {
		this.date=date;
	}
	public String getNom() {
		return nom;
	}
	public String description() {
		return "poisson p�ch�s:"+date;
	}
}
