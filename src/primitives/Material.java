package primitives;

public class Material {
	
	public double kD = 0;
	public double kS = 0;
	public int nShininess =0;
	
	/**
	 * Material constructor 
	 * 
	 * @param kD
	 * @param kS
	 * @param nShininess
	 */
	public Material(double kD, double kS, int nShininess) {
		this.kD = kD;
		this.kS = kS;
		this.nShininess = nShininess;
	}

	/**
	 * Material default constructor 
	 * 
	 * @param kD = 0
	 * @param kS = 0
	 * @param nShininess = 0
	 */
	public Material() {
		this.kD = 0;
		this.kS = 0;
		this.nShininess = 0;
	}

	/**
	 * @param kD the kD to set
	 */
	public Material setkD(double kD) {
		this.kD = kD;
		return this; 
	}

	/**
	 * @param kS the kS to set
	 */
	public Material setkS(double kS) {
		this.kS = kS;
		return this; 
	}

	/**
	 * @param nShininess the nShininess to set
	 */
	public Material setnShininess(int nShininess) {
		this.nShininess = nShininess;
		return this; 
	}	

}
