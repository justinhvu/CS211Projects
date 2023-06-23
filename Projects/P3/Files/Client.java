public class Client {
    //fields
    private int id;
    private static int uniqueId = 1;
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private Gender gender;
    private Request[] requests;
    private int arrivalTime;
    private int waitingTime;
    private int timeInQueue;
    private int serviceTime;
    private int departureTime;
    private int patience;

    //getters and setters
    public int getId() {
        return this.id;
    }

    public void setId() {
        this.id = uniqueId;
        uniqueId++;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (gender.equals("MALE")) {
            this.gender = Gender.MALE;
        }
        else if (gender.equals("FEMALE")) {
            this.gender = Gender.FEMALE;
        }
    }

    public Request[] getRequests() {
        return this.requests;
    }

    public void setRequests(Request[] requests) {
        this.requests = requests;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        if (arrivalTime < 1) {
            this.arrivalTime = QueueSystem.getClock();
        }
        else {
            this.arrivalTime = arrivalTime;
        }
    }

    public int getWaitingTime() {
        return this.waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        if (waitingTime < 0) {
            this.waitingTime = 0;
        }
        else {
            this.waitingTime = waitingTime;
        }
    }

    public int getTimeInQueue() {
        return this.timeInQueue;
    }

    public void setTimeInQueue(int timeInQueue) {
        if (timeInQueue < 0) {
            this.timeInQueue = 0;
        }
        else {
            this.timeInQueue = timeInQueue;
        }
    }

    public int getServiceTime() {
        return this.serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(int departureTime) {
        /*
         * departureTime either zero, or
         * if client leave without being served:
         *  arrivalTime + waitingTime + timeInQueue
         */
        if (waitingTime + timeInQueue >= patience) {
            this.departureTime = QueueSystem.getClock();
        }
        else {
            this.departureTime = departureTime;
        }
    }

    public int getPatience() {
        return this.patience;
    }

    public void setPatience(int patience) {
        if (QueueSystem.getTvInWaitingArea()) {
            patience += 20;
        }
        if (QueueSystem.getCoffeeInWaitingArea() && (2023 - yearOfBirth >= 18)) {
            patience += 15;
        }

        this.patience = patience;
    }

    //constructors
    public Client(String firstName, String lastName, int yearOfBirth, String gender, int arrivalTime, int patience, Request[] requests) {
        setId();
        setFirstName(firstName);
        setLastName(lastName);
        setYearOfBirth(yearOfBirth);
        setGender(gender);
        setArrivalTime(arrivalTime);
        setPatience(patience);
        setRequests(requests);

        this.waitingTime = 0;
        this.timeInQueue = 0;
        this.serviceTime = 0;
        this.departureTime = 0;
    }

    public Client(String firstName, String lastName, int yearOfBirth, String gender, int patience, Request[] requests) {
        setId();
        setFirstName(firstName);
        setLastName(lastName);
        setYearOfBirth(yearOfBirth);
        setGender(gender);
        setPatience(patience);
        setRequests(requests);

        this.arrivalTime = QueueSystem.getClock();
        this.waitingTime = 0;
        this.timeInQueue = 0;
        this.serviceTime = 0;
        this.departureTime = 0;
    }

    public Client(String firstName, String lastName, int yearOfBirth, String gender, int patience) {
        setId();
        setFirstName(firstName);
        setLastName(lastName);
        setYearOfBirth(yearOfBirth);
        setGender(gender);
        setPatience(patience);

        this.arrivalTime = QueueSystem.getClock();
        this.waitingTime = 0;
        this.timeInQueue = 0;
        this.serviceTime = 0;
        this.departureTime = 0;
    }

    private String getServerName() {
        String serverName = "";
        boolean serverNameFound = false;
        //go through queues
        for (int i = 0; i < QueueSystem.getQueues().length; i++) {
            //check the client being served
           if (QueueSystem.getQueues()[i].getClientBeingServed() != null) {
                if (QueueSystem.getQueues()[i].getClientBeingServed().getId() == this.id) {
                    serverName = QueueSystem.getQueues()[i].getServerName();
                    break;
                }
           }
           //if not found yet, check the server's history
            for (int j = 0; j < QueueSystem.getQueues()[i].getClientsHistory().length; j++) {
                if (QueueSystem.getQueues()[i].getClientsHistory() != null) {
                    if (QueueSystem.getQueues()[i].getClientsHistory()[j].getId() == this.id) {
                        serverName = QueueSystem.getQueues()[i].getServerName();
                        serverNameFound = true;
                        break;
                    }
                }
            }
            if (serverNameFound) {
                break;
            }
        }
        
        return serverName;
    }

    public String toString() {
        return ("Client: " + lastName + ", " + firstName +
                "\n** Arrival Time    : " + arrivalTime +
                "\n** Waiting Time    : " + waitingTime +
                "\n** Time In Queue   : " + timeInQueue + 
                "\n** Service Time    : " + serviceTime() +
                "\n** Departure Time  : " + departureTime +
                "\n** Served By Server: " + getServerName() +
                "\n** Service Level   : " + estimateServiceLevel());
    }

    public int serviceTime() {
        int result = 0;
        if (requests != null) {
            for (int i = 0; i < requests.length; i++) {
                result += requests[i].calculateProcessingTime();
            }
        }

        setServiceTime(result);
        return result;
    }

    public int estimateServiceLevel() {
        int serviceLevel = 10;

        if (this.departureTime == 0) {
            serviceLevel = -1;
            for (int i = 0; i < QueueSystem.getClientsWorld().length; i++) {
                if (QueueSystem.getClientsWorld()[i] != null && QueueSystem.getClientsWorld()[i].getId() == this.id) {
                    serviceLevel = 10;
                    break;
                }
            }
        }
        else {
            if (waitingTime > 4) serviceLevel--;
            if (waitingTime > 6) serviceLevel--;
            if (waitingTime > 8) serviceLevel--;
            if (waitingTime > 10) serviceLevel--;
            if (waitingTime > 12) serviceLevel--;

            if (timeInQueue > 4) serviceLevel--;
            if (timeInQueue > 6) serviceLevel--;
            if (timeInQueue > 8) serviceLevel--;
            if (timeInQueue > 10) serviceLevel--;
            if (timeInQueue > 12) serviceLevel--;
        }

        return serviceLevel;
    }
}
