class Problem
{
	//fields
	public String question;
	public Hypothesis rootHypothesis;

	//constructors
	public Problem(String question, Hypothesis rootHypothesis) {
		this.question = question;
		this.rootHypothesis = rootHypothesis;
	}

	public Problem(String question) {
		this.question = question;
	}
	
	//getters
	
	//setters
	

	
	//other methods
	public String generateArgumentation() {
		String result = "";
		if (rootHypothesis == null || rootHypothesis.getSupportingItems().length == 0) {
			result = "";
		}
		else{
			result = ("Auto-generated report:\n" +
				"\tQuestion: " + this.question + "\n" + 
				"\tIt is " + (Evidence.probability2String(rootHypothesis.getProbability())).toUpperCase() + " to observe " + rootHypothesis.getDescription() + "\n" +
				"\tThis conclusion is base on the following hypothesis or evidence:");
				
			for (int i = 0; i < rootHypothesis.getSupportingItems().length; i++) {
				if (rootHypothesis.getSupportingItems()[i].getEvidence() == null) {
					result += ("\n\t\tIt is " + Evidence.probability2String(rootHypothesis.getSupportingItems()[i].getSubHypothesis().getProbability()).toUpperCase() + 
								" that " + rootHypothesis.getSupportingItems()[i].getSubHypothesis().getDescription());
				}
				else if (rootHypothesis.getSupportingItems()[i].getSubHypothesis() == null) {
					result += ("\n\t\tIt is " + Evidence.probability2String(rootHypothesis.getSupportingItems()[i].getEvidence().getProbability()).toUpperCase() + 
								" that " + rootHypothesis.getSupportingItems()[i].getEvidence().getDescription());
				}
			}
		}
		
		
		return result;
	}
}