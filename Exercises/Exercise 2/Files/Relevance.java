class Relevance
{
	//fields
	private Evidence evidence;
	private Hypothesis subHypothesis;
	private byte level;
	private byte inferentialForce;
	
	//constructors
	public Relevance(Evidence evidence, byte level) {
		setEvidence(evidence);
		setLevel(level);
	}
	
	public Relevance(Hypothesis subHypothesis, byte level) {
		setSubHypothesis(subHypothesis);
		setLevel(level);
	}
	
	//getters
	public Evidence getEvidence() {
		return this.evidence;
	}
	
	public Hypothesis getSubHypothesis() {
		return this.subHypothesis;
	}
	
	public byte getLevel() {
		return this.level;
	}
	
	public byte getInferentialForce() {
		return this.inferentialForce;
	}
	
	//setters
	public void setEvidence(Evidence evidence) {
		this.evidence = evidence;
		this.subHypothesis = null;
		setInferentialForce();
	}
	
	public void setSubHypothesis(Hypothesis subHypothesis) {
		this.subHypothesis = subHypothesis;
		this.evidence = null;
		setInferentialForce();
	}
	
	public void setLevel(byte level) {
		if (level < 0) {
			this.level = (byte)0;
		}
		else if (level > 5) {
			this.level = (byte)5;
		}
		else {
			this.level = level;
		}
		
		setInferentialForce();
	}
	
	public void setInferentialForce() {
		if (evidence != null) {
			inferentialForce = (byte)(Math.min(evidence.getProbability(), getLevel()));
		}
		else if (subHypothesis != null) {
			inferentialForce = (byte)(Math.min(subHypothesis.getProbability(), getLevel()));
		}
	}
	
	//other methods
	public byte computeInferentialForce() {
		setInferentialForce();
		byte result = getInferentialForce();
		
		return result;
	}
	
	public String toString() {
		String description = "";
		
		if (subHypothesis == null) {
			description = evidence.getDescription();
		}
		else if (evidence == null) {
			description = subHypothesis.getDescription();
		}
		
		String result = ("Relevance :\n" +
						"** of: " + description + "\n" +
						"** relevance level: " + getLevel() + " -> " + evidence.probability2String(getLevel()) + "\n" +
						"** inferential force: " + getInferentialForce() + " -> " + evidence.probability2String(getInferentialForce()));
		
		return result;
	}
}