
package controleur;

import javax.swing.JFrame;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.ServeurSocket;
import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;

public class Controle implements Global{
	
	private EntreeJeu frmEntreeJeu;
	private Jeu leJeu;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	
	public void evenementVue(JFrame uneFrame, Object info) {
		if(uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
	}
	
	private void evenementEntreeJeu(Object info) {
		if((String)info == "serveur"){
			ServeurSocket serveursocket = new ServeurSocket(this, PORT);
			leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			frmArene = new Arene();
			frmArene.setVisible(true);
		}
		else{
			ClientSocket clientsocket;
			(clientsocket = new ClientSocket ((String)info, PORT, this)).isConnexionOk();
			leJeu = new JeuClient(this);
			frmArene = new Arene();
			frmChoixJoueur = new ChoixJoueur();
			frmChoixJoueur.setSize(416, 313);
			frmChoixJoueur.setVisible(true);
			frmEntreeJeu.dispose();
		}
	}

	public Controle () {
		this.frmEntreeJeu = new EntreeJeu(this);
		frmEntreeJeu.setVisible(true);
	}

	public static void main(String[] args) {
		
		new Controle();
		
	}

}
