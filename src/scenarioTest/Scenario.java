package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import village.IVillage;
import villagegauloisold.DepenseMarchand;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
			IEtal[] marche= new IEtal[10];
			int nbEtal=0;
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix){
				etal.installerVendeur(vendeur, produit, prix);
				marche[nbEtal]=etal;
				nbEtal++;
				return true;
			}
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				DepenseMarchand[] output=new DepenseMarchand[10];
				int nbAchete=0;
				int i=0;
				while(nbAchete!=quantiteSouhaitee && i<quantiteSouhaitee) {
					int nbDispo=marche[i].contientProduit("sanglier", quantiteSouhaitee-nbAchete);
					double depense=marche[i].acheterProduit(nbDispo);
					nbAchete+=nbDispo;
					output[i]=new DepenseMarchand(marche[i].getVendeur(),nbDispo,produit,depense);
					i++;
				}
				return output;
			}
			public String toString() {
				StringBuilder output= new StringBuilder();
				for(int i=0;i<nbEtal;i++) {
					output.append(marche[i].etatEtal()+"\n");
				}
				return output.toString();
			}
		};
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}
