package association;

import java.util.HashSet;
import java.util.Set;

import entite.Etudiant;
import entite.Module;

public class AssociationNotation {

	private Set<Lien> liens;
	private static AssociationNotation instance;
	
	private AssociationNotation() {
		liens = new HashSet<Lien>();
	}
	
	public void creerLien (Module mo, Etudiant et, Notation no) {
		Lien l = new Lien (mo, et);
		l.setNotation(no);
		liens.add(l);
	}
	
	public void supprimerLien (Module mo, Etudiant et) {
		Lien li = new Lien (mo, et);
		for (Lien lien : liens) {
			if (lien.equals(li)) {
				liens.remove(lien);
				return;
			}
		}
	}
	
	public void supprimerLien (Lien lien) {
		liens.remove(lien);
	}
	
	public Lien getLien (Module mo, Etudiant et) {
		
		Lien li = new Lien (mo, et);
		for (Lien lien : liens) {
			if (lien.equals(li)) {
				return lien;
			}
		}
		return null;
	}
	
	public Set<Lien> getLiens (Etudiant et) {
		Set<Lien> lienRetour = new HashSet<Lien>();
		
		for (Lien lien : liens) {
			if (lien.getEtudiant().equals(et))
				lienRetour.add(lien);
		}
		return lienRetour;
	}
	
	public Set<Lien> getLiens (Module mo) {
		Set<Lien> lienRetour = new HashSet<Lien>();
		for (Lien lien : liens) {
			if (lien.getModule().equals(mo))
				lienRetour.add(lien);
		}
		return lienRetour;
	}
	
	public Set<Module> getModules (Etudiant et) {
		Set<Module> moduleRetour = new HashSet<Module>();
		for (Lien lien : liens) {
			if (lien.getEtudiant().equals(et))
				moduleRetour.add(lien.getModule());
		}
		return moduleRetour;
		
	}
	
	public Set<Etudiant> getEtudiants (Module mo) {
		Set<Etudiant> etudiantRetour = new HashSet<Etudiant>();
		for (Lien lien : liens) {
			if (lien.getModule().equals(mo))
				etudiantRetour.add(lien.getEtudiant());
		}
		return etudiantRetour;
		
	}
	
	public static AssociationNotation getInstance () {
		if (null == instance)
			return (new AssociationNotation());
		return instance;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
