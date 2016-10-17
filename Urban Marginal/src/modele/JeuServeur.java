package modele;
import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;

public class JeuServeur extends Jeu implements Global {
	
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>();
	private Hashtable<Connection, Joueur> lesJoueurs;
	
	public JeuServeur(Controle controle){
		this.controle = controle;
		Label.setNbLabel(0);
	}

	@Override
	public void setConnection(Connection connection) {
		lesJoueurs = new Hashtable<Connection, Joueur>();
		lesJoueurs.put(connection, new Joueur());
		controle.evenementModele(this, "envoi panel mur", connection);
		
	}

	@Override
	public void reception(Connection connection, Object info) {
		String [] infos = ((String)info).split(SEPARE);
		switch(Integer.parseInt(infos[0])){
		case PSEUDO : 
			break;
		}
		
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	
	public void constructionMurs(){
		for(int i=0; i < NBMURS; i++){
			lesMurs.add(new Mur());
			controle.evenementModele(this, "ajout mur", lesMurs.get(i).getLabel().getjLabel());
		}
	}

}
