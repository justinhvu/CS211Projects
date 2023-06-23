public class InformationRequest extends Request{
    //fields
    private String[] questions;

    //getters and setters
    public String[] getQuestions() {
        return this.questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    //constructor
    public InformationRequest(String description, int priority, int difficulty, String[] questions) {
        super.setDescription(description);
        super.setPriority(priority);
        super.setDifficulty(difficulty);
        setQuestions(questions);

        super.setFactor(1);
        super.setStatus(Status.NEW);
        super.setStartTime(0);
        super.setEndTime(0);
        super.setCompletionLevel(0);
    }

    //other methods
    public int calculateProcessingTime() {
        return super.getDifficulty() * super.getFactor() * questions.length;
    }
}
