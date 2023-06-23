public abstract class Request implements Prioritizable{
    //fields
    private String description;
    private int priority;
    private int difficulty;
    private int factor;
    private int startTime;
    private int endTime;
    private int completionLevel;
    private Status status;

    //getters and setters
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getFactor() {
        return this.factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getCompletionLevel() {
        return this.completionLevel;
    }

    public void setCompletionLevel(int completionLevel) {
        this.completionLevel = completionLevel;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    //other methods
    public abstract int calculateProcessingTime();
}
