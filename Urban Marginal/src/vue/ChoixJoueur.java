package vue;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Global;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChoixJoueur extends JFrame implements Global{
	
	Cursor normal = new Cursor(Cursor.DEFAULT_CURSOR);
	Cursor doigt = new Cursor(Cursor.HAND_CURSOR);

	private JPanel contentPane;
	private JTextField txtPseudo;
	private int numPerso;
	private JLabel lblPersonnage;
	String test = PERSO+DROITE+MARCHE+"d"+DROITE+ESTIMAGE;
	
	private void lblPrecedent_clic(){
	}
	private void lblSuivant_clic(){
	}
	private void lblGo_clic(){
	}
	private void souris_normale(){
		contentPane.setCursor(normal);
	}
	private void souris_doigt(){
		contentPane.setCursor(doigt);
	}
	private void affichePerso(){
		lblPersonnage.setIcon(new ImageIcon(PERSO+DROITE+MARCHE+"d"+DROITE+ESTIMAGE));
	}

	/**
	 * Create the frame.
	 */
	public ChoixJoueur() {
		setTitle("Choice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblPrecedent_clic() ;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale();
			}
		});
		lblPrecedent.setBounds(64, 144, 41, 46);
		contentPane.add(lblPrecedent);
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale();
			}
		});
		lblSuivant.setBounds(299, 144, 29, 46);
		contentPane.add(lblSuivant);
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				souris_doigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				souris_normale();
			}
		});
		lblGo.setBounds(309, 196, 66, 70);
		contentPane.add(lblGo);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(141, 244, 122, 22);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(141, 115, 122, 116);
		contentPane.add(lblPersonnage);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		lblFond.setIcon(new ImageIcon(FONDCHOIX));
		contentPane.add(lblFond);
		
		txtPseudo.requestFocus();
		numPerso = 1;
		affichePerso();
	}
	
}
