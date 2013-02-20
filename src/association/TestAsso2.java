package association;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.pool.OracleDataSource;
import connexion.ConnexionUnique;
import entite.Etudiant;
import entite.Module;
import entite.Prof;

public class TestAsso2 {

	// Chaine de connexion
	static final String connect_string = "jdbc:mysql://localhost:3306/maBD";
	static final String login = "root";
	static final String psw = "mysql";
	
	
	
	// La requête de test
	static  String reqEt = "SELECT * " +
							  	"FROM ETUDIANT, MODULE, PROF, ENSEIGNT "+
							  	"WHERE ETUDIANT.NUM_ET = ENSEIGNT.NUM_ET "+
							  	"AND ENSEIGNT.CODE = MODULE.CODE " + 
							  	"AND PROF.NUM_PROF = ENSEIGNT.NUM_PROF ";

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
			System.out.println("Exécution de la requête : " + reqEt + "\n");
			ResultSet rset = stmt.executeQuery(reqEt);
			
			
			AssociationNotation assoN = AssociationNotation.getInstance();
			//Module mACSI = null;
			ArrayList<Enseignement> enseignements = new ArrayList<Enseignement>();

			// Affichage du résultat
			while (rset.next()) {
				Etudiant etudiant = new Etudiant (rset.getInt("ETUDIANT.NUM_ET"));
				Module module = new Module ();
				Prof prof = new Prof ();
				
				etudiant.setNomEt(rset.getString("NOM_ET"));
				etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
				etudiant.setCpEt(rset.getString("CP_ET"));
				etudiant.setVilleEt(rset.getString("VILLE_ET"));
				etudiant.setAnnee(rset.getInt("ANNEE"));
				etudiant.setGroupe(rset.getInt("GROUPE"));
				
				
				module.setCode(rset.getString("MODULE.CODE"));
				module.setLibelle(rset.getString("LIBELLE"));
				module.sethCoursPrev(rset.getInt("H_COURS_PREV"));
				module.sethCoursRea(rset.getInt("H_COURS_REA"));
				module.sethTpPrev(rset.getInt("H_TP_PREV"));
				module.sethTpRea(rset.getInt("H_TP_REA"));
				module.setDiscipline(rset.getString("DISCIPLINE"));
				module.setCoefTest(rset.getInt("COEFF_TEST"));
				module.setCoefCc(rset.getInt("COEFF_CC"));
				
				prof.setNumProf(rset.getInt("NUM_PROF"));
				prof.setNomProf(rset.getString("NOM_PROF"));
				prof.setPrenomProf(rset.getString("PRENOM_PROF"));
				prof.setAdrProf(rset.getString("ADR_PROF"));
				prof.setCpProf(rset.getString("CP_PROF"));
				prof.setVilleProf(rset.getString("VILLE_PROF"));
				
				Enseignement e = new Enseignement();
				e.setEtudiant(etudiant);
				e.setModule(module);
				e.setProf(prof);
				
				enseignements.add(e);
			

				
			}
			
			for (Enseignement e : enseignements) {
				Etudiant et = new Etudiant ();
				et = e.getEtudiant();
				if (1 == et.getGroupe())
					System.out.println(e);
			}
			/*reqEt = "SELECT * FROM MODULE WHERE CODE = 'ACSI'";
			System.out.println("Exécution de la requête : " + reqEt + "\n");
			rset = stmt.executeQuery(reqEt);

			while (rset.next()){
				mACSI =  new Module();
				mACSI.setCode(rset.getString("MODULE.CODE"));
				mACSI.setLibelle(rset.getString("LIBELLE"));
				mACSI.sethCoursPrev(rset.getInt("H_COURS_PREV"));
				mACSI.sethCoursRea(rset.getInt("H_COURS_REA"));
				mACSI.sethTpPrev(rset.getInt("H_TP_PREV"));
				mACSI.sethTpRea(rset.getInt("H_TP_REA"));
				mACSI.setDiscipline(rset.getString("DISCIPLINE"));
				mACSI.setCoefTest(rset.getInt("COEFF_TEST"));
				mACSI.setCoefCc(rset.getInt("COEFF_CC"));
			}*/
			
			/*Set<Lien> liens = new HashSet(  assoN.getLiens(mACSI));
			
			for (Lien lien : liens) {
				System.out.println(lien);
			}
			*/
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
