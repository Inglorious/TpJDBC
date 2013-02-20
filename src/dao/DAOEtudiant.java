package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import connexion.ConnexionUnique;
import entite.Etudiant;

public class DAOEtudiant {

	private static DAOEtudiant instance;
	private static Connection conn;
	private DAOEtudiant() {
		conn = ConnexionUnique.getInstance().getConnection();
	}
	
	public Etudiant insert (Etudiant et) throws SQLException {
		String reqMax = "SELECT MAX(NUM_ET) FROM ETUDIANT";
		Statement stmt = conn.createStatement();
		System.out.println("Exécution de la requête : " + reqMax + "\n");
		ResultSet rset = stmt.executeQuery(reqMax);
		int i = rset.getInt(1);
		++i;
		
		String req = "INSERT INTO ETUDIANT " + 
						"VALUES (?, ?, ?, ?, ?, ?, ?) ";
		java.sql.PreparedStatement ps = conn.prepareStatement(req);
		ps.setObject(1, i);
		ps.setObject(2, et.getNomEt());
		ps.setObject(3, et.getPrenomEt());
		ps.setObject(4, et.getCpEt());
		ps.setObject(5, et.getVilleEt());
		ps.setObject(6, et.getAnnee());
		ps.setObject(7, et.getGroupe());
		
		ps.executeQuery();
		
		Etudiant etudiant = new Etudiant (i);
		etudiant.setNomEt(et.getNomEt());
		etudiant.setPrenomEt(et.getPrenomEt());
		etudiant.setCpEt(et.getCpEt());
		etudiant.setVilleEt(et.getVilleEt());
		etudiant.setAnnee(et.getAnnee());
		etudiant.setGroupe(et.getGroupe());
		
		return etudiant;
		
	}
	
	public boolean delete (Etudiant et) throws SQLException {
		String req = "DELETE FROM ETUDIANT WHERE NUM_ET = ?";
		java.sql.PreparedStatement ps = conn.prepareStatement(req);
		ps.setObject(1, et.getNumEt());
		int i = ps.executeUpdate();
		if (1==i)
			return true;
		return false;
		
	}
	
	public boolean update (Etudiant et) throws SQLException {
		String req = 	"UPDATE ETUDIANT "+
						"SET NOM_ET = ?, PRENOM_ET = ?, CP_ET = ?, VILLE_ET = ?, "+
						"ANNEE = ?, GROUPE = ? "+
						"WHERE NUM_ET = ? ";
		
		java.sql.PreparedStatement ps = conn.prepareStatement(req);
		ps.setObject(7, et.getNumEt());
		ps.setObject(1, et.getNomEt());
		ps.setObject(2, et.getPrenomEt());
		ps.setObject(3, et.getCpEt());
		ps.setObject(4, et.getVilleEt());
		ps.setObject(5, et.getAnnee());
		ps.setObject(6, et.getGroupe());
		
		
		int i = ps.executeUpdate();
		if (1==i)
			return true;
		return false;
		
	}
	
	public Etudiant getById (int numEt) throws SQLException {
		Etudiant etudiant = new Etudiant (numEt);
		String req = "SELECT * FROM ETUDIANT WHERE NUM_ET = ? ";
		java.sql.PreparedStatement ps = conn.prepareStatement(req);
		ps.setObject(1, numEt);
		
		
		return null;
		
	}
	
	public List<Etudiant> findAll () {
		return null;
		
	}

	public List<Etudiant> findByNom (String NomEt) {
		return null;
		
	}
	
	public List<Etudiant> findByGroupe (int Groupe) {
		
		return null;
		
	}
	
	public List<Etudiant> findByAnnee (int Annee) {
		
		return null;
		
	}
	
	public float computeMoyennePonderee (Etudiant et) {
		
		return 0;
		
	}
	
	public int computeNbEtudiant () {
		
		return 0;
		
	}
	
	public static DAOEtudiant getInstance () {
		if (null == instance)
			instance = new DAOEtudiant();
		return instance;
	}
}
