package association;

import entite.Etudiant;
import entite.Module;

public class Lien {

	private Module module;
	private Etudiant Etudiant;
	private Notation note;
	

	
	
	@Override
	public String toString() {
		return "Lien [module=" + module + ", Etudiant=" + Etudiant + ", note="
				+ note + "]";
	}


	public Lien(Module module, entite.Etudiant etudiant) {
		super();
		this.module = module;
		Etudiant = etudiant;
	}


	public void setNotation(Notation note) {
		this.note = note;
	}


	public Module getModule() {
		return module;
	}


	public Etudiant getEtudiant() {
		return Etudiant;
	}


	public Notation getNote() {
		return note;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Etudiant == null) ? 0 : Etudiant.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lien other = (Lien) obj;
		if (Etudiant == null) {
			if (other.Etudiant != null)
				return false;
		} else if (!Etudiant.equals(other.Etudiant))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		return true;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
