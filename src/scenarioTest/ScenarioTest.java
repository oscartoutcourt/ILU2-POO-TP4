package scenarioTest;

import personnages.Gaulois;
import produit.IProduit;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		Etal<Poisson> etalPoisson1 = new Etal<>();
		
		IEtal[] marche= {etalSanglier1, etalSanglier2, etalPoisson1};
		
		etalSanglier1.installerVendeur(obelix, sangliersObelix, 8);
		etalSanglier2.installerVendeur(asterix, sangliersAsterix, 10);
		etalPoisson1.installerVendeur(ordralfabetix, poissons, 7);
		
		System.out.println(marche[0].etatEtal());
		System.out.println(marche[1].etatEtal());
		System.out.println(marche[2].etatEtal());
		
		int nbAchete=0;
		int i=0;
		while(nbAchete!=3 && i<3) {
			int nbDispo=marche[i].contientProduit("sanglier", 3-nbAchete);
			double depense=marche[i].acheterProduit(nbDispo);
			nbAchete+=nbDispo;
			System.out.println("A l'etal "+i+" je paye "+depense+" sous");
			i++;
		}
		
		System.out.println("\n"+marche[0].etatEtal());
		System.out.println(marche[1].etatEtal());
		System.out.println(marche[2].etatEtal());
	}
	
}
