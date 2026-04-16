package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boissonFavorite, int nbSous, String nomDeClan) {
		super(nom, boissonFavorite, nbSous);
		clan = nomDeClan;
	}
	
	private int attaquerCommercant(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		return  victime.seFaireExtorquer();
	}
	
	public void extorquer(Commercant victime) {
		int sousRecuperes = attaquerCommercant(victime);
		reputation += 1;
		gagnerArgent(sousRecuperes);
		parler("J’ai piqué les " + sousRecuperes + " sous de Marco, ce qui me fait " + getNbSous() + " sous dans ma poche. Hi ! Hi !");
	}
}
