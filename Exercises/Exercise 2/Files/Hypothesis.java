class Hypothesis
{
	//fields
	private String description;
	private Relevance[] supportingItems;
	private byte probability;
	
	//constructors
	public Hypothesis(String description, Relevance[] supportingItems) {
		setDescription(description);
		setSupportingItems(supportingItems);
		setProbability();
	}
	
	public Hypothesis(String description) {
		setDescription(description);
		this.supportingItems = new Relevance[0];
		this.probability = 0;
	}
	
	//getters
	public String getDescription() {
		return this.description;
	}
	
	public Relevance[] getSupportingItems() {
		return this.supportingItems;
	}
	
	public byte getProbability() {
		return this.probability;
	}
	
	//setters
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setSupportingItems(Relevance[] supportingItems) {
		this.supportingItems = supportingItems;
	}
	
	public void setProbability(byte probability) {
		if (probability < 0) {
			this.probability = (byte)0;
		}
		else if (probability > 5) {
			this.probability = (byte)5;
		}
		else {
			this.probability = probability;
		}
	}
	
	public void setProbability() {
		probability = 5;
		for (int i = 0; i < this.supportingItems.length; i++) {
			if (this.supportingItems[i].getInferentialForce() < probability) {
				probability = this.supportingItems[i].getInferentialForce();
			}
		}
	}
	
	//other methods
	public void addSupportingItem(Relevance extraSupportingItems) {
		Relevance[] tempArray = new Relevance[this.supportingItems.length + 1];
		for (int i = 0; i < this.supportingItems.length; i++) {
			tempArray[i] = supportingItems[i];
		}
		
		tempArray[tempArray.length - 1] = extraSupportingItems;
		
		this.supportingItems = tempArray;
		setProbability();
	}
	
	public byte computeProbability() {
		setProbability(probability);
		return probability;
	}
	
	public String toString() {
		String result = ("Hypothesis:\n" + 
				"** Description: " + getDescription() + "\n" +
				"** Probability: " + getProbability() + " -> " + Evidence.probability2String(getProbability()));
				
		return result;
	}
}