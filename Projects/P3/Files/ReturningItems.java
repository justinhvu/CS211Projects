public class ReturningItems extends Request {
    //fields
    private String[] itemsToReturn;

    //getters and setters
    public String[] getItemsToReturn() {
        return this.itemsToReturn;
    }

    public void setItemsToReturn(String[] itemsToReturn) {
        this.itemsToReturn = itemsToReturn;
    }

    //constructor
    public ReturningItems(String description, int priority, int diffuculty, String[] itemsToReturn) {
        super.setDescription(description);
        super.setPriority(priority);
        super.setDifficulty(diffuculty);
        setItemsToReturn(itemsToReturn);

        super.setFactor(3);
        super.setStatus(Status.NEW);
        super.setStartTime(0);
        super.setEndTime(0);
        super.setCompletionLevel(0);
    }

    //other methods
    public int calculateProcessingTime() {
        return super.getDifficulty() * super.getFactor() * itemsToReturn.length;
    }
}
