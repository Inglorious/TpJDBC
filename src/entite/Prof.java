package entite;

import java.io.Serializable;

public class Prof implements Serializable{

	public Prof() {
		// TODO Auto-generated constructor stub
	}
	
	private int numProf;
	private String nomProf;
	private String prenomProf;
	private String adrProf;
	private String cpProf;
	private String villeProf;
	private Module specialite;
	public int getNumProf() {
		return numProf;
	}
	public void setNumProf(int numProf) {
		this.numProf = numProf;
	}
	public String getNomProf() {
		return nomProf;
	}
	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}
	public String getPrenomProf() {
		return prenomProf;
	}
	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}
	public String getAdrProf() {
		return adrProf;
	}
	public void setAdrProf(String adrProf) {
		this.adrProf = adrProf;
	}
	public String getCpProf() {
		return cpProf;
	}
	public void setCpProf(String cpProf) {
		this.cpProf = cpProf;
	}
	public String getVilleProf() {
		return villeProf;
	}
	public void setVilleProf(String villeProf) {
		this.villeProf = villeProf;
	}
	public Module getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Module specialite) {
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Prof [numProf=" + numProf + ", nomProf=" + nomProf
				+ ", prenomProf=" + prenomProf + ", adrProf=" + adrProf
				+ ", cpProf=" + cpProf + ", villeProf=" + villeProf
				+ ", specialite=" + specialite + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adrProf == null) ? 0 : adrProf.hashCode());
		result = prime * result + ((cpProf == null) ? 0 : cpProf.hashCode());
		result = prime * result + ((nomProf == null) ? 0 : nomProf.hashCode());
		result = prime * result + numProf;
		result = prime * result
				+ ((prenomProf == null) ? 0 : prenomProf.hashCode());
		result = prime * result
				+ ((specialite == null) ? 0 : specialite.hashCode());
		result = prime * result
				+ ((villeProf == null) ? 0 : villeProf.hashCode());
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
		Prof other = (Prof) obj;
		if (adrProf == null) {
			if (other.adrProf != null)
				return false;
		} else if (!adrProf.equals(other.adrProf))
			return false;
		if (cpProf == null) {
			if (other.cpProf != null)
				return false;
		} else if (!cpProf.equals(other.cpProf))
			return false;
		if (nomProf == null) {
			if (other.nomProf != null)
				return false;
		} else if (!nomProf.equals(other.nomProf))
			return false;
		if (numProf != other.numProf)
			return false;
		if (prenomProf == null) {
			if (other.prenomProf != null)
				return false;
		} else if (!prenomProf.equals(other.prenomProf))
			return false;
		if (specialite == null) {
			if (other.specialite != null)
				return false;
		} else if (!specialite.equals(other.specialite))
			return false;
		if (villeProf == null) {
			if (other.villeProf != null)
				return false;
		} else if (!villeProf.equals(other.villeProf))
			return false;
		return true;
	}
	
	
}
