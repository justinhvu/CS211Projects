import javax.swing.CellEditor;

public class QueueSystem {
    //fields
    private static int clock = 0;
    private static int totalWaitingTime = 0;
    private static Client[] clientsWorld;
    private static int totalClientsInSystem = 0;
    private static int waitingLineSize = 0;
    private static Client[] waitingLine;
    private static boolean tvInWaitingArea = false;
    private static boolean coffeeInWaitingArea = false;
    private static Queue[] queues;

    //getters and setters
    public static int getClock() {
        return clock;
    }

    public static void setClock(int clock) {
        QueueSystem.clock = clock;
    }

    public static int getTotalWaitingTime() {
        int tempTotalWaitingTime = 0;

        for (int i = 0; i < queues.length; i++) {
            if (queues[i].getClientBeingServed() != null) {
                tempTotalWaitingTime += queues[i].getClientBeingServed().getWaitingTime();
            }
            for (int j = 0; j < queues[i].getClientsInQueue().length; j++) {
                if (queues[i].getClientsInQueue()[j] != null) {
                    tempTotalWaitingTime += queues[i].getClientBeingServed().getWaitingTime();
                }
            }
        }

        for (int i = 0; i < waitingLine.length; i++) {
            if (waitingLine[i] != null) {
                tempTotalWaitingTime += queues[i].getClientBeingServed().getWaitingTime();
            }
        }
        QueueSystem.totalWaitingTime = tempTotalWaitingTime;
        return totalWaitingTime;
    }

    public static void setTotalWaitingTime(int totalWaitingTime) {
        QueueSystem.totalWaitingTime = totalWaitingTime;
    }

    public static Client[] getClientsWorld() {
        return clientsWorld;
    }

    public static void setClientsWorld(Client[] clientsWorld) {
        QueueSystem.clientsWorld = clientsWorld;
    }

    public static int getTotalClientsInSystem() {
        int tempTotalClientsInSystem = 0;

        for (int i = 0; i < queues.length; i++) {
            if (queues[i].getClientBeingServed() != null) {
                tempTotalClientsInSystem++;
            }
            for (int j = 0; j < queues[i].getClientsInQueue().length; j++) {
                if (queues[i].getClientsInQueue()[j] != null) {
                    tempTotalClientsInSystem++;
                }
            }
        }

        for (int i = 0; i < waitingLine.length; i++) {
            if (waitingLine[i] != null) {
                tempTotalClientsInSystem++;
            }
        }
        QueueSystem.totalClientsInSystem = tempTotalClientsInSystem;
        return totalClientsInSystem;
    }

    public static void setTotalClientsInSystem(int totalClientsInSystem) {
        QueueSystem.totalClientsInSystem = totalClientsInSystem;
    }

    public static int getWaitingLineSize() {
        return waitingLineSize;
    }

    public static void setWaitingLineSize(int waitingLineSize) {
        QueueSystem.waitingLineSize = waitingLineSize;
    }

    public static Client[] getWaitingLine() {
        return waitingLine;
    }

    public static void setWaitingLine(Client[] waitingLine) {
        QueueSystem.waitingLine = waitingLine;
    }

    public static boolean getTvInWaitingArea() {
        return tvInWaitingArea;
    }

    public static void setTvInWaitingArea(boolean tvInWaitingArea) {
        QueueSystem.tvInWaitingArea = tvInWaitingArea;
    }

    public static boolean getCoffeeInWaitingArea() {
        return coffeeInWaitingArea;
    }

    public static void setCoffeeInWaitingArea(boolean coffeeInWaitingArea) {
        QueueSystem.coffeeInWaitingArea = coffeeInWaitingArea;
    }

    public static Queue[] getQueues() {
        return queues;
    }

    public static void setQueues(Queue[] queues) {
        QueueSystem.queues = queues;
    }

    //constructors
    public QueueSystem(int waitingLineSize, boolean tvInWaitingArea, boolean coffeeInWaitingArea) {
        QueueSystem.waitingLineSize = waitingLineSize;
        QueueSystem.tvInWaitingArea = tvInWaitingArea;
        QueueSystem.coffeeInWaitingArea = coffeeInWaitingArea;
        QueueSystem.clock = 0;

        QueueSystem.waitingLine = new Client[waitingLineSize];
    }

