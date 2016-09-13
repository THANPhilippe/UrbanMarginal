
package controleur;

import javax.swing.JFrame;

import outils.connexion.ClientSocket;
import outils.connexion.ServeurSocket;
import vue.EntreeJeu;

public class Controle {
	
	private EntreeJeu frmEntreeJeu;
	
	public void evenementVue(JFrame uneFrame, Object info) {
		if(uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
	}
	
	private void evenementEntreeJeu(Object info) {
		if((String)info == "serveur"){
			ServeurSocket serveursocket = new ServeurSocket(this, 6666);
		}
		else{
			ClientSocket clientsocket;
			(clientsocket = new ClientSocket ((String)info, 6666, this)).isConnexionOk();
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
