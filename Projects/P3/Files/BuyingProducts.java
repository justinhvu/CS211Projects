public class BuyingProducts extends Request{
    //fields
    private String[] itemsToBuy;

    //getters and setters
    public String[] getItemsToBuy() {
        return this.itemsToBuy;
    }

    public void setItemsToBuy(String[] itemsToBuy) {
        this.itemsToBuy = itemsToBuy;
    }

    //constructors
    public BuyingProducts(String description, int priority, int difficulty, String[] itemsToBuy) {
        super.setDescription(description);
        super.setPriority(priority);
        super.setDifficulty(difficulty);
        setItemsToBuy(itemsToBuy);

        super.setFactor(2);
        super.setStatus(Status.NEW);
        super.setStartTime(0);
        super.setEndTime(0);
        super.setCompletionLevel(0);
    }

    //other methods
    public int calculateProcessingTime() {
        return super.getDifficulty() * super.getFactor() * itemsToBuy.length;
    }
}
