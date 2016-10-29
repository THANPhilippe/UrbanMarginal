package controleur;

public interface Global {
	public static final int PORT = 6666;
	
	public static final String SEPARATOR = "//";
	public static final String CHEMIN = "media" + SEPARATOR;
	public static final String CHEMINFONDS = CHEMIN + "fonds" + SEPARATOR;
	public static final String FONDCHOIX = CHEMINFONDS + "fondchoix.jpg";
	
	public static final int GAUCHE = 0;
	public static final int DROITE = 1;
	public static final int HAUT = 2;
	public static final int BAS = 3;
	public static final int TIRE = 4;
	public static final int DEFENSE = 5;
	public static final int ACTION = 2;
	public static final int L_BOULE = 30;
	public static final int H_BOULE = 30;
	public static final int NBETATSMARCHE = 4;
	public static final int NBETATSBLESSE = 2;
	public static final int NBETATSMORT = 2;
	public static final int LEPAS = 10;
	public static final String CHEMINPERSOS = CHEMIN + "personnages" + SEPARATOR;
	public static final String PERSO = CHEMINPERSOS + "perso";
	public static final String ESTIMAGE = ".gif";
	public static final String MARCHE = "marche";
	public static final String BLESSE = "touche";
	public static final String MORT = "mort";
	public static final String DEFENSE_IMG = "defense";
	public static final int NBPERSOS = 3;
	public static final int H_PERSO = 77;
	public static final int L_PERSO = 70;
	
	public static final String SEPARE = "~"; // caract�re de s�paration (volontairement rare) 
	public static final int PSEUDO = 0; // le message contiendra le pseudo et num�ro du    // personnage
	
	public static final int H_ARENE = 652 ;
	public static final int L_ARENE = 1200 ;
	public static final int H_CHAT = 200 ;
	public static final int H_SAISIE = 25 ;
	public static final int MARGE = 5; // elle va servir pour les �carts entre diff�rents objets 
	public static final String FONDARENE = CHEMINFONDS+"fondarene.jpg";
	public static final int NBMURS = 20;
	public static final String CHEMINMURS = CHEMIN + "murs" + SEPARATOR;
	public static final String MUR = CHEMINMURS + "mur.gif"; // image du mur 
	
	public static final String CHEMINCONSO = CHEMIN + "consommables" + SEPARATOR;
	public static final String CONSOVIE = CHEMINCONSO + "vie.png"; // image du mur 
	public static final String CONSOBLO = CHEMINCONSO + "bloquer.png"; // image du mur 
	public static final int NBCONSO = 1;
	
	public static final int H_MUR = 35; // hauteur de l'image 
	public static final int L_MUR = 34; // largeur de l'image 
	public static final int H_MESSAGE = 8;
	public static final int CHAT = 1;
	public static final String CHEMINBOULES =  CHEMIN+"boules"+SEPARATOR ;
	public static final String BOULE = CHEMINBOULES+"boule.gif" ;
}
