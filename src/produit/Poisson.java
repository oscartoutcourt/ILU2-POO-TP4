package produit;

public class Poisson implements Produit{
	private String date;
	private String nom;
	public String getNom() {
		return nom;
	}
	public void description() {
		System.out.println("poisson pêchés:"+date);
	}
}
