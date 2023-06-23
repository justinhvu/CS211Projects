class Evidence
{
	//fields
	private String description;
	private byte type;
	private byte unambiguity;
	private byte credibility;
	private byte completeness;
	private byte conclusiveness;
	private byte probability;
	
	//constructors
	public Evidence(String description, byte type, byte unambiguity, byte credibility,
					byte completeness, byte conclusiveness) 
	{
		setDescription(description);
		setType(type);
		setUnambiguity(unambiguity);
		setCredibility(credibility);
		setCompleteness(completeness);
		setConclusiveness(conclusiveness);
		
		this.probability = computeProbability();
	}
	
	public Evidence(String description, byte unambiguity, byte credibility,
					byte completeness, byte conclusiveness)
	{
		setDescription(description);
		this.type = (byte)5;
		setUnambiguity(unambiguity);
		setCredibility(credibility);
		setCompleteness(completeness);
		setConclusiveness(conclusiveness);
		
		this.probability = computeProbability();
		
	}
	
	//getters
	public String getDescription(){
		return this.description;
	}
	
	public byte getType() {
		return this.type;
	}
	
	public byte getUnambiguity() {
		return this.unambiguity;
	}
	
	public byte getCredibility() {
		return this.credibility;
	}
	
	public byte getCompleteness() {
		return this.completeness;
	}
	
	public byte getConclusiveness() {
		return this.conclusiveness;
	}
	
	public byte getProbability() {
		return this.probability;
	}
	
	//setters
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setType(byte type) {
		if (type >= 0 && type <= 5) {
			this.type = type;
		}
		else {
			this.type = (byte)5;
		}
		
	}
	
	public void setUnambiguity(byte unambiguity) {
		if (unambiguity < 0) {
			this.unambiguity = (byte)0;
		}
		else if (unambiguity > 5) {
			this.unambiguity = (byte)5;
		}
		else {
			this.unambiguity = unambiguity;
		}
	}
	
	public void setCredibility(byte credibility) {
		if (credibility < 0) {
			this.credibility = (byte)0;
		}
		else if (credibility > 5) {
			this.credibility = (byte)5;
		}
		else {
			this.credibility = credibility;
		}
	}
	
	public void setCompleteness(byte completeness) {
		if (completeness < 0) {
			this.completeness = (byte)0;
		}
		else if (completeness > 5) {
			this.completeness = (byte)5;
		}
		else {
			this.completeness = completeness;
		}
	}
	
	public void setConclusiveness(byte conclusiveness) {
		if (conclusiveness < 0) {
			this.conclusiveness = (byte)0;
		}
		else if (conclusiveness > 5) {
			this.conclusiveness = (byte)5;
		}
		else {
			this.conclusiveness = conclusiveness;
		}
	}
	
	//other methods
	public byte computeProbability() {
		if (this.type == 1) {
			probability = (byte)(0.4 * (this.unambiguity) + 0.3 * (this.credibility) 
			+ 0.2 * (this.completeness) + 0.1 * (this.conclusiveness));
		}
		else if (this.type == 2) {
			probability = (byte)(0.2 * (this.unambiguity) + 0.4 * (this.credibility) 
			+ 0.2 * (this.completeness) + 0.2 * (this.conclusiveness));
		}
		else if (this.type == 3) {
			probability = (byte)(0.3 * (this.unambiguity) + 0.2 * (this.credibility) 
			+ 0.4 * (this.completeness) + 0.1 * (this.conclusiveness));
		}
		else if (this.type == 4) {
			probability = (byte)(0.2 * (this.unambiguity) + 0.6 * (this.credibility) 
			+ 0.1 * (this.completeness) + 0.1 * (this.conclusiveness));
		}
		else if (this.type == 5) {
			probability = (byte)(0.25 * (this.unambiguity) + 0.25 * (this.credibility) 
			+ 0.25 * (this.completeness) + 0.25 * (this.conclusiveness));
		}
		
		return probability;
	}
	
	public static String probabilityCertainty(byte probability) {
		String result = "";
		
		if (probability == 1) {
			result = "Real Evidence";
		}
		else if (probability == 2) {
			result = "Testimonial Statement";
		}
		else if (probability == 3) {
			result = "Demonstrative Evidence";
		}
		else if (probability == 4) {
			result = "Documentary Evidence";
		}
		else if (probability == 5) {
			result = "Not Specified";
		}
		
		return result;
	}
	
	public static String probability2String(byte probability)
	{
		String result = "";
		
		if (probability == 0) {
			result = "extremely unlikely";
		}
		else if (probability == 1) {
			result = "very unlikely";
		}
		else if (probability == 2) {
			result = "unlikely";
		}
		else if (probability == 3) {
			result = "likely";
		}
		else if (probability == 4) {
			result = "very likely";
		}
		else if (probability == 5) {
			result = "certain";
		}
		
		return result;
	}
	
	public String toString() {
		String result = ("Evidence: " + getDescription() + "\n" +
				"** Type of evidence: " + probabilityCertainty(getType()) + "\n" +
				"** Probability: " + getProbability() + " -> " + probability2String(getProbability()));
		
		return result;
	}
	
	public String printFullDescription() {
		String result = (toString() + "\n" +
						"Evaluated based on those characteristics:\n" +
						"** >> Unambiguity: " + getUnambiguity() + "\n" +
						"** >> Credibility: " + getCredibility() + "\n" +
						"** >> Completeness: " + getCompleteness() + "\n" +
						"** >> Conclusiveness: " + getConclusiveness());
						
		return result;
	}
}