
package controleur;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;
import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;

public class Controle implements Global{
	
	private EntreeJeu frmEntreeJeu;
	private Jeu leJeu;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private Connection connection;
	
	public void evenementModele(Object unJeu, String ordre, Object info ){
		if(unJeu instanceof JeuServeur){
			evenementJeuServeur(ordre, info);
		}
		if(unJeu instanceof JeuClient){
			evenementJeuClient(ordre,info);
		}
	}
	
	private void evenementJeuClient(String ordre, Object info) {
		if(ordre == "ajout panel murs"){
			this.frmArene.ajoutPanelMurs((JPanel)info);
		}
		
	}

	private void evenementJeuServeur(String ordre, Object info) {
		// TODO Auto-generated method stub
		if(ordre == "ajout mur"){
			frmArene.ajoutMur((JLabel)info);
		}
		if(ordre == "envoi panel mur"){
			((JeuServeur)this.leJeu).envoi((Connection)info, this.frmArene.getJpnMurs() );
		}
		
	}

	public void setConnection(Connection connection){
		this.connection = connection;
		if(leJeu instanceof JeuServeur){
			leJeu.setConnection(connection);
		}
	}
	
	public void evenementVue(JFrame uneFrame, Object info) {
		if(uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
		if(uneFrame instanceof ChoixJoueur){
			evenementChoixJoueur(info);
		}
	}
	
	private void evenementChoixJoueur(Object info) {
		((JeuClient)this.leJeu).envoi(info);
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);
	}

	private void evenementEntreeJeu(Object info) {
		if((String)info == "serveur"){
			ServeurSocket serveursocket = new ServeurSocket(this, PORT);
			leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			frmArene = new Arene();
			((JeuServeur)this.leJeu).constructionMurs();
			frmArene.setVisible(true);
		}
		else{
			ClientSocket clientsocket;
			(clientsocket = new ClientSocket ((String)info, PORT, this)).isConnexionOk();
			leJeu = new JeuClient(this);
			leJeu.setConnection(connection);
			frmArene = new Arene();
			frmChoixJoueur = new ChoixJoueur(this);
			frmChoixJoueur.setSize(416, 313);
			frmChoixJoueur.setVisible(true);
			frmEntreeJeu.dispose();
		}
	}
	
	public void receptionInfo(Connection connection, Object info){
		leJeu.reception(connection, info);
	}

	public Controle () {
		this.frmEntreeJeu = new EntreeJeu(this);
		frmEntreeJeu.setVisible(true);
	}

	public static void main(String[] args) {
		
		new Controle();
		
	}

}
