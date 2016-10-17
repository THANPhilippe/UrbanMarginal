package modele;

import javax.swing.JPanel;

import controleur.Controle;
import outils.connexion.Connection;

public class JeuClient extends Jeu {
	
	private Connection connection;
	
	public JeuClient(Controle controle){
		this.controle = controle;
	}
	
	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
	}

	@Override
	public void reception(Connection connection, Object info) {
		if(info instanceof JPanel){
			controle.evenementModele(this, "ajout panel murs", info);
		}
		
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	
	public void envoi(Object info){
		super.envoi(connection, info);
	}

}
