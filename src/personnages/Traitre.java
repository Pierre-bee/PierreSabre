package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;
	Random amiIndice = new Random();
	
	public Traitre(String nom, String seigneur, String boissonFavorite, int nbSous) {
		super(nom, seigneur, boissonFavorite, nbSous);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau dde  traitrise est " + niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentRanconne = commercant.getNbSous()*2/10;
			commercant.perdreArgent(argentRanconne);
			this.gagnerArgent(argentRanconne);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconne + " sous ou gare à toi !");
			commercant.parler("Tout de suite, grand "+ this.getNom() + ". ");
		}
		else {
			parler("Mince, je ne peux plus ranconner personne sinon un samourai risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami-ami avec personne car je ne connais personne ! Snif.");
		}else {
			int don = getNbSous()/20;
			Humain ami = memoire[amiIndice.nextInt(nbConnaissance)];
			this.parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami-ami avec " + ami.getNom() + ".");
			this.parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			this.perdreArgent(don);
			ami.parler("Merci " + this.getNom() + ", vous êtes quelqu'un de bien.");
			if (niveauTraitrise > 1) {
				niveauTraitrise--;
			}
			
		}
	}
}
