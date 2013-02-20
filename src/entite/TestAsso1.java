package entite;
// Importer les classes jdbc
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.ConnexionUnique;

import oracle.jdbc.pool.OracleDataSource;

public class TestAsso1 {

	// Chaine de connexion
	static final String connect_string = "jdbc:mysql://localhost:3306/maBD";
	static final String login = "root";
	static final String psw = "mysql";
	
	
	
	// La requête de test
	static final String req = "SELECT " +
							  "NUM_PROF, NOM_PROF, PRENOM_PROF, ADR_PROF, CP_PROF, VILLE_PROF, "+ 
							  "CODE, LIBELLE, H_COURS_PREV, H_COURS_REA, H_TP_PREV, H_TP_REA, DISCIPLINE, COEFF_TEST, COEFF_CC " +
							  "FROM PROF, MODULE " + "WHERE MODULE.RESP = PROF.NUM_PROF";

	public static void main(String[] args) throws SQLException {
		// Objet materialisant la connexion à la base de données
		Connection conn = null;

		try {
			// Création et paramétrage d'une instance OracleDataSource
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(connect_string);

			// Connexion à la base
			System.out.println("Connexion à " + connect_string + "\n");
			//conn = DriverManager.getConnection(connect_string, login, psw);
			conn = ConnexionUnique.getInstance().getConnection();
			System.out.println("Connecté\n");

			// Creation d'une instruction
			Statement stmt = conn.createStatement();

			// Execution de la requete
			System.out.println("Exécution de la requête : " + req + "\n");
			ResultSet rset = stmt.executeQuery(req);
			ArrayList<Prof> profsM = new ArrayList<Prof>();
			// Affichage du résultat
			while (rset.next()) {
				Prof prof = new Prof ();
				Module module = new Module ();
				prof.setNumProf(rset.getInt(1));
				prof.setNomProf(rset.getString(2));
				prof.setPrenomProf(rset.getString(3));
				prof.setAdrProf(rset.getString(4));
				prof.setCpProf(rset.getString(5));
				prof.setVilleProf(rset.getString(6));
				
				
				module.setCode(rset.getString(7));
				module.setLibelle(rset.getString(8));
				module.sethCoursPrev(rset.getInt(9));
				module.sethCoursRea(rset.getInt(10));
				module.sethTpPrev(rset.getInt(11));
				module.sethTpRea(rset.getInt(12));
				module.setDiscipline(rset.getString(13));
				module.setCoefTest(rset.getInt(14));
				module.setCoefCc(rset.getInt(15));
				
				
				prof.setSpecialite(module);
				profsM.add(prof);
			}
			
			for (Prof prof : profsM) 
				System.out.println(prof);
			
			//System.out.println(profsM);
			// Fermeture de l'instruction (libération des ressources)
			stmt.close();
			System.out.println("\nOk.\n");

		} catch (Exception e) {
			e.printStackTrace();// Arggg!!!
			System.out.println(e.getMessage() + "\n");
		} finally {
			if (conn != null) {
				// Déconnexion de la base de données
				conn.close();
			}
		}
	}
}
