public class Queue {
    //fields
    private String serverName;
    private int queueSize;
    private Client clientBeingServed;
    private Request requestInProgress;
    private int processingStartTime;
    private Client[] clientsHistory;
    private Client[] clientsInQueue;

    //getters and setters
    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public Client getClientBeingServed() {
        return this.clientBeingServed;
    }

    public void setClientBeingServed(Client clientBeingServed) {
        this.clientBeingServed = clientBeingServed;
    }

    public Request getRequestInProgress() {
        return this.requestInProgress;
    }

    public void setRequestInProgress(Request requestInProgress) {
        this.requestInProgress = requestInProgress;
    }

    public int getProcessingStartTime() {
        return this.processingStartTime;
    }

    public void setProcessingStartTime(int processingStartTime) {
        this.processingStartTime = processingStartTime;
    }

    public Client[] getClientsHistory() {
        return this.clientsHistory;
    }

    public void setClientsHistory(Client[] clientsHistory) {
        this.clientsHistory = clientsHistory;
    }

    public Client[] getClientsInQueue() {
        return this.clientsInQueue;
    }

    public void setClientsInQue(Client[] clientsInQueue) {
        this.clientsInQueue = clientsInQueue;
    }

    //constructor
    public Queue(String serverName, int queueSize) {
        setServerName(serverName);
        setQueueSize(queueSize);
        Client[] tempArray = {};
        setClientsHistory(tempArray);
        setClientsInQue(new Client[queueSize]);
    }

    //other methods
    private int getQueueId() {
        int result = 0;
        for (int i = 0; i < QueueSystem.getQueues().length; i++) {
            if (QueueSystem.getQueues()[i] != null && QueueSystem.getQueues()[i].getServerName() == this.serverName) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    public String toString() {
        String result = "";
        if (clientBeingServed != null) {
            if (clientBeingServed.getId() < 10) {
                result = "[Queue:" + getQueueId() + "][0" + clientBeingServed.getId() + "]-----";
            }
            else {
                result = "[Queue:" + getQueueId() + "][" + clientBeingServed.getId() + "]-----";
            }
        }
        else {
            result = "[Queue:" + getQueueId() + "][  ]-----";
        }
        for (int i = 0; i < clientsInQueue.length; i++) {
            if (clientsInQueue[i] != null) {
                if (clientsInQueue[i].getId() < 10) {
                    result += "[0" + clientsInQueue[i].getId() + "]";
                }
                else {
                    result += "[" + clientsInQueue[i].getId() + "]";
                }
            }
            else {
                result += "[  ]";
            }
        }
        return result;
    }

    public String toString(boolean showID) {
        String result = "";
        if (showID == false) {
            if (clientBeingServed != null) {
                int remainingTime = clientBeingServed.serviceTime() - (QueueSystem.getClock() - getProcessingStartTime());
                if (clientBeingServed.serviceTime() < 10) {
                    result = "[Queue:" + getQueueId() + "][0" + remainingTime + "]-----";
                }
                else {
                    result = "[Queue:" + getQueueId() + "][" + remainingTime + "]-----";
                }
            }
            else {
                result = "[Queue:" + getQueueId() + "][  ]-----";
            }
            for (int i = 0; i < clientsInQueue.length; i++) {
                if (clientsInQueue[i] != null) {
                    if (clientsInQueue[i].serviceTime() < 10) {
                        result += "[0" + clientsInQueue[i].serviceTime() + "]";
                    }
                    else {
                        result += "[" + clientsInQueue[i].serviceTime() + "]";
                    }
                }
                else {
                    result += "[  ]";
                }
            }
        }
        else {
            result = toString();
        }
        
        return result;
    }
}
