package produit;

public interface IProduit {

	String getNom();

	String description();
	
	double calculerPrix(double prix);
}