    //other methods
    public static void increaseTime() {
        //advance clock by 1 unit of time
        clock++;

        //go through queues for request processing
        for (int i = 0; i < queues.length; i++) {
            //check the client being served
            if (queues[i].getClientBeingServed() != null) {
                boolean previousRequestProcessed = true;
                //go through the requests
                for (int j = 0; j < queues[i].getClientBeingServed().getRequests().length; j++) {
                    Request request = queues[i].getClientBeingServed().getRequests()[j];
                    //check if request was processed, increase count
                    if (request.getStatus() == Status.PROCESSED) {
                    }
                    else if (request.getStatus() == Status.IN_PROGRESS) {
                        //if in progress, check if updating processes it
                        if (request.calculateProcessingTime() == clock - request.getStartTime()) {
                            //change status and set end time and completion level
                            request.setStatus(Status.PROCESSED);
                            request.setEndTime(clock);
                            request.setCompletionLevel(100);
                            previousRequestProcessed = true;
                        }
                        else {
                            //only update completion level
                            request.setCompletionLevel((clock - queues[i].getClientBeingServed().getRequests()[j].getStartTime()) / 100);
                        }
                    }
                    //if the previous request was processed and there are more requests, start updating
                    if (previousRequestProcessed && request.getStatus() == Status.NEW) {
                        request.setStatus(Status.IN_PROGRESS);
                        request.setStartTime(clock);
                        request.setCompletionLevel(0);
                        previousRequestProcessed = false;
                        break;
                    }
                }
                //if all requests are processed, set departure time, add client to history, set current client to null
                if (queues[i].getClientBeingServed().serviceTime() - (QueueSystem.getClock() - queues[i].getProcessingStartTime()) == 0) {
                    queues[i].getClientBeingServed().setDepartureTime(clock);
                    Client[] tempHistory = new Client[queues[i].getClientsHistory().length + 1];
                    for (int j = 0; j < queues[i].getClientsHistory().length; j++) {
                        tempHistory[j] = queues[i].getClientsHistory()[j];
                    }
                    tempHistory[queues[i].getClientsHistory().length] = queues[i].getClientBeingServed();
                    queues[i].setClientsHistory(tempHistory);
                    queues[i].setClientBeingServed(null);
                }
            }
        }
        //check clients world to move clients
        int clientsArrivedSize = 0;
        for (int i = 0; i < clientsWorld.length; i++) {
            if (clientsWorld[i] != null && clientsWorld[i].getArrivalTime() == clock) {
                clientsArrivedSize++;
            }
        }
        //creating an array to be sorted
        Client[] clientsArrived = new Client[clientsArrivedSize];
        int shift = 0;
        for (int i = 0; i < clientsWorld.length; i++) {
            if (clientsWorld[i] != null && clientsWorld[i].getArrivalTime() == clock) {
                clientsArrived[shift] = clientsWorld[i];
                clientsWorld[i] = null;
                shift++;
            }
        }
        //FIXME DO VIP RULES FIRST
        //sort the array according to business rules
        if (clientsArrived.length > 0) {
            for (int i = 0; i < clientsArrived.length; i++) {
                for (int j = i + 1; j < clientsArrived.length; j++) {
                    //sort by age
                    if (clientsArrived[i].getYearOfBirth() > clientsArrived[j].getYearOfBirth()) {
                        Client tempClient = clientsArrived[i];
                        clientsArrived[i] = clientsArrived[j];
                        clientsArrived[j] = tempClient;
                    }
                    else if (clientsArrived[i].getYearOfBirth() == clientsArrived[j].getYearOfBirth()) {
                        //sort by processing time
                        if (clientsArrived[i].serviceTime() > clientsArrived[j].serviceTime() && i != j) {
                            Client tempClient = clientsArrived[i];
                            clientsArrived[i] = clientsArrived[j];
                            clientsArrived[j] = tempClient;
                        }
                        else if (clientsArrived[i].serviceTime() == clientsArrived[j].serviceTime()) {
                            //sort by last name
                            if (clientsArrived[i].getLastName().compareTo(clientsArrived[j].getLastName()) > 0) {
                                Client tempClient = clientsArrived[i];
                                clientsArrived[i] = clientsArrived[j];
                                clientsArrived[j] = tempClient;
                            }
                            else if (clientsArrived[i].getLastName().compareTo(clientsArrived[j].getLastName()) == 0) {
                                //sort by first name
                                if (clientsArrived[i].getFirstName().compareTo(clientsArrived[j].getFirstName()) > 0) {
                                    Client tempClient = clientsArrived[i];
                                    clientsArrived[i] = clientsArrived[j];
                                    clientsArrived[j] = tempClient;
                                }
                            }
                        }
                    }
                }
            }
        }

        //check if there is a vip queue
        //if yes, set the index of the queue to use later
        boolean hasVipQueue = false;
        int vipQueueIndex = 0;
        for (int i = 0; i < queues.length; i++) {
            if (queues[i] instanceof VIPQueue) {
                vipQueueIndex = i;
                hasVipQueue = true;
            }
        }
    
        //check if there is a vip client inside of arrived clients
            //if yes, acceptingAnyClients = false;
        boolean hasVipClients = false;
        int numVipClients = 0;
        if (hasVipQueue) {
            for (int i = 0; i < clientsArrived.length; i++) {
                if (clientsArrived[i] instanceof VIPClient) {
                    hasVipClients = true;
                    numVipClients++;
                }
            }
            if (hasVipClients) {
                ((VIPQueue)queues[vipQueueIndex]).setAcceptingAnyClients(false);
            }
        }
        //if there are vip clients
            //sort the vip clients
                //they will already by sorted according to regular rules
                //so you only need to check their priority and member since
        VIPClient[] vipClients = new VIPClient[numVipClients];
        if (hasVipClients) {
            //populate vipClients
            int index = 0;
            for (int i = 0; i < clientsArrived.length; i++) {
                if (clientsArrived[i] instanceof VIPClient) {
                    vipClients[index] = (VIPClient)clientsArrived[i];
                    index++;
                }
            }
            //sorting the vipclients array
            for (int i = 0; i < vipClients.length; i++) {
                for (int j = i + 1; j < vipClients.length; j++) {
                    //sort by priority
                    if (vipClients[i].getPriority() < vipClients[j].getPriority()) {
                        VIPClient tempClient = vipClients[i];
                        vipClients[i] = vipClients[j];
                        vipClients[j] = tempClient;
                    }
                    else if (vipClients[i].getPriority() == vipClients[j].getPriority()) {
                        //sort by member since
                        if (vipClients[i].getMemberSince() > vipClients[j].getMemberSince()) {
                            VIPClient tempClient = vipClients[i];
                            vipClients[i] = vipClients[j];
                            vipClients[j] = tempClient;
                        }
                    }
                }
            }
        }

        //go through queues for client updating
        for (int i = 0; i < queues.length; i++) {
            //if no client is being served, try to set client to next person in queue
            if (queues[i].getClientBeingServed() == null) {
                if (queues[i].getClientsInQueue()[0] != null) {
                    //set client being served to next person in queue
                    queues[i].setClientBeingServed(queues[i].getClientsInQueue()[0]);
                    queues[i].setProcessingStartTime(clock);
                    //move everyone else up in queue
                    //stop before last because that will make it array out of bounds error
                    for (int j = 0; j < queues[i].getClientsInQueue().length - 1; j++) {
                        if (queues[i].getClientsInQueue()[j+1] != null) {
                            queues[i].getClientsInQueue()[j] = queues[i].getClientsInQueue()[j+1];
                        }
                    }
                    //set the last position in queue to empty
                    queues[i].getClientsInQueue()[queues[i].getClientsInQueue().length - 1] = null;
                }
            }
        }
        //increase time in queue for every person in queue, and decrease patience
        for (int i = 0; i < queues.length; i++) {
            for (int j = 0; j < queues[i].getClientsInQueue().length; j++) {
                if (queues[i].getClientsInQueue()[j] != null) {
                    queues[i].getClientsInQueue()[j].setTimeInQueue(queues[i].getClientsInQueue()[j].getTimeInQueue() + 1);
                    queues[i].getClientsInQueue()[j].setPatience(queues[i].getClientsInQueue()[j].getPatience() - 1);
                }
            }
        }
        //increase time in waiting line for every person in waiting line and decrease patience
        for (int j = 0; j < waitingLine.length; j++) {
            if (waitingLine[j] != null) {
                waitingLine[j].setWaitingTime(waitingLine[j].getWaitingTime() + 1);
                waitingLine[j].setPatience(waitingLine[j].getPatience() - 1);
            }
        }
        //check patience of queues
        for (int i = 0; i < queues.length; i ++) {
            for (int j = 0; j < queues[i].getClientsInQueue().length; j++) {
                if (queues[i].getClientsInQueue()[j] != null && queues[i].getClientsInQueue()[j].getPatience() < 0) {
                    queues[i].getClientsInQueue()[j].setDepartureTime(clock);
                    //move everyone up in queue
                    for (int k = 0; k < queues[i].getClientsInQueue().length - 1; k++) {
                        if (queues[i].getClientsInQueue()[k+1] == null) {
                            queues[i].getClientsInQueue()[k] = null;
                        }
                        else {
                            queues[i].getClientsInQueue()[k] = queues[i].getClientsInQueue()[k+1];
                        }
                    }
                    //set the last position in queue to empty
                    queues[i].getClientsInQueue()[queues[i].getClientsInQueue().length - 1] = null;
                }
            }
        }
        //check patience of waiting line
        for (int j = 0; j < waitingLine.length; j++) {
            if (waitingLine[j] != null && waitingLine[j].getPatience() < 0) {
                waitingLine[j].setDepartureTime(clock);
                //move everyone up in waiting line
                for (int k = 0; k < waitingLine.length - 1; k++) {
                    if (waitingLine[k+1] == null) {
                        waitingLine[k] = null;
                    }
                    else {
                        waitingLine[k] = waitingLine[k+1];
                    }
                }
                //set the last position in queue to empty
                waitingLine[waitingLine.length - 1] = null;
            }
        }

        //check if there are any vip clients in whole system
        boolean vipClientInSystem = false;
        if (hasVipQueue) {
            for (int i = 0; i < queues.length; i++) {
                if (queues[i].getClientBeingServed() instanceof VIPClient) {
                    ((VIPQueue)queues[vipQueueIndex]).setAcceptingAnyClients(false);
                    vipClientInSystem = true;
                    break;
                }
                else {
                    for (int j = 0; j < queues[i].getClientsInQueue().length; j++) {
                        if (queues[i].getClientsInQueue()[j] instanceof VIPClient) {
                            ((VIPQueue)queues[vipQueueIndex]).setAcceptingAnyClients(false);
                            vipClientInSystem = true;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < waitingLine.length; i++) {
                if (waitingLine[i] instanceof VIPClient) {
                    ((VIPQueue)queues[vipQueueIndex]).setAcceptingAnyClients(false);
                    vipClientInSystem = true;
                    break;
                }
            }
        }

        //check if the vip queue is empty
        if (hasVipQueue && vipClientInSystem == false && hasVipClients == false) {
            ((VIPQueue)queues[vipQueueIndex]).setAcceptingAnyClients(true);
            if (((VIPQueue)queues[vipQueueIndex]).getClientBeingServed() != null) {
                ((VIPQueue)queues[vipQueueIndex]).setAcceptingAnyClients(false);
            }
            else {
                for (int i = 0; i < ((VIPQueue)queues[vipQueueIndex]).getClientsInQueue().length; i++) {
                    if (((VIPQueue)queues[vipQueueIndex]).getClientsInQueue()[i] != null) {
                        ((VIPQueue)queues[vipQueueIndex]).setAcceptingAnyClients(false);
                        break;
                    }
                }
            }
        }

        //move clients from waiting line to queues if possible
        for (int j = 0; j < waitingLine.length; j++) {
            if (waitingLine[j] != null) {
                for (int k = 0; k < queues.length; k++) {
                    //if server is vip server and only accepting any clients false, add vip client
                    if (queues[k] instanceof VIPQueue && ((VIPQueue)queues[k]).getAcceptingAnyClients() == false) {
                        if (waitingLine[j] instanceof VIPClient && queues[k].getClientBeingServed() == null) {
                            queues[k].setClientBeingServed(waitingLine[j]); 
                            queues[k].setProcessingStartTime(clock);
                            waitingLine[j] = null;
                            break;
                        }
                    }
                    //if a server is empty, send straight to server
                    else {
                        if (queues[k].getClientBeingServed() == null) {
                            queues[k].setClientBeingServed(waitingLine[j]); 
                            queues[k].setProcessingStartTime(clock);
                            waitingLine[j] = null;
                            break;
                        }
                    }
                }
            }
            if (waitingLine[j] != null) {
                for (int i = 0; i < queues.length; i++) {
                    if (queues[i] instanceof VIPQueue && ((VIPQueue)queues[i]).getAcceptingAnyClients() == false) {
                        for (int l = 0; l < queues[i].getQueueSize(); l++) {
                            if (waitingLine[j] instanceof VIPClient && queues[i].getClientsInQueue()[l] == null) {
                                queues[i].getClientsInQueue()[l] = waitingLine[j];
                                waitingLine[j] = null;
                                break;
                            }
                        }
                    }
                    else {
                        //else, send to the queue with most empty slots or closest queue
                        for (int l = 0; l < queues[i].getQueueSize(); l++) {
                            if (queues[i].getClientsInQueue()[l] == null) {
                                queues[i].getClientsInQueue()[l] = waitingLine[j];
                                waitingLine[j] = null;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        if (clientsArrived.length > 0) {
            //if no client being served, send client to server
            for (int i = 0; i < clientsArrived.length; i++) {
                if (clientsArrived[i] != null) {
                    for (int j = 0; j < queues.length; j++) {
                        if (queues[j] instanceof VIPQueue && ((VIPQueue)queues[j]).getAcceptingAnyClients() == false) {
                            if (clientsArrived[i] instanceof VIPClient && queues[j].getClientBeingServed() == null) {
                                queues[j].setClientBeingServed(clientsArrived[i]);
                                queues[j].setProcessingStartTime(clock);
                                clientsArrived[i] = null;
                                break;
                            }
                        }
                        else {
                            if (queues[j].getClientBeingServed() == null) {
                                queues[j].setClientBeingServed(clientsArrived[i]);
                                queues[j].setProcessingStartTime(clock);
                                clientsArrived[i] = null;
                                break;
                            }
                        }
                    }
                }
            }
            //if there are still clients arrived, put them into queues
            for (int i = 0; i < clientsArrived.length; i++) {
                if (clientsArrived[i] != null) {
                    for (int j = 0; j < queues.length; j++) {
                        if (queues[j] instanceof VIPQueue && ((VIPQueue)queues[j]).getAcceptingAnyClients() == false) {
                            for (int l = 0; l < queues[j].getQueueSize(); l++) {
                                if (clientsArrived[i] instanceof VIPClient && queues[j].getClientsInQueue()[l] == null) {
                                    queues[j].getClientsInQueue()[l] = clientsArrived[i];
                                    clientsArrived[i] = null;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (clientsArrived[i] != null) {
                    for (int j = 0; j < queues[0].getClientsInQueue().length; j++) {
                        for ( int k = 0; k < queues.length; k++) {
                            if (queues[k].getClientsInQueue()[j] == null) {
                                queues[k].getClientsInQueue()[j] = clientsArrived[i];
                                clientsArrived[i] = null;
                                break;
                            }
                        }
                    }
                }
            }
            //if there are still clients arrived; put them into waiting line
            for (int i = 0; i < clientsArrived.length; i++) {
                if (clientsArrived[i] != null) {
                    for (int j = 0; j < waitingLine.length; j++) {
                        if (waitingLine[j] == null) {
                            waitingLine[j] = clientsArrived[i];
                            clientsArrived[i] = null;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void IncreaseTime(int time) {
        while (time > 0) {
            increaseTime();
            time--;
        }
    }

    public Client[] getClientsBeingServed() {
        int numClientsBeingServed = 0;

        for (int i = 0; i < queues.length; i++) {
            if (queues[i].getClientBeingServed() != null) {
                numClientsBeingServed++;
            }
        }

        Client[] result = new Client[numClientsBeingServed];
        int shift = 0;
        for (int i = 0; i < queues.length; i++) {
            if (queues[i].getClientBeingServed() == null) {
                shift++;
            }
            else {
                result[i] = queues[i - shift].getClientBeingServed();
            }
        }

        return result;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < queues.length; i++) {
            result += queues[i].toString(false) + "\n";
        }
        result += "---\n[Waiting Line]-";
        for (int i = 0; i < waitingLine.length; i++) {
            if (waitingLine[i] != null) {
                if (waitingLine[i].serviceTime() < 10) {
                    result += "[0" + waitingLine[i].serviceTime() + "]";
                }
                else {
                    result += "[" + waitingLine[i].serviceTime() + "]";
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
        if (showID) {
            for (int i = 0; i < queues.length; i++) {
                result += queues[i].toString() + "\n";
            }
            result += "---\n[Waiting Line]-";
            for (int i = 0; i < waitingLine.length; i++) {
                if (waitingLine[i] != null) {
                    if (waitingLine[i].getId() < 10) {
                        result += "[0" + waitingLine[i].getId() + "]";
                    }
                    else {
                        result += "[" + waitingLine[i].getId() + "]";
                    }
                }
                else {
                    result += "[  ]";
                }
            }
        }
        return result;
    }
    
}