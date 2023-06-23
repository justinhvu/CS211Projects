public class VIPQueue extends Queue{
    //fields
    private boolean acceptingAnyClients;

    //getters and setters
    public boolean getAcceptingAnyClients() {
        return this.acceptingAnyClients;
    }

    public void setAcceptingAnyClients(boolean acceptingAnyClients) {
        this.acceptingAnyClients = acceptingAnyClients;
    }

    public VIPQueue(String serverName, int queueSize, boolean acceptAnyClients) {
        super(serverName, queueSize);
        setAcceptingAnyClients(acceptAnyClients);
    }

    public VIPQueue(String serverName, int queueSize) {
        super(serverName, queueSize);
        this.acceptingAnyClients = true;
    }
}
