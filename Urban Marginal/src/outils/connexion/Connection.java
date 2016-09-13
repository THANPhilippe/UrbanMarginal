package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Connection extends Thread {
	
	private Object leRecepteur;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public void run(){
		boolean inOk = true;
		Object reception;
		while(inOk = true){
			try {
				reception = in.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("Classe Object non trouv�e : "+e);
				System.exit(0);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "l'ordinateur distant s'est d�connect�");
				inOk = false;
				try {
					in.close();
				} catch (IOException e1) {
					System.out.println("erreur lors de la fermeture du canal : "+e1);
				}
			}
		}
	}
	
	public Connection(Socket socket, Object leRecepteur){
		this.leRecepteur = leRecepteur;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("erreur grave lors de la cr�ation du canal de sortie : "+e);
			System.exit(0);
		}
		
		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("erreur grave lors de la cr�ation du canal d'entr�e : "+e);
			System.exit(0);
		}
		
		start();
	}
}
