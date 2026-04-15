//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
package histoire;

import personnages.Commercant;
import personnages.Humain;

public class HistoireT4 {

	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
		System.out.println("");
		
		Commercant marco = new Commercant("Marco", 20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
	}

}
