package association;

public class Notation {

	private float moyCC;
	private float moyTest;
	
	public Notation(float moyCC, float moyTest) {
		super();
		this.moyCC = moyCC;
		this.moyTest = moyTest;
	}

	@Override
	public String toString() {
		return "Notation [moyCC=" + moyCC + ", moyTest=" + moyTest + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(moyCC);
		result = prime * result + Float.floatToIntBits(moyTest);
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
		Notation other = (Notation) obj;
		if (Float.floatToIntBits(moyCC) != Float.floatToIntBits(other.moyCC))
			return false;
		if (Float.floatToIntBits(moyTest) != Float
				.floatToIntBits(other.moyTest))
			return false;
		return true;
	}

	public float getMoyCC() {
		return moyCC;
	}

	public void setMoyCC(float moyCC) {
		this.moyCC = moyCC;
	}

	public float getMoyTest() {
		return moyTest;
	}

	public void setMoyTest(float moyTest) {
		this.moyTest = moyTest;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
