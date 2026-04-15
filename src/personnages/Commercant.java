package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int nbSous) {
		super(nom, "thé", nbSous);
	}

	public void recevoir(int argent) {
//		deux solutions pour voir parler : public ou protected
		gagnerArgent(argent);
		parler(argent + " sous ! Je te remercie généreux donateur!");
	}

	public int seFaireExtorquer() {
		int sousPerdus = getNbSous();
		perdreArgent(sousPerdus);
		parler("J’ai tout perdu! Le monde est trop injuste...");
		return sousPerdus;
	}
}
